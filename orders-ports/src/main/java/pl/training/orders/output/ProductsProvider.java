package pl.training.orders.output;

import pl.training.orders.model.Product;

import java.util.Optional;

public interface ProductsProvider {

    Optional<Product> getById(Long id);

}
