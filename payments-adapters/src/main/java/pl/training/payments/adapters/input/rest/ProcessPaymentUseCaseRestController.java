package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.payments.adapters.commons.web.LocationUri;
import pl.training.payments.ports.input.ProcessPaymentUseCase;

@RequestMapping("api/payments")
@RestController
@RequiredArgsConstructor
public class ProcessPaymentUseCaseRestController {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final RestPaymentMapper mapper;

    @PostMapping
    public ResponseEntity<PaymentDto> process(@RequestBody PaymentRequestDto paymentRequestDto) {
        var paymentRequest = mapper.toPorts(paymentRequestDto);
        var payment= processPaymentUseCase.process(paymentRequest);
        var paymentDto = mapper.toDto(payment);
        var locationUri = LocationUri.fromRequest(payment.id());
        return ResponseEntity.created(locationUri).body(paymentDto);
    }

}
