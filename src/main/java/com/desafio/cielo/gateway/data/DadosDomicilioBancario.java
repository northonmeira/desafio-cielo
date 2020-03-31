package com.desafio.cielo.gateway.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DadosDomicilioBancario {

    private Long codigoBanco;
    private Long numeroAgencia;
    private String numeroContaCorrente;
}
