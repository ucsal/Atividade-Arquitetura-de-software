package com.banco.digital.accountservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "configuracao")
@Data
public class ConfiguracaoBancaria {

    private String mensagem;
    private Double limiteTransacao;
    private String ambiente;
    private String corTema;

}
