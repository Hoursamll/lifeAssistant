package com.szdx.lifeAssistant.common.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 */
@Service
@Lazy(false)
public class IdGen {


	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	/*public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}*/

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	public static String uuid() {
		Date date = new Date();
		long timeMill = date.getTime();
		Random rand = new Random(timeMill);
		StringBuilder sb = new StringBuilder(rand.nextInt(50));
		for(int i=0; i < 3; i++)
		sb.append((char)('0' + rand.nextInt(10)));
		return sb.toString();
	}

}
