package com.recrutement.entretien;

import com.recrutement.entretien.exception.CreneauException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Creneau{

    private final LocalDate date;

    private final LocalTime heureDebut;

    private final LocalTime heureFin;

    public Creneau(LocalDateTime dateDebut, int dureeMinute) throws CreneauException {
        this.date = dateDebut.toLocalDate();
        this.heureDebut = dateDebut.toLocalTime();
        this.heureFin = this.heureDebut.plusMinutes(dureeMinute);

        throw new CreneauException(dureeMinute);
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
        Creneau creneau = (Creneau) o;
        return date.equals(creneau.date) &&
                heureDebut.equals(creneau.heureDebut) &&
                heureFin.equals(creneau.heureFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, heureDebut, heureFin);
    }
}
