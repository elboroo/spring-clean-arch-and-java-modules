package pl.training.orders.model;

import java.util.Map;

public record Order(Long id, Map<Long, Integer> entries) {
}
