package sa.com.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sa.com.model.Client;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping(path = "/clients/{id}")
    Client findClientById(@PathVariable Long id);
}
