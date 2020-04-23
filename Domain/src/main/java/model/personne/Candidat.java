package model.personne;

import java.util.List;

public class Candidat {
    private final String nom;
    private final int anneeXP;
    private final String mail;
    private final List<Skill> techSkills;
    private final List<Skill> softSkills;

    public Candidat(String nom, int anneeXP, String mail, List<Skill> techSkills, List<Skill> softSkills) {
        this.nom = nom;
        this.anneeXP = anneeXP;
        this.mail = mail;
        this.techSkills = techSkills;
        this.softSkills = softSkills;
    }
}
