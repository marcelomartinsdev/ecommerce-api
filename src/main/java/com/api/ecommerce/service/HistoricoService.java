package com.api.ecommerce.service;

import com.api.ecommerce.model.Historico;
import com.api.ecommerce.model.Pedido;
import com.api.ecommerce.repositories.HistoricoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class HistoricoService {
    @Autowired
    private HistoricoRepository historicoRepository;

    public void salvarHistorico(Pedido pedido) {
        Historico historico = new Historico();
        historico.setPedido(pedido);
        historico.setStatusAtualPedido(pedido.getStatusPedido());
        historicoRepository.save(historico);
        log.info("Pedido salvo no historico!");
    }
}
