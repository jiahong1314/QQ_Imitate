package com.hong.server.model;

import java.util.HashMap;

public class ManageClientThread {

	public static HashMap<String, ServerClientThread> sMap = new HashMap<>();

	public static void addClientThread(String uid, ServerClientThread sct) {
		sMap.put(uid, sct);

	}

	public static ServerClientThread geClientThread(String uid) {
		return sMap.get(uid);
	}
}
