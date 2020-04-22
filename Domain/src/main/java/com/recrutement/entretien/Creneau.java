package com.recrutement.entretien;

import com.recrutement.entretien.exception.CreneauException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Objects;

public class Creneau{

    private final LocalDate date;

    private final LocalTime heureDebut;

    private final LocalTime heureFin;

    public Creneau(LocalDateTime dateDebut, int dureeMinute) throws CreneauException {
        if(dureeMinute <30){
            throw new CreneauException(dureeMinute);
        }
        if(dateDebut.getDayOfWeek() == DayOfWeek.SATURDAY || dateDebut.getDayOfWeek() == DayOfWeek.SUNDAY){
            throw new CreneauException(dateDebut.toLocalDate());
        }
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
