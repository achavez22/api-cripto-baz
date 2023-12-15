package com.operpagos.apicriptobaz.controller;

import com.operpagos.apicriptobaz.domain.dto.CriptoRequestDto;
import com.operpagos.apicriptobaz.domain.dto.CriptoResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "cripto")
public class CriptoController{

   private final ICriptoUseCase criptoUseCase;


   @PostMapping(path = "/encrypt")
   public ResponseEntity<CriptoResponseDto> encrypt(@RequestBody CriptoRequestDto request){
      return ResponseEntity.ok(criptoUseCase.encrypt(request.getTxtRequest()));
   }

}
