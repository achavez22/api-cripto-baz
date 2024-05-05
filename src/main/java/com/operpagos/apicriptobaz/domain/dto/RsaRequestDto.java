package com.operpagos.apicriptobaz.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RsaRequestDto {
    private String text;
    private String key;
}
