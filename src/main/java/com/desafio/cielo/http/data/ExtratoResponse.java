package com.desafio.cielo.http.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class ExtratoResponse implements Serializable {

    private int quantidadeLancamentos;
    private int quantidadeRemessas;
    private Double valorLancamentos;
    private List<LancamentoDTO> lancamentos;

}
