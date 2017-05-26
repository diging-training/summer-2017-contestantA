package edu.asu.diging.contestantA.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Toss {
	private String tossValue;
	
	public String beginToss()
	{
		String tossValue;
		Random rand = new Random();
		tossValue = Integer.toString((int)rand.nextInt(10000) + 0);
		setTossValue(tossValue);
		try {			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(tossValue.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i)
			{
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void setTossValue(String value)
	{
		tossValue = value;
	}
	
	public String getTossValue()
	{
		return tossValue;
	}
}
