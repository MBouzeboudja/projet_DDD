package model.entretien;

import model.entretien.exception.CreneauException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Creneau{

    private final LocalDate date;

    private final LocalTime heureDebut;

    private final LocalTime heureFin;

    private static final LocalTime LIMITE_FIN_ENTRETIEN = LocalTime.of(21,0);
    private static final LocalTime LIMITE_DEBUT_ENTRETIEN = LocalTime.of(18,0);

    public Creneau(LocalDateTime dateDebut, int dureeMinute) throws CreneauException {
        if(dureeMinute <60){
            throw new CreneauException("Le créneau est inférieur à une heure");
        }
        if(dateDebut.getDayOfWeek() == DayOfWeek.SATURDAY || dateDebut.getDayOfWeek() == DayOfWeek.SUNDAY){
            throw new CreneauException("La date du créneau n'est pas un jour ouvrable");
        }
        this.date = dateDebut.toLocalDate();
        this.heureDebut = dateDebut.toLocalTime();
        this.heureFin = this.heureDebut.plusMinutes(dureeMinute);

        if(heureDebut.isBefore(LIMITE_DEBUT_ENTRETIEN)){
            throw new CreneauException("Le créneau commence trop tôt");
        }
        if(heureFin.isAfter(LIMITE_FIN_ENTRETIEN)){
            throw new CreneauException("Le créneau se fini trop tard");
        }
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
