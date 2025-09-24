package hs.bssm.somonox.remedydrops.drops.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class DropNotFoundException extends RuntimeException {
    private final UUID id;
    public DropNotFoundException(UUID id) {
        super("Drop not found: " + id);
        this.id = id;
    }

}
