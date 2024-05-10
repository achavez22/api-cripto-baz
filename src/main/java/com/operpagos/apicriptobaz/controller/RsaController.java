package com.operpagos.apicriptobaz.controller;

import com.operpagos.apicriptobaz.domain.dto.RsaRequestDto;
import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoRsaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "rsa")
public class RsaController {
    private final ICriptoRsaUseCase rsaUseCase;

    @PostMapping(path = "/encrypt64",consumes = "application/json")
    public ResponseEntity<RsaResponseDto> encrypt(@RequestBody RsaRequestDto request){
        try {
            return ResponseEntity.ok(rsaUseCase.encrypt64(request.getText(), request.getKey()));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/decrypt64",consumes = "application/json")
    public ResponseEntity<RsaResponseDto> decrypt(@RequestBody RsaRequestDto request){
        try {
            return ResponseEntity.ok(rsaUseCase.decrypt64(request.getText(), request.getKey()));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
