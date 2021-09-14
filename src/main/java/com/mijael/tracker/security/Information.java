package com.mijael.tracker.security;

import com.mijael.tracker.beans.ClientType;
import com.mijael.tracker.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Information {

    private int clientId;
    private ClientService clientService;
    private LocalDateTime time;
    private ClientType clientType;
    private String clientName;

}