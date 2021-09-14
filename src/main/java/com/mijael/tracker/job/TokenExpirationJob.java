package com.mijael.tracker.job;

import com.mijael.tracker.security.TokenManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import lombok.RequiredArgsConstructor;
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class TokenExpirationJob {

    private final TokenManager tokenManager;

    @Scheduled(initialDelay = 1000,fixedRate = 1000 *60*60 )

    public void removeExpiredTokens() {
        System.out.println("starting token expiration removal task..");
        tokenManager.removeExpiredToken();

    }
}