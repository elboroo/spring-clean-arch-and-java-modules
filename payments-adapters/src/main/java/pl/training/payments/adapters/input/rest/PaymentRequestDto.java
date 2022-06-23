package pl.training.payments.adapters.input.rest;

import lombok.Data;

@Data
public class PaymentRequestDto {

    private Long requestId;
    private String value;

}
