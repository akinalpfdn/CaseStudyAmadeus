package com.Amadeus.CaseStudy.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Amadeus.CaseStudy.model.Token;
import com.Amadeus.CaseStudy.repositories.TokenRepository;

@Service
public class AuthService {

	@Autowired
	private TokenRepository tokenRepository;
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

	public String generateToken() {
		int length = 150;
        String randomString = generateRandomString(length);
        registerToken(randomString);
		return randomString;
	}
	

    public static String generateRandomString(int length) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
	
	 private void registerToken(String tokenString)
	 {
		 Token token = new Token();
		 token.setToken(tokenString);
		 token.setExpireDate(LocalDateTime.now().plusMinutes(30));
		 tokenRepository.save(token);
	 }


	public boolean isValidToken(String tokenValue) {
		
		var tokens = tokenRepository.getByToken(tokenValue);
		for (Token token : tokens) {
		    // Your code here to process each element
		    if(token.getExpireDate().compareTo(LocalDateTime.now())>0)
		    {
		    	return true;
		    }
		}
		return false;
	}
}
