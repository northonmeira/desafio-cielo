package com.desafio.cielo.http.controller;

import com.desafio.cielo.http.data.ExtratoResponse;
import com.desafio.cielo.service.useCase.ExtratoUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    private ExtratoUseCase extratoUseCase;

    public ExtratoController(ExtratoUseCase extratoUseCase) {
        this.extratoUseCase = extratoUseCase;
    }

    @ApiOperation(value = "Retorna um extrato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna extrato ok"),
            @ApiResponse(code = 500, message = "Ocorreu um erro interno"),
    })
    @GetMapping(path = "/lancamentosEmConta", produces = "application/json")
    public ResponseEntity<ExtratoResponse> getExtrato() {

        try {

            return ResponseEntity.ok(extratoUseCase.getExtrato());

        } catch (Exception e) {

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "erro: ", e);

        }
    }
}
