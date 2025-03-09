package br.com.sancrisxa.api_consulta_creditos.service;

import br.com.sancrisxa.api_consulta_creditos.Dto.Response.CreditoDto;
import br.com.sancrisxa.api_consulta_creditos.model.Credito;
import br.com.sancrisxa.api_consulta_creditos.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoServiceImpl implements CreditoService {

    private final CreditoRepository creditoRepository;

    @Autowired
    public CreditoServiceImpl(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @Override
    public List<CreditoDto> getCreditosPorNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(numeroNfse);
        return creditos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CreditoDto getCreditoPorNumero(String numeroCredito) {
        Credito credito = creditoRepository.findById(numeroCredito).orElse(null);
        return credito != null ? convertToDto(credito) : null;
    }

    private CreditoDto convertToDto(Credito credito) {
        CreditoDto dto = new CreditoDto();
        dto.setNumeroCredito(credito.getNumeroCredito());
        dto.setNumeroNfse(credito.getNumeroNfse());
        dto.setDataConstituicao(credito.getDataConstituicao());
        dto.setValorIssqn(credito.getValorIssqn());
        dto.setTipoCredito(credito.getTipoCredito());
        dto.setSimplesNacional(credito.getSimplesNacional());
        dto.setAliquota(credito.getAliquota());
        dto.setValorFaturado(credito.getValorFaturado());
        dto.setValorDeducao(credito.getValorDeducao());
        dto.setBaseCalculo(credito.getBaseCalculo());
        return dto;
    }
}
