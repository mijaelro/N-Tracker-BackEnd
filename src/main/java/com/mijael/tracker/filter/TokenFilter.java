package com.mijael.tracker.filter;

import com.mijael.tracker.beans.ClientType;
import com.mijael.tracker.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(2)
@Component
@RequiredArgsConstructor
public class TokenFilter implements Filter {

    private final TokenManager tokenManager;
    private final static String ADMIN = "admin";
    private final static String USER = "user";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println("url : " + url);


        if (    url.endsWith("login")
                || url.endsWith("signup")
                ||url.endsWith("home")
                ||url.endsWith("/")
                ||url.endsWith("*")
        )
        {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        try {
            String token;
            token = ((HttpServletRequest) servletRequest).getHeader("Authorization");
            String type = FilterHelper.getType(url);
            System.out.println("type : " + type);

            switch (type) {
                case ADMIN:
                    tokenManager.isExist(token);
                    tokenManager.isControllerAllowed(ClientType.ADMINISTRATOR,token);
                    break;
                case USER:
                    tokenManager.isExist(token);
                    tokenManager.isControllerAllowed( ClientType.USER,token);
                    break;

            }
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
            ((HttpServletResponse) servletResponse).sendError(401, e.getMessage());

        }
    }
}

