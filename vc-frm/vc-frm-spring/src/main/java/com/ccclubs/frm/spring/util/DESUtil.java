package com.ccclubs.frm.spring.util;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



/**
 * DES 取得密钥 加密 解密
 * @author qdz
 * @createDate 2017年7月20日 上午10:06:31
 */
public class DESUtil {
	
	/**
	 * 算法密钥 
	 */
	private static final String ALGORITHMKEY = "DESede";
	
	/**
	 * 加密算法/工作模式/填充模式
	 */
	private static final String ALGORITHM_STR = "DESede/ECB/PKCS5Padding";
	
	/**
	 * 编码
	 */
	private static final String CODING = "UTF-8";

//	private static Cipher cipher = null;
	
	
	
//	static{
//		try {
//			if( cipher == null){
//				cipher = Cipher.getInstance(ALGORITHM_STR);
//			}
//		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
//			e.printStackTrace();
//		}
//	}
//	
	/**
	 * 生成密钥
	 * @return
	 * @throws Exception 
	 */
	public static String generateKey() throws Exception{
		KeyGenerator kg = KeyGenerator.getInstance(ALGORITHMKEY);
		kg.init(128);
		//生成密钥
		SecretKey sk = kg.generateKey();
		return Base64.encodeBase64String(sk.getEncoded());
	}
	
	 /** 
     * DES加密 
     * @param source    源字符串 
     * @param key   密钥 
     * @return  加密后的密文 
     * @throws Exception 
     */  
    public static String encrypt(String source, String key) throws Exception {
        byte[] sourceBytes = source.getBytes(CODING);
        
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR); 
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("iso-8859-1"), ALGORITHMKEY)); 
        
        byte[] decrypted = cipher.doFinal(sourceBytes);
        return Base64.encodeBase64String(decrypted);  
    }  
	
	 /** 
     * AES解密 
     * @param encryptStr    加密后的密文 
     * @param key   密钥 
     * @return  源字符串 
     * @throws Exception 
     */  
    public static String decrypt(String encryptStr, String key) throws Exception {  
        byte[] sourceBytes = Base64.decodeBase64(encryptStr); 
        
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("iso-8859-1"), ALGORITHMKEY));    

        byte[] decoded = cipher.doFinal(sourceBytes);    
        return new String(decoded, CODING);  
    }  
	
	
}
