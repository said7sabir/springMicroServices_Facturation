package sa.com.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sa.com.model.Produit;

@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitRestClient {

    @GetMapping(path = "/produits/{id}")
    Produit findProduitById(@PathVariable Long id);

    @GetMapping(path = "/produits")
    PagedModel<Produit>allProduits();
}
