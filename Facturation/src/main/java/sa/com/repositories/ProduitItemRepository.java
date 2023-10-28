package sa.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.com.entities.Facture;
import sa.com.entities.ProduitItem;

public interface ProduitItemRepository extends JpaRepository<ProduitItem,Long> {
}
