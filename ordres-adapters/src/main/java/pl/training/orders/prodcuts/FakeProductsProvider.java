package pl.training.orders.prodcuts;

import org.springframework.stereotype.Service;
import pl.training.orders.model.Product;
import pl.training.orders.output.ProductsProvider;

import java.util.Optional;

@Service
public class FakeProductsProvider implements ProductsProvider {

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.of(new Product(1L, "Clean architecture", "100 PLN"));
    }

}
