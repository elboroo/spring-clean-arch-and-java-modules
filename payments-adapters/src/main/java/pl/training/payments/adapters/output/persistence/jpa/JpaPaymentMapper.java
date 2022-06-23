package pl.training.payments.adapters.output.persistence.jpa;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import pl.training.payments.ports.model.Money;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.ResultPage;

import java.util.Currency;
import java.util.List;

@Mapper(componentModel = "spring", imports = {Money.class, Currency.class})
public interface JpaPaymentMapper {

    @Mapping(target = "value", expression = "java(payment.value().value())")
    @Mapping(target = "currency", expression = "java(payment.value().currency().toString())")
    PaymentEntity toEntity(Payment payment);

    @Mapping(target = "value", expression = "java(new Money(paymentEntity.getValue(), Currency.getInstance(paymentEntity.getCurrency())))")
    Payment toPorts(PaymentEntity paymentEntity);

    @IterableMapping(elementTargetType = Payment.class)
    List<Payment> toPorts(List<PaymentEntity> paymentEntities);

    @Mapping(target = "data", source = "content")
    @Mapping(target = "pageNumber", source = "number")
    ResultPage<Payment> toPorts(Page<PaymentEntity> resultPage);

}
