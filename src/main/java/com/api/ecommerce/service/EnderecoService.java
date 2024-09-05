package com.api.ecommerce.service;

import com.api.ecommerce.client.EnderecoClient;
import com.api.ecommerce.dto.EnderecoRequestDTO;
import com.api.ecommerce.dto.EnderecoResponseDTO;
import com.api.ecommerce.model.Cliente;
import com.api.ecommerce.model.Endereco;
import com.api.ecommerce.repositories.EnderecoRepository;
import com.api.ecommerce.service.mapper.EnderecoMapper;
import com.api.ecommerce.util.FeignUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    private EnderecoClient enderecoClient;

    @Value("${url.via.cep}")
    private String url;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @PostConstruct
    public void init() {
        this.enderecoClient = FeignUtil.getEnderecoFeing(url);
    }

    public Endereco salvarEndereco(EnderecoRequestDTO enderecoRequestDTO, Cliente cliente) {
        JsonObject response = enderecoClient.buscarEndereco(enderecoRequestDTO.getCep());
        Gson gson = new Gson();
        EnderecoResponseDTO enderecoResponseDTO = gson.fromJson(response, EnderecoResponseDTO.class);
        Endereco endereco = enderecoMapper.toEndereco(enderecoResponseDTO);
        endereco.setNumero(enderecoRequestDTO.getNumero());
        endereco.setComplemento(enderecoRequestDTO.getComplemento());
        endereco.setCliente(cliente);
        endereco.setDataInsercao(LocalDateTime.now());
        endereco.setDataModificacao(LocalDateTime.now());
        endereco.setTipoEnderecoEnum(enderecoRequestDTO.getTipoEnderecoEnum());
        return enderecoRepository.save(endereco);
    }
}
