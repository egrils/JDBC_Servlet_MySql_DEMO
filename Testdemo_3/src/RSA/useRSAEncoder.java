package RSA;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import RSA.RSACoder;

public class useRSAEncoder {

//	public static String RSACoder(String Message,String publickey){

//		byte[] publicKey = Base64.decodeBase64(Message);
	
	public static void main(String args[]){
		String message = "你的";
		Map<String, Object> key;
		byte[] publicKey;
		byte[] privateKey;
		
		byte[] encryptMes;
		byte[] decryptMes;
		
		String encryptMessage = null;
		
		try {
			key = RSACoder.initKey();
			publicKey = RSACoder.getPublicKey(key);
			privateKey = RSACoder.getPrivateKey(key);
			System.out.println("公钥:\t" + publicKey);
			System.out.println("原文:\t" + message);
			
			// 公钥加密
			encryptMes = RSACoder.encryptByPublicKey(message.getBytes(), publicKey);
			encryptMessage = Base64.encodeBase64String(encryptMes);
			System.out.println("公钥加密后:\n" + encryptMessage);
			
		
			// 私钥解密
			decryptMes = RSACoder.decryptByPrivateKey(encryptMes, privateKey);
			String outputStr2 = new String(decryptMes);
			System.out.println("私钥解密后: " + outputStr2);
			
//			return encryptMessage;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return encryptMessage;
		
	}
	

	
}
