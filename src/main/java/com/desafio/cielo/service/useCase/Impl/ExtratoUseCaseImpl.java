package com.desafio.cielo.service.useCase.Impl;

import com.desafio.cielo.gateway.legadoGateway.ExtratoGateway;
import com.desafio.cielo.http.data.ExtratoResponse;
import com.desafio.cielo.service.converter.ExtratoUseCaseConverter;
import com.desafio.cielo.service.useCase.ExtratoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExtratoUseCaseImpl implements ExtratoUseCase {

    private ExtratoGateway extratoGateway;

    private ExtratoUseCaseConverter converter;

    public ExtratoUseCaseImpl(ExtratoGateway extratoGateway, ExtratoUseCaseConverter converter) {
        this.extratoGateway = extratoGateway;
        this.converter = converter;
    }

    @Override
    public ExtratoResponse getExtrato() {

        return converter.toResponse(extratoGateway.getExtrato());
    }
}
