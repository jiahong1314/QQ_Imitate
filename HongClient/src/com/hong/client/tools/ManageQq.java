package com.hong.client.tools;

import java.util.HashMap;

import com.hong.client.view.HongChat;

public class ManageQq {

	private static HashMap<String, HongChat> hm = new HashMap<>();

	public static void addQqChat(String id, HongChat hChat) {
		hm.put(id, hChat);
	}

	public static HongChat getQqChat(String id) {
		return hm.get(id);
	}
}
