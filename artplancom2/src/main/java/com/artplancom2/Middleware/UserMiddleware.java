package com.artplancom2.Middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.artplancom2.Component.JwtUtil;

public class UserMiddleware {

	@Autowired
	JwtUtil jwtUtil;
	
	public int getCurrentUserId() {
		int userId = 0;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userIdStr = authentication.getName();
		try {
			userId = Integer.parseInt(userIdStr);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userId;
	}
}
