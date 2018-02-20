package com.userreview.util;

import java.util.ArrayList;
import java.util.List;

import com.userreview.model.User;

public class FileHandlingUtils {
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setUserName("test1");
		users.add(user);
	}

}
