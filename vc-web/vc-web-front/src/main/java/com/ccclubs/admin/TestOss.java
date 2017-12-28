package com.ccclubs.admin;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

@Component
public class TestOss {

    @Autowired
    OSSClient ossClient;

    static String filePath="C:\\Users\\mrfj\\Desktop\\demo-oss-master\\upload\\sonic.jpg";
    public void runTest(){
        try {
            this.putObject("oss-vc",filePath,"alban/oss-test-sonic.jpg");
            this.ossClient.shutdown();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("检查结果："+this.checkObject("oss-vc","alban/oss-test-sonic.jpg"));
    }


    public String putObject(String bucket, String filePath, String fileKey) throws FileNotFoundException {
        if (fileKey == null) {
            fileKey = UUID.randomUUID().toString().replaceAll("-", "") + filePath.substring(filePath.lastIndexOf("."));
        }

        ossClient.putObject(bucket, fileKey, new File(filePath));

        //logger.info("OSS putObject success! fileKey={}", fileKey);
        return fileKey;
    }

    public boolean checkObject(String bucket, String fileKey) {
        return ossClient.doesObjectExist(bucket, fileKey);
    }

    public static TestOss getFromApplication(){

        return AppContext.CTX.getBean(TestOss.class);

    }
}
