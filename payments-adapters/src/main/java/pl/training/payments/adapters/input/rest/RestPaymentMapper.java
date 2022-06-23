package pl.training.payments.adapters.input.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.payments.ports.model.Money;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;

@Mapper(componentModel = "spring", imports = Money.class)
public interface RestPaymentMapper {

    @Mapping(target = "id", source = "requestId")
    @Mapping(target = "value", expression = "java(Money.of(paymentRequestDto.getValue()))")
    PaymentRequest toPorts(PaymentRequestDto paymentRequestDto);

    @Mapping(target = "value", expression = "java(payment.value().toString())")
    PaymentDto toDto(Payment payment);

}
