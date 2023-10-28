package sa.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sa.com.entities.Produit;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
