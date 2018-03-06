package com.ccclubs.admin.util;

import com.ccclubs.admin.constants.AttachmentConst;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Security;
import java.util.Map;
import java.util.Properties;

/**
 * @since 2016/11/21 20:44 jianghaiyang
 */
@Component
public class SendMailService {

    @Value("${email.host}")
    private String HOSTNAME;     //邮件服务器

    //@Value("${email.port}")
    private boolean isValidate;     //是否需要认证

    //@Value("${email.port}")
    private int PORT = 465;     //邮件服务器发送端口

    @Value("${email.smtp_username}")
    private String SMTP_USERNAME; //发件人用户名

    @Value("${email.smtp_password}")
    private String SMTP_PASSWORD; //发件人密码

    @Value("${email.sender_name}")
    private String USERNAME;     //发件人显示姓名

    @Value("${email.ecoding}")
    private String CODING;       //编码格式

    /**
     * @param toEmail ：收件人地址
     * @param subject ：主题
     * @param msg     ：内容
     * @return void
     * @throws
     * @Title: simpleEmail
     * @Description: 简单发送
     */
    public void sendSimpleEmail(String toEmail, String subject, String msg) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(HOSTNAME);
        email.setAuthentication(SMTP_USERNAME, SMTP_PASSWORD);// 邮件服务器验证
        email.setCharset(CODING);
        email.setSmtpPort(PORT);
        email.addTo(toEmail);
        email.setFrom(SMTP_USERNAME, USERNAME);
        email.setSubject(subject);
        email.setMsg(msg);
        email.send();

    }

    /**
     * @param toEmail        ：收件人地址
     * @param subject        ：主题
     * @param msg            ：内容
     * @param attachmentProp ：附件信息
     * @return void
     * @throws
     * @Title: multiPartEmail
     * @Description: 附件发送
     */
    public void sendMultiPartEmail(String toEmail, String ccEmail, String subject,
                                   String msg, Map<String, String> attachmentProp) throws EmailException, MalformedURLException {
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(HOSTNAME);
        email.setAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
        email.setCharset(CODING);
        email.setSmtpPort(465);
        //SSL
        Authenticator authenticator = null;
        Properties pro = new Properties();
        pro.put("mail.smtp.host", HOSTNAME);
        pro.put("mail.smtp.starttls.enable", true);
        pro.put("mail.smtp.auth", isValidate);
        if("465".equals(PORT)){
            pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pro.put("mail.smtp.socketFactory.port", PORT);
        }else{
            pro.put("mail.smtp.port", PORT);
        }
        if(isValidate){
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
                }
            };
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        email.setSslSmtpPort(String.valueOf(465));
        email.setSSLOnConnect(true);
        email.setSSLCheckServerIdentity(true);
        email.setMailSession(sendMailSession);
        email.addTo(toEmail.split(","));
        if(StringUtils.isNotEmpty(ccEmail)){
            email.addBcc(ccEmail.split(","));
        }
        email.setFrom(SMTP_USERNAME, USERNAME);
        email.setSubject(subject);
        email.setMsg(msg);
        EmailAttachment attachment = new EmailAttachment();
        if ("false".equals(attachmentProp.get(AttachmentConst.IS_REMOTE))) {
            // 本地文件d:/xxx.doc
            attachment.setPath(attachmentProp.get(AttachmentConst.LOCAL_FILE_PATH));
        } else {
            // 远程文件filePath
            attachment.setURL(new URL(attachmentProp.get(AttachmentConst.REMOTE_FILE_PATH)));
        }

        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(attachmentProp.get(AttachmentConst.DESCRIPTION));
        attachment.setName(attachmentProp.get(AttachmentConst.FILE_NAME));
        email.attach(attachment);
        email.send();

    }

    /**
     * @param toEmail ：收件人地址
     * @param subject ：主题
     * @param msg     ：内容
     * @return void
     * @throws
     * @Title: htmlEmail
     * @Description: HTML发送
     */
    public void sendHtmlEmail(String toEmail, String ccEmail, String bccEmail, String subject, String msg) throws EmailException {

        HtmlEmail email = new HtmlEmail();
        email.setHostName(HOSTNAME);
        email.setAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
        email.setCharset(CODING);
        email.setSmtpPort(PORT);
        email.addTo(toEmail.split(","));
        email.addCc(ccEmail.split(","));
        if(StringUtils.isNotEmpty(bccEmail)){
            email.addBcc(bccEmail.split(","));
        }
        email.setFrom(SMTP_USERNAME, USERNAME);
        email.setSubject(subject);
        email.setHtmlMsg(msg);
        email.send();

    }

    public void sslSend(String toEmail, String ccEmail, String subject,
                                            String msg, Map<String, String> attachmentProp) throws EmailException, MalformedURLException {
        MailConfig mailInfo = new MailConfig();
        mailInfo.setMailServerHost(HOSTNAME);
        mailInfo.setMailServerPort(String.valueOf(PORT));
        mailInfo.setValidate(true);
        mailInfo.setUserName(SMTP_USERNAME);
        mailInfo.setPassword(SMTP_PASSWORD);
        mailInfo.setFromAddress(SMTP_USERNAME);
        mailInfo.setToAddress(toEmail.split(","));
        mailInfo.setToCarbonCopyAddress(ccEmail.split(","));
        mailInfo.setAttachFileNames(new String[]{attachmentProp.get(AttachmentConst.LOCAL_FILE_PATH)});
        mailInfo.setSubject(subject);
        mailInfo.setContent(msg);

        SendMailUtil.sendMail(mailInfo);
    }
}
