package com.frederico.FolhaDePagamento.Repository;

import com.frederico.FolhaDePagamento.Domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
