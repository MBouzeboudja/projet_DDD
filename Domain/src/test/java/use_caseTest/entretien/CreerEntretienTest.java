package use_caseTest.entretien;

import model.entretien.Creneau;
import model.entretien.exception.CreneauException;
import model.personne.Candidat;
import model.personne.Candidats;
import model.personne.ConsultantRecruteur;
import model.personne.ConsultantRecruteurs;
import model.salle.Salle;
import model.salle.Salles;
import org.junit.Test;
import use_case.entretien.CreerEntretien;
import use_caseTest.entretien.infrastructure.SallesTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class CreerEntretienTest {

    @Test
    public void entretien_cree(){

        List<ConsultantRecruteur> consultantRecruteurs = new ConsultantRecruteursTest().trouverConsultantRecruteurs();
        List<Candidat> candidats = new CandidatsTest().trouveCandidat("2020-04-24 18:03:00", 100);
        List<Salle> salles = new SallesTest().trouverSallesDisponibles("2020-04-24 18:03:00", 100);

        CreerEntretien creerEntretien = new CreerEntretien(candidats, consultantRecruteurs, salles);
    }
    @Test
    public void exception_si_aucun_recruteur(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        assertThrows(CreneauException.class,
                ()->{
                    Creneau c = new Creneau(date, 60);
                });
    }
}
