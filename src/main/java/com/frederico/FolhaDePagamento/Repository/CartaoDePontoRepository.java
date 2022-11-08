package com.frederico.FolhaDePagamento.Repository;

import com.frederico.FolhaDePagamento.Domain.CartaoDePonto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoDePontoRepository extends JpaRepository<CartaoDePonto, Long> {
}
