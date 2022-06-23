package pl.training.payments.adapters.input.rest;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.training.payments.adapters.commons.web.ResultPageDto;
import pl.training.payments.ports.model.Money;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentRequest;
import pl.training.payments.ports.model.ResultPage;

import java.util.List;

@Mapper(componentModel = "spring", imports = Money.class)
public interface RestPaymentMapper {

    @Mapping(target = "id", source = "requestId")
    @Mapping(target = "value", expression = "java(Money.of(paymentRequestDto.getValue()))")
    PaymentRequest toPorts(PaymentRequestDto paymentRequestDto);

    @Mapping(target = "value", expression = "java(payment.value().toString())")
    PaymentDto toDto(Payment payment);

    @IterableMapping(elementTargetType = PaymentDto.class)
    List<PaymentDto> toDto(List<Payment> payments);

    ResultPageDto<PaymentDto> toDto(ResultPage<Payment> resultPage);


}
