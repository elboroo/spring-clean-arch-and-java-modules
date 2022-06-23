package pl.training.payments.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.payments.adapters.commons.web.ResultPageDto;
import pl.training.payments.ports.input.GetPaymentUseCase;
import pl.training.payments.ports.model.PageRequest;
import pl.training.payments.ports.model.PaymentStatus;

import static pl.training.payments.ports.model.PaymentStatus.STARTED;

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
        return ResponseEntity.ok(paymentDto);
    }

    @GetMapping("started")
    public ResponseEntity<ResultPageDto<PaymentDto>> getStartedPayments(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        var resultPage = getPaymentUseCase.getByStatus(STARTED, new PageRequest(pageNumber, pageSize));
        var resultPageDto = mapper.toDto(resultPage);
        return ResponseEntity.ok(resultPageDto);
    }

}
