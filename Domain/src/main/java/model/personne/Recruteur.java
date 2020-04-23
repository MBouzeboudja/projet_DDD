package com.recrutement.entretien;

import java.util.List;

public class Recruteur {
    private final String nom;
    private final int anneeXP;
    private final String mail;
    private final List<Skill> techSkills;

    public Recruteur(String nom, int anneeXP, String mail, List<Skill> techSkills) {
        this.nom = nom;
        this.anneeXP = anneeXP;
        this.mail = mail;
        this.techSkills = techSkills;
    }
}
