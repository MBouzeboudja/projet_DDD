package com.recrutement.entretienTest;

import com.recrutement.entretien.Creneau;
import com.recrutement.entretien.exception.CreneauException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertThrows;

public class CreneauTest {

    @Test
    public void heure_de_fin_valide(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        Creneau c = new Creneau(date, 45);
        Assert.assertEquals(c.getHeureFin(), LocalTime.of(14,45));
    }

    @Test
    public void exception_si_creneau_inferieur_30min(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        assertThrows(CreneauException.class,
                ()->{
                    Creneau c = new Creneau(date, 20);
                });

    }

    @Test
    public void exception_si_date_pendant_weekend(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 26), LocalTime.of(14, 00));
        assertThrows(CreneauException.class,
                ()->{
                    Creneau c = new Creneau(date, 40);
                });
    }
}
