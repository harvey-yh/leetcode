import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/27
 * Time: 14:19
 * Description:
 */
public class EncryptUtil {

    /**
     * 这里采用DES加密解密的方式
     */
    private static final byte[] DES_KEY = {21, 1, -110, 82, -32, -85, -128, -65};

    /**
     * 加密
     *
     * @param plainText 明文
     * @return
     */
    public static String encrypt(String plainText) {
        String cipherText = null;
        try {
            SecureRandom secureRandom = new SecureRandom();
            DESKeySpec desKeySpec = new DESKeySpec(DES_KEY);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
            // 加密过后再用Base64编码
            BASE64Encoder base64Encoder = new BASE64Encoder();
            cipherText = base64Encoder.encode(cipher.doFinal(plainText.getBytes()));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return cipherText;
    }

    /**
     * 解密
     *
     * @param cipherText 密文
     * @return
     */
    public static String decrypt(String cipherText) {
        String plainText = null;
        try {
            SecureRandom secureRandom = new SecureRandom();
            DESKeySpec desKeySpec = new DESKeySpec(DES_KEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, secureRandom);
            // 用BASE64Decoder解码
            BASE64Decoder base64Decoder = new BASE64Decoder();
            plainText = new String(cipher.doFinal(base64Decoder.decodeBuffer(cipherText)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return plainText;
    }

    /**
     * base64解码
     *
     * @param encodedText
     * @return
     */
    public static String base64Decode(String encodedText) {
        byte[] bt = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer(encodedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bt);
    }

    /**
     * base64编码
     * @param plainText
     * @return
     */
    public static String base64Encode(String plainText){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(plainText.getBytes());
    }
    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(encrypt("123456"));
        System.out.println(decrypt("x16YjoF1LNE="));
    }
}
