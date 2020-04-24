package use_caseTest.entretien;

import model.entretien.Creneau;
import model.entretien.exception.CreneauException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertThrows;

public class CreerEntretienTest {

    @Test
    public void exception_si_avant_18_heures(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        assertThrows(CreneauException.class,
                ()->{
                    Creneau c = new Creneau(date, 60);
                });
    }
}
