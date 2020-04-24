package use_caseTest.entretien;

import exposition.EntretienRequest;
import model.consultantRecruteur.exception.ConsultantRecruteurException;
import model.entretien.Entretien;
import model.entretien.Statut;
import model.salle.exception.SalleException;
import org.junit.Assert;
import org.junit.Test;
import use_case.entretien.PlanificationEntretien;
import use_caseTest.entretien.infrastructure.CandidatsTest;
import use_caseTest.entretien.infrastructure.ConsultantRecruteursTest;
import use_caseTest.entretien.infrastructure.SallesIndisponiblesTest;
import use_caseTest.entretien.infrastructure.SallesTest;

import static org.junit.Assert.assertThrows;

public class PlanificationEntretienTest {

    @Test
    public void entretien_cree(){
        EntretienRequest entretienRequest = new EntretienRequest("38400000-8cf0-11bd-b23e-10b96e4ef00d", "B1", "2020-05-12T18:10:00.000", 100);

        PlanificationEntretien planificationEntretien = new PlanificationEntretien(new CandidatsTest(), new ConsultantRecruteursTest(), new SallesTest());
        Entretien entretien = planificationEntretien.creerEntretien(entretienRequest);

        Assert.assertNotNull(entretien.getEntretienId());
        Assert.assertEquals(entretien.getStatut(), Statut.PLANIFIE);
    }

    @Test
    public void exception_si_aucun_recruteur(){
        EntretienRequest entretienRequest = new EntretienRequest("38400000-8cf0-11bd-b23e-10b96e4ef00d", "B1", "2020-05-10T18:11:00.000", 100);
        PlanificationEntretien planificationEntretien = new PlanificationEntretien(new CandidatsTest(), new ConsultantRecruteursTest(), new SallesTest());

        assertThrows(ConsultantRecruteurException.class,
                ()->{
                    Entretien entretien = planificationEntretien.creerEntretien(entretienRequest);
                });
    }


    @Test
    public void exception_si_aucun_salle(){
        EntretienRequest entretienRequest = new EntretienRequest("38400000-8cf0-11bd-b23e-10b96e4ef00d", "B12", "2020-05-12T18:10:00.000", 100);
        PlanificationEntretien planificationEntretien = new PlanificationEntretien(new CandidatsTest(), new ConsultantRecruteursTest(), new SallesIndisponiblesTest());

        assertThrows(SalleException.class,
                ()->{
                    Entretien entretien = planificationEntretien.creerEntretien(entretienRequest);
                });
    }

}
