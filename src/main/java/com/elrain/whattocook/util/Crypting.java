package com.elrain.whattocook.util;

import com.sun.jersey.core.util.Base64;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * Created by elrain on 15.07.15.
 */
public class Crypting {

    private static final char[] PASSWORD = "zEvXFvOccr2P5AYmczQr".toCharArray();
    private static final byte[] SALT = {
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
            (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };
    private static final String ALGORITHM = "PBEWithMD5AndDES";
    private static final String CHARSET_NAME = "UTF-8";
    private static final int ITERATION_COUNT = 20;

    public static boolean checkPassword(String userPassword, String dbPassword) throws GeneralSecurityException, IOException {
        return BCrypt.checkpw(decrypt(userPassword), dbPassword);
    }

    public static String encrypt(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance(ALGORITHM);
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, ITERATION_COUNT));
        return new String(pbeCipher.doFinal(base64Decode(property)), CHARSET_NAME);
    }

    private static byte[] base64Decode(String property) throws IOException {
        return Base64.decode(property);
    }
}
