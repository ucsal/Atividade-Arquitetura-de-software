package com.banco.digital.accountservice.controller;

import com.banco.digital.accountservice.config.ConfiguracaoBancaria;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/configuracao")
@AllArgsConstructor
public class ConfigController {

    private final ConfiguracaoBancaria configuracao;

    @GetMapping
    public ResponseEntity<Map<String, Object>> obterConfiguracoes() {
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", configuracao.getMensagem());
        response.put("limiteTransacao", configuracao.getLimiteTransacao());
        response.put("ambiente", configuracao.getAmbiente());
        response.put("corTema", configuracao.getCorTema());
        response.put("timestamp", System.currentTimeMillis());
        
        return ResponseEntity.ok(response);
    }


    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("servico", "account-service");
        response.put("ambiente", configuracao.getAmbiente());
        
        return ResponseEntity.ok(response);
    }

}
