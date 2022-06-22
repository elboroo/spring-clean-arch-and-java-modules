package pl.training.payments.id;

import org.springframework.stereotype.Service;
import pl.training.payments.output.IdGenerator;

import java.util.UUID;

@Service
public class UuidGenerator implements IdGenerator {

    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

}
