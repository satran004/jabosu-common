package org.jabosu.common.util;

import java.util.UUID;

public class UUIDGenerator {

	public static String getNextAvailableEventId() {
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
	public static String getUniqueActivationCode() {
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
	
}
