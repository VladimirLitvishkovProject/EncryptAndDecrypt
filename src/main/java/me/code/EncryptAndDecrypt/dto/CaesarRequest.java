package me.code.EncryptAndDecrypt.dto;
///

import lombok.Getter;


@Getter
public class CaesarRequest {
    
    private String code;
    
    private int coefficient;
    
    private String alfavit;
    
}
