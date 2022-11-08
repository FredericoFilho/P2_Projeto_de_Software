package com.frederico.FolhaDePagamento.Resources;


import com.frederico.FolhaDePagamento.Domain.Assalariado;
import com.frederico.FolhaDePagamento.Domain.Comissionado;
import com.frederico.FolhaDePagamento.Domain.Funcionario;
import com.frederico.FolhaDePagamento.Domain.Horista;
import com.frederico.FolhaDePagamento.Repository.FuncionarioRepository;
import com.frederico.FolhaDePagamento.Service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class FuncionarioResources {

    final private FuncionarioRepository funcionarioRepository;
    final private FuncionarioService funcionarioService;

    public FuncionarioResources(FuncionarioRepository funcionarioRepository,
                                FuncionarioService funcionarioService) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> listFuncionarios()
    {
        return  funcionarioRepository.findAll();
    }
    @GetMapping("/funcionario/{id}")
    public Optional<Funcionario> getFuncionario(@PathVariable Long id)
    {
        return  funcionarioRepository.findById(id);
    }

    @PostMapping("/assalariado")
    public Assalariado Save(@RequestBody Assalariado assalariado)
    {
        return funcionarioService.save(assalariado);
    }

    @PostMapping("/horista")
    public Horista Save(@RequestBody Horista horista)
    {
        return funcionarioService.save(horista);
    }

    @PostMapping("/comissionado")
    public Comissionado Save(@RequestBody Comissionado comissionado)
    {
        return funcionarioService.save(comissionado);
    }

    @DeleteMapping("funcionario/{id}")
    public void Delete(@PathVariable Long id)
    {
        funcionarioService.Delete(id);
    }
}
