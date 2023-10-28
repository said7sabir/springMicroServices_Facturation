package sa.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sa.com.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
