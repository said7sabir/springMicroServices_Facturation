package sa.com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sa.com.model.Produit;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProduitItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produitId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Facture facture;
    private int quantity;
    private double prix;
    @Transient
    private Produit produit;
}
