package com.desafio.cielo.gateway.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Builder
@Getter
@Setter
public class LancamentoContaCorrenteCliente {

    private BigInteger numeroRemessaBanco;
    private String nomeSituacaoRemessa;
    private DadosDomicilioBancario dadosDomicilioBancario;
    private String nomeTipoOperacao;

}
