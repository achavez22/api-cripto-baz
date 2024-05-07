package com.operpagos.apicriptobaz.domain.useCase;

import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;

import javax.crypto.NoSuchPaddingException;

public interface ICriptoRsaUseCase {
    RsaResponseDto encrypt64(String text, String publicKey) throws NoSuchPaddingException, Exception;

    RsaResponseDto decrypt64(String text, String privateKey) throws Exception;


}
