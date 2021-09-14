package com.mijael.tracker.security;

import com.mijael.tracker.beans.ClientType;
import com.mijael.tracker.exceptions.TokenErrorException;
import com.mijael.tracker.services.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@Data
public class TokenManager {

    @Autowired
    private Map<String, Information> map;

    public ClientService getService(String token){
        Information information = map.get(token);
        return information.getClientService();
    }


    public String addToken(ClientService clientService, ClientType clientType, int clientId, String clientName) {
        removePreviewsTokenById(clientId);
        String token = UUID.randomUUID().toString();
        Information information = Information
                .builder()
                .clientService(clientService)
                .time(LocalDateTime.now())
                .clientType(clientType)
                .clientId(clientId)
                .clientName(clientName)
                .build();
        map.put(token, information);
        System.out.println("from Add token " + map.get(token));
        return token;
    }

    public void deleteToken(String token) {
        map.remove(token);
        System.out.println("token from tm map" + map.get(token));
    }

    public boolean isExist(String token) throws TokenErrorException {
        System.out.println("isExist - token"+ token);
        System.out.println(map.get(token));
        if (!map.containsKey(token)) {
            throw new TokenErrorException("Wrong token... try again");
        }
        return true;
    }

    public boolean isControllerAllowed( ClientType clientType,String token) {
        Information information = map.get(token);
        if (!information.getClientType().equals(clientType)) {
            throw new SecurityException("Wrong token... you should try again");
        }
        return true;
    }

    public void removePreviewsTokenById(int clientId) {
        map.entrySet().removeIf(valueToRemove -> valueToRemove.getValue().getClientId() == clientId);
    }

    public  void removeExpiredToken() {
        map.entrySet().removeIf(valueToRemove->valueToRemove.getValue().getTime().isAfter(LocalDateTime.now().minusMinutes(30)));
    }

}
