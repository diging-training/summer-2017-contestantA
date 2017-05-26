package edu.asu.diging.contestantA.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class Toss {
	private String tossValue;
	final static Logger logger = Logger.getLogger(Toss.class);

	public String beginToss() {
		String tossValue;
		Random rand = new Random();
		tossValue = Integer.toString((int) rand.nextInt(10000) + 0);
		setTossValue(tossValue);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(tossValue.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			logger.error("No algorithm found " + e.getStackTrace());
		}

		return null;
	}

	private void setTossValue(String value) {
		tossValue = value;
	}

	public String getTossValue() {
		return tossValue;
	}
}
