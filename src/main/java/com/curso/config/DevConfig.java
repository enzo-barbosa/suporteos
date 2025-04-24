package com.curso.config;

import com.curso.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Define para o Spring que essa classe é de configuração
@Profile("dev") // Define quando essa classe de config será iniciada, nesse caso, apenas quando o perfil "test" estiver ativo
public class DevConfig {

    @Autowired // Injeta automaticamente uma instância gerenciada pelo Spring aqui
    private DBService dbService;

    @PostConstruct // Indica que o metodo anotado deve ser executado logo após a construção do bean e a injeção de todas as suas dependências
    public void initDB() {
        this.dbService.initDB();
    }
}
