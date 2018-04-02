package com.qaqrz.onlinexam.util;

import java.text.*;
import java.util.*;

public class ToolUtil {
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sf.format(date);
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		return sf.format(date);
	}

	public static String arraytoString(String[] array) {
		StringBuffer s = new StringBuffer();
		if (null == array)
			return s.toString();
		for (int i = 0; i < array.length; i++) {
			s.append(array[i] + (i < array.length - 1 ? "," : ""));
		}
		return s.toString();
	}
}