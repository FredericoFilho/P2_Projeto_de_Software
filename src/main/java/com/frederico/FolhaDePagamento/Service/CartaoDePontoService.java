package com.frederico.FolhaDePagamento.Service;

import com.frederico.FolhaDePagamento.Domain.Assalariado;
import com.frederico.FolhaDePagamento.Domain.CartaoDePonto;
import com.frederico.FolhaDePagamento.Repository.CartaoDePontoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartaoDePontoService {

    final private CartaoDePontoRepository cartaoDePontoRepository;

    public CartaoDePontoService(CartaoDePontoRepository cartaoDePontoRepository) {
        this.cartaoDePontoRepository = cartaoDePontoRepository;
    }

    public CartaoDePonto save(CartaoDePonto cartaoDePonto) {
        return this.cartaoDePontoRepository.save(cartaoDePonto);
    }

    public void Delete(Long id) {
        try {
            this.cartaoDePontoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public CartaoDePonto update(CartaoDePonto updated, Long id) {
        Optional<CartaoDePonto> currentOPT = this.cartaoDePontoRepository.findById(id);
        if(currentOPT.isPresent()){
            CartaoDePonto current = currentOPT.get();
            current.setEntrada(updated.getEntrada());
            current.setSaida(updated.getSaida());
            return this.cartaoDePontoRepository.save(current);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
