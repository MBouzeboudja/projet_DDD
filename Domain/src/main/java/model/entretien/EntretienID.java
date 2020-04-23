package com.recrutement.entretien;

import java.util.Objects;
import java.util.UUID;

public class EntretienID {
    private final UUID id;

    public EntretienID(UUID id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntretienID)) return false;
        EntretienID that = (EntretienID) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
