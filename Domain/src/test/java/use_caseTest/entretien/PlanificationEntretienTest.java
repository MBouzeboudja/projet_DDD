package use_caseTest.entretien;

import exposition.EntretienRequest;
import model.entretien.Creneau;
import model.entretien.Entretien;
import model.entretien.exception.CreneauException;
import model.personne.Candidat;
import model.salle.Salle;
import org.junit.Assert;
import org.junit.Test;
import use_case.entretien.PlanificationEntretien;
import use_caseTest.entretien.infrastructure.ConsultantRecruteursTest;
import use_caseTest.entretien.infrastructure.SallesTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class PlanificationEntretienTest {

    @Test
    public void entretien_cree(){
        EntretienRequest entretienRequest = new EntretienRequest("azerty", "B1", "2020-05-12", 100);

        PlanificationEntretien planificationEntretien = new PlanificationEntretien(new CandidatsTest(), new ConsultantRecruteursTest(), new SallesTest());
        Entretien entretien = planificationEntretien.creerEntretien(entretienRequest);

        Assert.assertNotNull(entretien.getEntretienId());
    }
    /*
    @Test
    public void exception_si_aucun_recruteur(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        assertThrows(CreneauException.class,
                ()->{
                    Creneau c = new Creneau(date, 60);
                });
    }*/
}
