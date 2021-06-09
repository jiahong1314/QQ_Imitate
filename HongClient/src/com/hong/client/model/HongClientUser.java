package com.hong.client.model;

import com.hong.common.User;

public class HongClientUser {

	public boolean CheckUser(User user) {

		return new HongClientConnectServer().sendLoginInfoToServer(user);
	}

}
