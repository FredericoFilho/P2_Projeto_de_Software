package com.frederico.FolhaDePagamento.Repository;

import com.frederico.FolhaDePagamento.Domain.Assalariado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssalariadoRepository extends JpaRepository<Assalariado, Long> {

}
