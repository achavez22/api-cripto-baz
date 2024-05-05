package com.operpagos.apicriptobaz.controller;

import com.operpagos.apicriptobaz.domain.dto.RsaRequestDto;
import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.IRsaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "rsa")
public class RsaController {

    private final IRsaUseCase rsaUseCase;
    @PostMapping(path = "/encrypt64")
    public ResponseEntity<RsaResponseDto> encrypt(@RequestBody RsaRequestDto request){
            return ResponseEntity.ok(rsaUseCase.decrypt(request.getText(), request.getKey()));
    }

    @PostMapping(path = "/decrypt64")
    public ResponseEntity<RsaResponseDto> decrypt(@RequestBody RsaRequestDto request){
        return ResponseEntity.ok(rsaUseCase.encrypt(request.getText(), request.getKey()));
    }
}
