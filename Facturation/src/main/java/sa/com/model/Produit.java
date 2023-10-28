package sa.com.model;

import lombok.Data;

@Data
public class Produit {
    private Long id;
    private String name;
    private int quantity;
    private double prix;
}
