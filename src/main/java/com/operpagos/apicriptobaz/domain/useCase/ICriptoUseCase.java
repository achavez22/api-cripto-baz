package com.operpagos.apicriptobaz.domain.useCase;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;

public interface ICriptoUseCase {

    CriptoResponseDto encrypt(String txt);

    CriptoResponseDto decrypt(String txt);

}
