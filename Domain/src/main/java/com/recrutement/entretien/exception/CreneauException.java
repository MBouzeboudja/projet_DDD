package com.recrutement.entretien.exception;

import java.time.LocalDate;

public class CreneauException extends RuntimeException {
    public CreneauException(int duree){
        super("La durée du créneau est inférieure à 30 minutes");
    }
    public CreneauException(LocalDate date){
        super("La durée du créneau est inférieure à 30 minutes");
    }
}
