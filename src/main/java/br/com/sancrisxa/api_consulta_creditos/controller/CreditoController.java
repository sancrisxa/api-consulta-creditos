package br.com.sancrisxa.api_consulta_creditos.controller;

import br.com.sancrisxa.api_consulta_creditos.Dto.Response.CreditoDto;
import br.com.sancrisxa.api_consulta_creditos.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    @Autowired
    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDto>> getCreditosPorNfse(@PathVariable String numeroNfse) {
        List<CreditoDto> creditos = creditoService.getCreditosPorNfse(numeroNfse);
        if (creditos != null && !creditos.isEmpty()) {
            return ResponseEntity.ok(creditos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDto> getCreditoPorNumero(@PathVariable String numeroCredito) {
        CreditoDto credito = creditoService.getCreditoPorNumero(numeroCredito);
        if (credito != null) {
            return ResponseEntity.ok(credito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
