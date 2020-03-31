package com.desafio.cielo.gateway.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ControleLancamento {

    private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;
    private String dataEfetivaLancamento;
    private String dataLancamentoContaCorrenteCliente;
    private Long numeroEvento;
    private String descricaoGrupoPagamento;
    private String codigoIdentificadorUnico;
    private String nomeBanco;
    private int quantidadeLancamentoRemessa;
    private String numeroRaizCNPJ;
    private String numeroSufixoCNPJ;
    private Double valorLancamentoRemessa;
    private Long dateLancamentoContaCorrenteCliente;
    private Long dateEfetivaLancamento;

}
