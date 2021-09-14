package com.mijael.tracker.controllers.models.req;

import com.mijael.tracker.beans.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;
}
