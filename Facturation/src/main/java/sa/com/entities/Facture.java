package sa.com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sa.com.model.Client;

import java.util.Date;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Facture {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateFacture;
    private Long clientId;
    @OneToMany(mappedBy = "facture")

    private List<ProduitItem> produitItems;
    @Transient
    private Client client;

}
