package com.mijael.tracker.controllers.models.resp;

import com.mijael.tracker.beans.ClientType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
public class LoginResponse {
    String token;
    @Enumerated(EnumType.STRING)
    ClientType clientType;
    String clientName;
    int clientId;
}
