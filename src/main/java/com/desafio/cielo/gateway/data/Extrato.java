package com.desafio.cielo.gateway.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Extrato {

    private TotalControleLancamento totalControleLancamento;
    private List<ControleLancamento> listaControleLancamento;
    private int indice;
    private int tamanhoPagina;
    private int totalElements;

}
