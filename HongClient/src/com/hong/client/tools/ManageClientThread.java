package com.hong.client.tools;

import java.util.HashMap;

public class ManageClientThread {

	private static HashMap<String, ClientServerThread> hm = new HashMap<>();

	public static void setThread(String qqId, ClientServerThread cst) {
		hm.put(qqId, cst);
	}

	public static ClientServerThread geThread(String qqId) {
		return hm.get(qqId);
	}
}
