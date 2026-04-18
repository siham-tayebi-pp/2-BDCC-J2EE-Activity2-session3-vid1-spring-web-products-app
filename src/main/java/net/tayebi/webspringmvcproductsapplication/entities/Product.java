//depo4
package net.tayebi.webspringmvcproductsapplication.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
