package pl.training.payments.model;

public record PageRequest(int pageNumber, int pageSize) {

    public int getOffset() {
        return pageNumber * pageSize;
    }

}
