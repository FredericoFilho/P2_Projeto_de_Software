package com.frederico.FolhaDePagamento.Service;

import com.frederico.FolhaDePagamento.Domain.Venda;
import com.frederico.FolhaDePagamento.Repository.VendaRepository;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    final private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda save(Venda venda) {
        return this.vendaRepository.save(venda);
    }

}
