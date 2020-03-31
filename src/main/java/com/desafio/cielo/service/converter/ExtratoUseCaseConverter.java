package com.desafio.cielo.service.converter;

import com.desafio.cielo.gateway.data.ControleLancamento;
import com.desafio.cielo.gateway.data.Extrato;
import com.desafio.cielo.http.data.ExtratoResponse;
import com.desafio.cielo.http.data.LancamentoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ExtratoUseCaseConverter {

    public ExtratoResponse toResponse(Extrato extrato) {

        if (Objects.nonNull(extrato)){
            return ExtratoResponse.builder()
                    .quantidadeLancamentos(extrato.getTotalControleLancamento().getQuantidadeLancamentos())
                    .quantidadeRemessas(extrato.getTotalControleLancamento().getQuantidadeRemessas())
                    .valorLancamentos(extrato.getTotalControleLancamento().getValorLancamentos())
                    .lancamentos(toListaLancamentos(extrato.getListaControleLancamento()))
                    .build();
        }
        else {

            throw new RuntimeException();

        }
    }

    private List<LancamentoDTO> toListaLancamentos(List<ControleLancamento> controleLancamentos) {

        List<LancamentoDTO> lancamentos = new ArrayList<>();

        for (ControleLancamento controleLancamento : controleLancamentos) {
            lancamentos.add(LancamentoDTO.builder()
                    .dadosBancarios(toDadosBancarios(controleLancamento.getNomeBanco(),
                            controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia(),
                            controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente()))
                    .descricao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao())
                    .dataDeConfirmacao(controleLancamento.getDataLancamentoContaCorrenteCliente())
                    .dataDoLancamento(controleLancamento.getDataEfetivaLancamento())
                    .numero(controleLancamento.getNumeroEvento())
                    .situacao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa())
                    .valorFinal(controleLancamento.getValorLancamentoRemessa())
                    .build());
        }

        return lancamentos;

    }

    private String toDadosBancarios(String nomeBanco, Long numAgencia, String numContaCorrente) {

        return String.format("%s Ag %s CC %s", nomeBanco.trim(), numAgencia, numContaCorrente);

    }
}
