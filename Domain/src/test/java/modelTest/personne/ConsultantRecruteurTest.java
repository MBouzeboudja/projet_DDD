package modelTest.personne;

import model.commun.Niveau;
import model.commun.Skill;
import model.consultantRecruteur.ConsultantRecruteur;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultantRecruteurTest {

    private ConsultantRecruteur creer_consultant_recruteur(){
        Skill tech = new Skill("java", Niveau.CONFIRME);
        Skill ddd = new Skill("ddd", Niveau.SENIOR);
        Skill ci = new Skill("ci", Niveau.EXPERT);
        List<Skill> recSkills = new ArrayList<Skill>();
        recSkills.add(tech);
        recSkills.add(ddd);
        recSkills.add(ci);
        List<LocalDate> dispo = new ArrayList<>();
        dispo.add(LocalDate.of(2020, 04, 30));
        return new ConsultantRecruteur("Andrea", 2, "sauce@gmail.com",recSkills, dispo );

    }
    @Test
    public void consultant_recruteur_disponible(){
        ConsultantRecruteur consultantRecruteur = creer_consultant_recruteur();
         Assert.assertTrue(consultantRecruteur.estDisponibleLe(LocalDate.of(2020,04,30)));
    }

    @Test
    public void consultant_recruteur_non_disponible(){
        ConsultantRecruteur consultantRecruteur = creer_consultant_recruteur();
        Assert.assertFalse(consultantRecruteur.estDisponibleLe(LocalDate.of(2020,05,01)));
    }

    @Test
    public void consultant_recruteur_couvre_les_skills(){
        ConsultantRecruteur consultantRecruteur = creer_consultant_recruteur();
        Skill ddd = new Skill("ddd", Niveau.SENIOR);
        Skill ci = new Skill("ci", Niveau.SENIOR);
        List<Skill> skills = new ArrayList<>();
        skills.add(ddd);
        skills.add(ci);
        Assert.assertTrue(consultantRecruteur.couvreLesSkills(skills));
    }

    @Test
    public void consultant_recruteur_ne_couvre_pas_les_skills(){
        ConsultantRecruteur consultantRecruteur = creer_consultant_recruteur();
        Skill ddd = new Skill("go", Niveau.SENIOR);
        Skill ci = new Skill("rlang", Niveau.SENIOR);
        List<Skill> skills = new ArrayList<>();
        skills.add(ddd);
        skills.add(ci);
        Assert.assertFalse(consultantRecruteur.couvreLesSkills(skills));
    }

    @Test
    public void consultant_recruteur_couvre_les_skills_mais_pas_le_niveau(){
        ConsultantRecruteur consultantRecruteur = creer_consultant_recruteur();
        Skill ddd = new Skill("ddd", Niveau.EXPERT);
        Skill ci = new Skill("ci", Niveau.EXPERT);
        List<Skill> skills = new ArrayList<>();
        skills.add(ddd);
        skills.add(ci);
        Assert.assertFalse(consultantRecruteur.couvreLesSkills(skills));
    }
}