package com.operpagos.apicriptobaz.domain.useCase;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;

public interface ICriptoUseCase {

    CriptoResponseDto encrypt(String txt) throws Exception;

    CriptoResponseDto decrypt(String txt);

}
