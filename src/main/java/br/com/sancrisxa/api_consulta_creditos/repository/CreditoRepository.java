package br.com.sancrisxa.api_consulta_creditos.repository;

import br.com.sancrisxa.api_consulta_creditos.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {
    List<Credito> findByNumeroNfse(String numeroNfse);
}
