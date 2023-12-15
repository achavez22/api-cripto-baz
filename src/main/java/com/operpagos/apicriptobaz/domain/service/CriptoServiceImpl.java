package com.operpagos.apicriptobaz.domain.service;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CriptoServiceImpl implements ICriptoUseCase {
    @Override
    public CriptoResponseDto encrypt(String txt) {
        String result = "TEST_RESPONSE";
        // TODO: implement CriptoBaz Library

        return new CriptoResponseDto(result);
    }

    @Override
    public CriptoResponseDto decrypt(String txt) {
        return null;
    }
}
