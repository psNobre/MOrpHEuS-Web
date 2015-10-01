package br.com.morpheus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication // O mesmo que @Configuration, @ @EnableAutoConfiguration e @ComponentScan.
public class MorpheusApplication extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(MorpheusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MorpheusApplication.class, args);
        log.info("Aplicação WEB Inicializada...");
    }
    
}
