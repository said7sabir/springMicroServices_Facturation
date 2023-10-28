package sa.com;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sa.com.entities.Facture;
import sa.com.entities.ProduitItem;
import sa.com.model.Client;
import sa.com.model.Produit;
import sa.com.repositories.FactureRepository;
import sa.com.repositories.ProduitItemRepository;
import sa.com.services.ClientRestClient;
import sa.com.services.ProduitRestClient;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class FacturationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacturationApplication.class,args);
    }


    @Bean
    CommandLineRunner start(FactureRepository factureRepository,
                            ProduitItemRepository produitItemRepository,
                            ProduitRestClient produitRestClient,
                            ClientRestClient clientRestClient){
        return args -> {
            Collection<Produit> produits=produitRestClient.allProduits().getContent();
            Long clientId=1L;
            Client client=clientRestClient.findClientById(clientId);
            if (client==null)throw new RuntimeException("Client n'existe pas");
            Facture facture=new Facture();
            facture.setDateFacture(new Date());
            facture.setClientId(clientId);
            Facture savedFacture = factureRepository.save(facture);
            produits.forEach(produit -> {
                ProduitItem produitItem=new ProduitItem();
                produitItem.setProduitId(produit.getId());
                produitItem.setFacture(savedFacture);
                produitItem.setQuantity(1+new Random().nextInt(10));
                produitItem.setPrix(produit.getPrix());
                produitItemRepository.save(produitItem);
            });
        };
    }
}