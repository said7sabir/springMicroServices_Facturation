package sa.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sa.com.entities.Facture;
import sa.com.repositories.FactureRepository;
import sa.com.repositories.ProduitItemRepository;
import sa.com.services.ClientRestClient;
import sa.com.services.ProduitRestClient;

@RestController
public class FactureRestController {
    @Autowired
private FactureRepository factureRepository;
@Autowired
    private ProduitItemRepository produitItemRepository;
@Autowired
private ClientRestClient clientRestClient;
@Autowired
private ProduitRestClient produitRestClient;

@GetMapping("/factures/{id}")
public Facture facture(@PathVariable Long id){
    Facture facture=factureRepository.findById(id).get();
    facture.setClient(clientRestClient.findClientById(facture.getClientId()));
    facture.getProduitItems().forEach(pi->{
        pi.setProduit(produitRestClient.findProduitById(pi.getProduitId()));
    });
    return facture;
}

}
