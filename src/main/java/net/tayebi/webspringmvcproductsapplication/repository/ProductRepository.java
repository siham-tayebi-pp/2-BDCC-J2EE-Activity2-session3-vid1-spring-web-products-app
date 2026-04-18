package net.tayebi.webspringmvcproductsapplication.repository;

import net.tayebi.webspringmvcproductsapplication.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
