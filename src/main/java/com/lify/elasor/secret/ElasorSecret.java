package com.lify.elasor.secret;

import android.util.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Elasor
 */
@SuppressWarnings("unused")
public class ElasorSecret {

    public static String md5(String encodeStr) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(encodeStr.getBytes(Charset.forName("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("there is no such algorithm which named MD5!", e);
        }

        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            String s = String.format("%02x", b);
            hex.append(s);
        }
        return hex.toString();
    }

    //未测试
    public static String encodeBase64(String msg) {
        byte[] encode = Base64.encode(msg.getBytes(Charset.forName("utf-8")), Base64.NO_WRAP);
        return new String(encode, Charset.forName("utf-8"));
    }

    //未测试
    public static String decodeBase64(String secret) {
        return new String(Base64.decode(secret, Base64.DEFAULT), Charset.forName("utf-8"));
    }

    //未测试
    public static String encodeDES(String src, String keyStr) {
        String result = null;
        try {
            //根据算法和秘钥字符串，创建秘钥
            SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "DES");
            //根据算法创建密码对象
            Cipher cipher = Cipher.getInstance("DES");
            //指定为编码模式，指定秘钥
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //执行得到密文的字节数组
            byte[] bytes = cipher.doFinal(src.getBytes(Charset.forName("utf-8")));
            //密码也采用64种基本字符，否则会乱码
            result = Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //未测试
    public static String decodeDES(String secret, String keyStr) {
        String result = null;
        try {
            SecretKeySpec key = new SecretKeySpec(keyStr.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytes = cipher.doFinal(Base64.decode(secret, Base64.DEFAULT));
            result = new String(bytes, Charset.forName("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
