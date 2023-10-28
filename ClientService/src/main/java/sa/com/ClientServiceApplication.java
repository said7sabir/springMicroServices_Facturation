package sa.com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sa.com.entities.Client;
import sa.com.repositories.ClientRepository;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(ClientServiceApplication.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ClientRepository clientRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Client.class);
         clientRepository.saveAll(
                 List.of(Client.builder().name("hassan").email("llll@gmail.com").build(),
                 Client.builder().name("hassan").email("llll@gmail.com").build(),
                 Client.builder().name("hassan").email("llll@gmail.com").build(),
                 Client.builder().name("hassan").email("llll@gmail.com").build()
                )
         );

        clientRepository.findAll().forEach(c->{
            System.out.println(c);
        });
    };
}
}