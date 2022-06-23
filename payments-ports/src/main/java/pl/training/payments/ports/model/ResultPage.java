package pl.training.payments.ports.model;

import java.util.List;

public record ResultPage<T>(List<T> data, int pageNumber, long totalPages) {
}
