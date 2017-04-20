package com.pzj.base.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.crypto.SecretKey;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 * Created with IntelliJ IDEA. User : eric Date: 13-12-10 Time: 下午5:57 To change
 * this template use File | Settings | File Templates.
 */
public class DesUtils {

	static SecretKey securekey = null;

	private final static String password = "8jG_1ejG776";

	public static byte[] encrypt(byte[] src) throws Exception {
		return transform(true, src);
	}

	public static byte[] decrypt(byte[] src) throws Exception {
		return transform(false, src);
	}

	public final static String decrypt(String data) {
		try {
			return new String(decrypt(hex2byte(data.getBytes("UTF-8"))));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public final static String encrypt(String password) {
		try {
			return byte2hex(encrypt(password.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public final static String myEncrypt(String password) {
		try {
			return password;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	private static byte[] transform(boolean encrypt, byte[] inputBytes)
			throws Exception {
		byte[] key = DigestUtils.md5(password.getBytes("UTF-8"));

		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CBCBlockCipher(new AESFastEngine()));
		cipher.init(encrypt, new KeyParameter(key));

		ByteArrayInputStream input = new ByteArrayInputStream(inputBytes);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		int inputLen;
		int outputLen;

		byte[] inputBuffer = new byte[1024];
		byte[] outputBuffer = new byte[cipher.getOutputSize(inputBuffer.length)];

		while ((inputLen = input.read(inputBuffer)) > -1) {
			outputLen = cipher.processBytes(inputBuffer, 0, inputLen,
					outputBuffer, 0);
			if (outputLen > 0) {
				output.write(outputBuffer, 0, outputLen);
			}
		}

		outputLen = cipher.doFinal(outputBuffer, 0);
		if (outputLen > 0) {
			output.write(outputBuffer, 0, outputLen);
		}

		return output.toByteArray();
	}

	public static byte[] hex2byte(byte[] b) {

		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("IllegalArgumentException");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	public static void main(String[] args) {
		System.out
				.println(decrypt("594F8C9F6E0E442D31BB30A6B3D51A2F2053EBE2A9657A6F8E8BC19FA347539E709CB86B72C1398C206D7AE9CDFCE82C8C0D9CB209D3FC49570EAF6B4B5A5D10A05B9A5FC33AFC9CB9E688F7DB414671731CD7749694B0C77C816C6E79B2E1D355C7D04C9B6112BEE456F8F2B5C5346AA8DC99F6C4483B2D467D164217CE12CC81544EFCC38CAAF2BDB7B52CE2D1F4F6D38E2B7DE4FB70A8DC497B8219320141FF811ACBB6C566814AA944262D08B06AA8F93BA60380FC8B4552000EC06B5CBBC4164BFD70D53139EC1D4900573AED185B9F3540758D2E1DC83B42FB21D5C2094CDC5686B8EBAEE8AEF44A8874D93D0FD54BD8095E7DA2E8D451C9FF371F233FB08EF311316EA0272F7D77569C1A4D884CFB09B6605EBF07EB83D5AD42841C6A"));
		System.out.println(encrypt("1111"));
	}
}
