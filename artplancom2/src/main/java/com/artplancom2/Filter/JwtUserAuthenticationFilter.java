package com.artplancom2.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.artplancom2.Component.JwtUtil;
import com.artplancom2.Service.UserService;

import io.jsonwebtoken.SignatureException;

@Component
public class JwtUserAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestTokenHeader = request.getHeader("Authorization");
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			String accessToken = requestTokenHeader.substring(7);

			try {
				String idAsString = jwtUtil.extractUsername(accessToken);
	            int id = Integer.parseInt(idAsString);
				UserDetails userDetails = userService.loadUserById(id);
				
				if(idAsString != null && SecurityContextHolder.getContext().getAuthentication()  == null) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				
			} catch(SignatureException e) {
				System.out.println("Wrong accessToken");
			}
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
