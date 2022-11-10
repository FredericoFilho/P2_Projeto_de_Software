package com.frederico.FolhaDePagamento.Resources;

import com.frederico.FolhaDePagamento.Domain.Venda;
import com.frederico.FolhaDePagamento.Repository.FuncionarioRepository;
import com.frederico.FolhaDePagamento.Repository.VendaRepository;
import com.frederico.FolhaDePagamento.Service.VendaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/")
public class VendaResources {

    final private VendaRepository vendaRepository;

    final private VendaService vendaService;

    final private FuncionarioRepository funcionarioRepository;

    public VendaResources(VendaRepository vendaRepository,
                          VendaService vendaService,
                          FuncionarioRepository funcionarioRepository) {
        this.vendaRepository = vendaRepository;
        this.vendaService = vendaService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/vendas")
    public List<Venda> listVendas() {
        return vendaRepository.findAll();
    }

    @GetMapping("/venda/{id}")
    public Venda Save(@RequestBody Venda venda, @PathVariable Long id) {
        Optional<Funcionario> funcionarioOptional = this.funcionarioRepository.findById(id);

    }

}
