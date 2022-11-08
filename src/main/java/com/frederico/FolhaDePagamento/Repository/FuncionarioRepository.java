package com.frederico.FolhaDePagamento.Repository;

import com.frederico.FolhaDePagamento.Domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
