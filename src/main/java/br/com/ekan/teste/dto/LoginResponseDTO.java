package br.com.ekan.teste.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {

    private String token;

    private long expiresIn;
}
