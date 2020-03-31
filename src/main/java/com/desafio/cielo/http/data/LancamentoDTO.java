package com.desafio.cielo.http.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LancamentoDTO {

    private String dataDoLancamento;
    private String descricao;
    private Long numero;
    private String situacao;
    private String dataDeConfirmacao;
    private String dadosBancarios;
    private double valorFinal;

}
