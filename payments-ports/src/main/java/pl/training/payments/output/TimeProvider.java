package pl.training.payments.output;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimestamp();

}
