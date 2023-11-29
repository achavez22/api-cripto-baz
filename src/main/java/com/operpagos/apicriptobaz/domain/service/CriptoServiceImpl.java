package com.operpagos.apicriptobaz.domain.service;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CriptoServiceImpl implements ICriptoUseCase {
    @Override
    public CriptoResponseDto encript(String txt) {

        String result = "";
        return new CriptoResponseDto(result);
    }

    @Override
    public CriptoResponseDto decript(String txt) {
        return null;
    }
}
