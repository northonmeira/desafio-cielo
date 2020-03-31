package com.desafio.cielo.gateway.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TotalControleLancamento {

    private int quantidadeLancamentos;
    private int quantidadeRemessas;
    private Double valorLancamentos;

}
