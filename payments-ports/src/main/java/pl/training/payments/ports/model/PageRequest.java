package pl.training.payments.ports.model;

public record PageRequest(int pageNumber, int pageSize) {

    public int getOffset() {
        return pageNumber * pageSize;
    }

}
