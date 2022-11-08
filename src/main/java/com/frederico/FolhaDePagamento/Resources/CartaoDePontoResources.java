package com.frederico.FolhaDePagamento.Resources;

import com.frederico.FolhaDePagamento.Domain.CartaoDePonto;
import com.frederico.FolhaDePagamento.Domain.Funcionario;
import com.frederico.FolhaDePagamento.Repository.CartaoDePontoRepository;
import com.frederico.FolhaDePagamento.Repository.FuncionarioRepository;
import com.frederico.FolhaDePagamento.Service.CartaoDePontoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/")
public class CartaoDePontoResources {

    final private CartaoDePontoRepository cartaoDePontoRepository;

    final private CartaoDePontoService cartaoDePontoService;
    final private FuncionarioRepository funcionarioRepository;

    public CartaoDePontoResources(CartaoDePontoRepository cartaoDePontoRepository,
                                  CartaoDePontoService cartaoDePontoService,
                                  FuncionarioRepository funcionarioRepository) {
        this.cartaoDePontoRepository = cartaoDePontoRepository;
        this.cartaoDePontoService = cartaoDePontoService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/cartoesDePonto")
    public List<CartaoDePonto> listCartoesDePonto()
    {
        return cartaoDePontoRepository.findAll();
    }
    @GetMapping("/cartaoDePonto/{id}")
    public Optional<CartaoDePonto> getCartaoDePonto(@PathVariable Long id) {
        return cartaoDePontoRepository.findById(id);
    }

    @PostMapping("/cartaoDePonto/{id}")
    public CartaoDePonto Save(@RequestBody CartaoDePonto cartaoDePonto, @PathVariable Long id) {
        Optional<Funcionario> funcionarioOptional = this.funcionarioRepository.findById(id);
        //todo verificar se o funcionario eh horista
        if(funcionarioOptional.isPresent()) {
            Funcionario funcionario = funcionarioOptional.get();
            cartaoDePonto.setFuncionario(funcionario);
            return cartaoDePontoService.save(cartaoDePonto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("cartaoDePonto/{id}")
    public void Delete(@PathVariable Long id) {
        cartaoDePontoService.Delete(id);
    }
}
