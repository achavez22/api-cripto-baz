package com.operpagos.apicriptobaz.domain.useCase;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;

public interface ICriptoUseCase {

    CriptoResponseDto encript(String txt);

    CriptoResponseDto decript(String txt);

}
