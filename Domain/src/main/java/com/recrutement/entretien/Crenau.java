package com.recrutement.entretien;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Crenau {

    private final LocalDate date;

    private final LocalTime heureDebut;

    private final LocalTime heureFin;

    public Crenau(LocalDateTime dateDebut, int dureeMinute) {
        this.date = dateDebut.toLocalDate();
        this.heureDebut = dateDebut.toLocalTime();
        this.heureFin = this.heureDebut.plusMinutes(dureeMinute);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crenau crenau = (Crenau) o;
        return date.equals(crenau.date) &&
                heureDebut.equals(crenau.heureDebut) &&
                heureFin.equals(crenau.heureFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, heureDebut, heureFin);
    }
}
