package com.recrutement.entretienTest;

import com.recrutement.entretien.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EntretienTest {
    @Test
    public void confirme_entretien(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        Creneau creneau = new Creneau(date, 45);
        Skill tech = new Skill("java", Niveau.CONFIRME);
        Skill soft = new Skill("japonais", Niveau.DEBUTANT);
        List<Skill> recSkills = new ArrayList<Skill>();
        recSkills.add(tech);
        List<Skill> candidatSkills = new ArrayList<Skill>();
        candidatSkills.add(tech);
        List<Skill> candidatTechSkills = new ArrayList<Skill>();
        candidatTechSkills.add(soft);
        Candidat candidat = new Candidat("yohann", 1, "bunu@gmail.com", candidatTechSkills, candidatSkills);
        Recruteur recruteur = new Recruteur("Andrea", 2, "sauce@gmail.com",recSkills );
        Entretien entretien = new Entretien(creneau, recruteur, candidat);

        entretien.confirmer();
        Assert.assertEquals(entretien.getStatut(), Statut.CONFIRME);
    }
    @Test
    public void annule_entretien(){
        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        Creneau creneau = new Creneau(date, 45);
        Skill tech = new Skill("java", Niveau.CONFIRME);
        Skill soft = new Skill("japonais", Niveau.DEBUTANT);
        List<Skill> recSkills = new ArrayList<Skill>();
        recSkills.add(tech);
        List<Skill> candidatSkills = new ArrayList<Skill>();
        candidatSkills.add(tech);
        List<Skill> candidatTechSkills = new ArrayList<Skill>();
        candidatTechSkills.add(soft);
        Candidat candidat = new Candidat("yohann", 1, "bunu@gmail.com", candidatTechSkills, candidatSkills);
        Recruteur recruteur = new Recruteur("Andrea", 2, "sauce@gmail.com",recSkills );
        Entretien entretien = new Entretien(creneau, recruteur, candidat);

        entretien.annuler("Le recruteur est absent");
        Assert.assertEquals(entretien.getStatut(), Statut.ANNULE);
    }


    @Test
    public void entretiens_différents(){


        LocalDateTime date = LocalDateTime.of(LocalDate.of(2020, 04, 30), LocalTime.of(14, 00));
        Creneau creneau = new Creneau(date, 45);
        Skill tech = new Skill("java", Niveau.CONFIRME);
        Skill soft = new Skill("japonais", Niveau.DEBUTANT);
        List<Skill> recSkills = new ArrayList<Skill>();
        recSkills.add(tech);
        List<Skill> candidatSkills = new ArrayList<Skill>();
        candidatSkills.add(tech);
        List<Skill> candidatTechSkills = new ArrayList<Skill>();
        candidatTechSkills.add(soft);
        Candidat candidat = new Candidat("yohann", 1, "bunu@gmail.com", candidatTechSkills, candidatSkills);
        Recruteur recruteur = new Recruteur("Andrea", 2, "sauce@gmail.com",recSkills );
        Entretien entretien = new Entretien(creneau, recruteur, candidat);


        LocalDateTime dateRep = LocalDateTime.of(LocalDate.of(2020, 05, 04), LocalTime.of(14, 00));
        Creneau creneauRep = new Creneau(dateRep, 60);
        Entretien entretienSecond = new Entretien(creneauRep, recruteur, candidat);

        Assert.assertNotEquals(entretien.getEntretienId(), entretienSecond.getEntretienId());
    }
}
