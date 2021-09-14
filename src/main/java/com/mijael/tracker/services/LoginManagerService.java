package com.mijael.tracker.services;

import com.mijael.tracker.beans.ClientType;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.serviceImpl.AdminServiceImpl;
import com.mijael.tracker.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@RequiredArgsConstructor
public class LoginManagerService {
    private final ApplicationContext ctx;
    private final TokenManager tokenManager;

    public String logIn(String email, String password, ClientType clientType) throws SecurityException, LoginException {

        ClientService clientService;

        switch (clientType) {
            case ADMINISTRATOR:
                AdminService adminService = ctx.getBean(AdminService.class);
                if (((AdminServiceImpl) adminService).logIn(email, password)) {
                    int adminId = 0;
                    String name = "ADMIN";
                    String token = tokenManager.addToken((ClientService) adminService, ClientType.ADMINISTRATOR, adminId,name);
                    return token;
                }
            case USER:
              UserService userService = ctx.getBean(UserService.class);
                if (((UserServiceImpl) userService).logIn(email, password)) {
                    int userId = (((UserServiceImpl) userService).getUserId());
                    String name = (((UserServiceImpl) userService).getUserName());
                    String token = tokenManager.addToken((ClientService) userService, ClientType.USER, userId ,name);
                    return token;
                }
        }
        throw new SecurityException("Error,Incorrect client type");
    }
}
