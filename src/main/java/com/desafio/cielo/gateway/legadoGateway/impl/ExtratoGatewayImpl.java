package com.desafio.cielo.gateway.legadoGateway.impl;

import com.desafio.cielo.gateway.data.Extrato;
import com.desafio.cielo.gateway.legadoGateway.ExtratoGateway;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;


@Service
public class ExtratoGatewayImpl implements ExtratoGateway {

    private ObjectMapper mapper;

    public ExtratoGatewayImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public Extrato getExtrato() {

        Extrato extrato = null;
        try {
            extrato = mapper.readValue(ResourceUtils.getFile("classpath:lancamento-conta-legado.json"), Extrato.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return extrato;

    }

}
