// FrontEnd Plus GUI for JAD
// DeCompiled : MD5Utils.class

package com.pzj.base.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class MD5Utils {

    private MD5Utils() {
    }

    private static MessageDigest getMD5DigestAlgorithm()
            throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }

    public static byte[] getMD5Digest(byte source[])
            throws NoSuchAlgorithmException {
        return getMD5DigestAlgorithm().digest(source);
    }

    public static byte[] getMD5Digest(String source)
            throws NoSuchAlgorithmException {
        return getMD5Digest(source.getBytes());
    }

    public static String getMD5DigestHex(byte source[])
            throws NoSuchAlgorithmException {
        return new String(Hex.encodeHex(getMD5Digest(source)));
    }

    public static String getMD5DigestHex(String source) {
        String tmp = "";
        try {
            tmp = new String(Hex.encodeHex(getMD5Digest(source)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public static String getMD5DigestBase64(byte source[]) {
        String tmp = "";
        try {
            tmp = new String(Base64.encodeBase64(getMD5Digest(source)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public static String getMD5DigestBase64(String source)
            throws NoSuchAlgorithmException {
        return new String(Base64.encodeBase64(getMD5Digest(source)));
    }
}
