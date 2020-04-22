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
        List<Skill> rec_skills = new ArrayList<Skill>();
        rec_skills.add(tech);
        List<Skill> candidat_skills = new ArrayList<Skill>();
        rec_skills.add(tech);
        rec_skills.add(soft);
        Candidat candidat = new Candidat("yohann", 1, "bunu@gmail.com", );
        Recruteur recruteur = new Recruteur("Andrea", 2, "sauce@gmail.com", );
        Entretien entretien = new Entretien(creneau, recruteur, candidat)
        Assert.assertEquals(c.getHeureFin(), LocalTime.of(14,45));
    }
    @Test
    public void annule_entretien(){

        Assert.assertEquals(c.getHeureFin(), LocalTime.of(14,45));
    }
    @Test
    public void entretiens_différents(){

        Assert.assertEquals(c.getHeureFin(), LocalTime.of(14,45));
    }
}
