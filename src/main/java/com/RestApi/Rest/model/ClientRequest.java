package com.RestApi.Rest.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientRequest {

    private Long id;
    private String name;
    private String host;
    private String port;
    private Long expiryAfterMillis;
}
