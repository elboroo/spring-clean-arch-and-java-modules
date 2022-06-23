package pl.training.payments.adapters.output.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.training.payments.ports.model.PageRequest;
import pl.training.payments.ports.model.Payment;
import pl.training.payments.ports.model.PaymentStatus;
import pl.training.payments.ports.model.ResultPage;
import pl.training.payments.ports.output.PaymentReader;
import pl.training.payments.ports.output.PaymentWriter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Primary
@Transactional
@Repository
@RequiredArgsConstructor
public class JpaPaymentRepositoryAdapter implements PaymentReader, PaymentWriter {

    private final JpaPaymentRepository jpaPaymentRepository;
    private final JpaPaymentMapper mapper;

    @Override
    public Optional<Payment> getById(String id) {
        return jpaPaymentRepository.findById(id)
                .map(mapper::toPorts);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, PageRequest pageRequest) {
        var page = org.springframework.data.domain.PageRequest.of(pageRequest.pageNumber(), pageRequest.pageSize());
        var resultPage = jpaPaymentRepository.getByStatus(status.name(), page);
        return mapper.toPorts(resultPage);
    }

    @Override
    public Payment save(Payment payment) {
        var entity = mapper.toEntity(payment);
        return mapper.toPorts(jpaPaymentRepository.save(entity));
    }
}
