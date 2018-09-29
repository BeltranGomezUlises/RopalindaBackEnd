package com.ub.ropalinda.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ulises Beltrán Gómez --- beltrangomezulises@gmail.com
 */
public class UtilsSecurity {

    /**
     * Encodes in a hexadecimal hash the string data
     *
     * @param data string to encode
     * @return hexadecimal hash
     */
    public static String encodeSHA256(String data) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    data.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UtilsSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Converts a byte array in string
     *
     * @param hash byte array to convert
     * @return string representation of the hash
     */
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
