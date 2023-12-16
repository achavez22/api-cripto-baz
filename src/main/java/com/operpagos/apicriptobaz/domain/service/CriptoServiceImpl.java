package com.operpagos.apicriptobaz.domain.service;

import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoUseCase;
import org.operpagos.cripto.CriptoBAZ;
import org.springframework.stereotype.Service;

@Service
public class CriptoServiceImpl implements ICriptoUseCase {

    @Override
    public CriptoResponseDto encrypt(String txt) throws Exception {
        CriptoBAZ criptoBAZ = new CriptoBAZ();
        String result = criptoBAZ.encrypt(txt);
        return new CriptoResponseDto(result);
    }

    @Override
    public CriptoResponseDto decrypt(String txt) {
        CriptoBAZ criptoBAZ = new CriptoBAZ();
        String result = "";
        try {
            result = criptoBAZ.decrypt(txt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new CriptoResponseDto(result);
    }
}
