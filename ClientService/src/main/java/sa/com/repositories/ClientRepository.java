package sa.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sa.com.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
}
