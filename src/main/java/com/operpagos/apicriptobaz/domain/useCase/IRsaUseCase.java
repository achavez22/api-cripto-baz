package com.operpagos.apicriptobaz.domain.useCase;

import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;

public interface IRsaUseCase {
    RsaResponseDto encrypt(String text, String publicKey);
    RsaResponseDto decrypt(String text, String privateKey);


}
