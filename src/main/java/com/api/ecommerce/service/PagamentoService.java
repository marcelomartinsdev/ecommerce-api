package com.api.ecommerce.service;

import com.api.ecommerce.enums.StatusPagamento;
import com.api.ecommerce.model.Pagamento;
import com.api.ecommerce.model.Pedido;
import com.api.ecommerce.repositories.PagamentoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional
    public void gerarPagamento(Pedido pedido){
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setDebitar(pedido.getValorTotal());
        pagamento.setStatusPagamento(StatusPagamento.PENDENTE);
        pagamento.setNumeroTransacao(ThreadLocalRandom.current().nextLong(100_000));
        pagamentoRepository.save(pagamento);
    }
}
