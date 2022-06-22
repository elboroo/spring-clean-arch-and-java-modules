package pl.training.payments.time;

import org.springframework.stereotype.Service;
import pl.training.payments.output.TimeProvider;

import java.time.Instant;

@Service
public class SystemTimeProvider implements TimeProvider {

    @Override
    public Instant getTimestamp() {
        return Instant.now();
    }

}
