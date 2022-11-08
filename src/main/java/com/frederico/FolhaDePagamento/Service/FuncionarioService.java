package com.frederico.FolhaDePagamento.Service;

import com.frederico.FolhaDePagamento.Domain.Assalariado;
import com.frederico.FolhaDePagamento.Domain.Comissionado;
import com.frederico.FolhaDePagamento.Domain.Funcionario;
import com.frederico.FolhaDePagamento.Domain.Horista;
import com.frederico.FolhaDePagamento.Repository.AssalariadoRepository;
import com.frederico.FolhaDePagamento.Repository.FuncionarioRepository;
import com.frederico.FolhaDePagamento.Repository.HoristaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class FuncionarioService {

    final private FuncionarioRepository funcionarioRepository;
    final private AssalariadoRepository assalariadoRepository;
    final private HoristaRepository horistaRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository,
                              AssalariadoRepository assalariadoRepository,
                              HoristaRepository horistaRepository) {
        this.funcionarioRepository = funcionarioRepository;
         this.assalariadoRepository = assalariadoRepository;
         this.horistaRepository = horistaRepository;
    }

    public Assalariado save(Assalariado assalariado) {

        Double salario = assalariado.getSalarioMensal();
        if(salario<1200) {
            //Funcionario precisa receber mais que o salario minimo
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        return this.funcionarioRepository.save(assalariado);
    }

    public void Delete(Long id) {
        try {
            this.funcionarioRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    //fazer update dos outros funcionarios
    public Assalariado update(Assalariado updated, Long id) {
        Optional<Assalariado> currentOPT = this.assalariadoRepository.findById(id);
        if(currentOPT.isPresent()){
            Assalariado current = currentOPT.get();
            current.setSindicalista(updated.isSindicalista());
            current.setNome(updated.getNome());
            current.setPreferenciaPagamento(updated.getPreferenciaPagamento());
            return this.assalariadoRepository.save(current);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }


    public Comissionado save(Comissionado comissionado) {
        return this.funcionarioRepository.save(comissionado);
    }


    public Horista save(Horista horista) {

        Double salario = horista.getSalarioHorista();
        if(salario<5.50) {
            //Funcionario precisa receber mais que o salario minimo
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        return this.funcionarioRepository.save(horista);
    }
}
