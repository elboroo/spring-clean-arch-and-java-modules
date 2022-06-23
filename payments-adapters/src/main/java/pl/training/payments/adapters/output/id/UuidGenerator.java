package pl.training.payments.adapters.output.id;

import org.springframework.stereotype.Service;
import pl.training.payments.ports.output.IdGenerator;

import java.util.UUID;

@Service
public class UuidGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
