package modelTest.entretien;

import model.entretien.Creneau;
import model.entretien.Entretien;
import model.entretien.Statut;
import model.personne.Candidat;
import model.personne.Niveau;
import model.personne.ConsultantRecruteur;
import model.personne.Skill;
import model.salle.Equipement;
import model.salle.Localisation;
import model.salle.Salle;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class EntretienTest {

    private Entretien creerEntretien(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(18, 00));
        Creneau creneau = new Creneau(date, 75);
        Skill tech = new Skill("java", Niveau.CONFIRME);
        Skill soft = new Skill("japonais", Niveau.DEBUTANT);
        List<Skill> recSkills = new ArrayList<Skill>();
        recSkills.add(tech);
        List<Skill> candidatSkills = new ArrayList<Skill>();
        candidatSkills.add(tech);
        List<Skill> candidatTechSkills = new ArrayList<Skill>();
        candidatTechSkills.add(soft);
        List<LocalDate> dispo = new ArrayList<>();
        dispo.add(LocalDate.of(2020, 04, 30));
        Candidat candidat = new Candidat(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "Yohann", 1, "bunu@gmail.com", candidatTechSkills, candidatSkills, "bunu.cv.ru");
        ConsultantRecruteur consultantRecruteur = new ConsultantRecruteur("Andrea", 2, "sauce@gmail.com",recSkills, dispo );
        Localisation localisation = new Localisation("2 rue des Bois jolis", "A", "3");
        List<Equipement> equipements = new ArrayList<Equipement>();
        equipements.add(Equipement.CHAISE);
        equipements.add(Equipement.TABLE);
        equipements.add(Equipement.TABLEAU);
        equipements.add(Equipement.ORDINATEUR);
        Salle salle = new Salle("A32","A32", localisation, equipements, 15);
        return new Entretien(creneau, consultantRecruteur, candidat, salle);
    }
    @Test
    public void cree_entretien(){
        Entretien entretien = creerEntretien();
        Assert.assertNotNull(entretien.getEntretienId());
    }
    @Test
    public void confirme_entretien(){
        Entretien entretien = creerEntretien();
        entretien.confirmer();
        Assert.assertEquals(entretien.getStatut(), Statut.CONFIRME);
    }
    @Test
    public void annule_entretien(){
        Entretien entretien = creerEntretien();
        entretien.annuler("Le recruteur est absent");
        Assert.assertEquals(entretien.getStatut(), Statut.ANNULE);
    }
    @Test
    public void entretiens_differents(){
        Entretien entretien = creerEntretien();
        Entretien entretienSecond = creerEntretien();
        Assert.assertNotEquals(entretien.getEntretienId(), entretienSecond.getEntretienId());
    }
}
