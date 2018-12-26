package com.yk.iworkgo.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DataServiceConstant {

    @Value("${client_id}")
    private String clientId;

    @Value("${client_secret}")
    private String clientSecret;

    @Value("${IPPort}")
    private String IPPort;

    @Value("${getToken}")
    private String getToken;
}
