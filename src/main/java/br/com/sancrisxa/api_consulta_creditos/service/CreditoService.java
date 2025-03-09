package br.com.sancrisxa.api_consulta_creditos.service;

import br.com.sancrisxa.api_consulta_creditos.Dto.Response.CreditoDto;

import java.util.List;

public interface CreditoService {
    List<CreditoDto> getCreditosPorNfse(String numeroNfse);
    CreditoDto getCreditoPorNumero(String numeroCredito);
}
