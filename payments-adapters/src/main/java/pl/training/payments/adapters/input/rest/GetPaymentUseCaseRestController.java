package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.payments.adapters.commons.web.LocationUri;
import pl.training.payments.ports.input.GetPaymentUseCase;

@RequestMapping("api/payments")
@RestController
@RequiredArgsConstructor
public class GetPaymentUseCaseRestController {

    private final GetPaymentUseCase getPaymentUseCase;
    private final RestPaymentMapper mapper;

    @GetMapping("{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable String id) {
        var payment = getPaymentUseCase.getById(id);
        var paymentDto = mapper.toDto(payment);
        var locationUri = LocationUri.fromRequest(payment.id());
        return ResponseEntity.created(locationUri).body(paymentDto);
    }

}
