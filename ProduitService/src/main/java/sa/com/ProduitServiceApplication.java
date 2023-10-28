package sa.com;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sa.com.entities.Produit;
import sa.com.repositories.ProduitRepository;

import java.util.List;

@SpringBootApplication
public class ProduitServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProduitRepository produitRepository,
                                        RepositoryRestConfiguration restConfiguration){
       return args -> {
           restConfiguration.exposeIdsFor(Produit.class);
           produitRepository.saveAll(
                   List.of(Produit.builder().name("PC").quantity(15).prix(1500).build(),
                   Produit.builder().name("Tel").quantity(15).prix(1500).build(),
                           Produit.builder().name("Apple").quantity(15).prix(3600).build(),
                   Produit.builder().name("TV").quantity(10).prix(1500).build()
           )

           );
           produitRepository.findAll().forEach(p->{
               System.out.println(p);
           });
       } ;
    }
}