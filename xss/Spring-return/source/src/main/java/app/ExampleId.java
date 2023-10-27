package app;

import java.util.UUID;

public class ExampleId {

    private final UUID id;

    ExampleId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

}
