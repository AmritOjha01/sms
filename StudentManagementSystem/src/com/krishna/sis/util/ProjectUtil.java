package com.krishna.sis.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public class ProjectUtil {

		private static SecureRandom random = new SecureRandom();

		public static String newPassword() {
			return new BigInteger(50, random).toString(32);
	}
	
}
