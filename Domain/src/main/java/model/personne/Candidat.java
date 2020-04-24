package model.personne;

import java.util.List;
import java.util.Objects;

public class Candidat {
    private final String nom;
    private final int anneeXP;
    private final String mail;
    private final List<Skill> techSkills;
    private final List<Skill> softSkills;
    private final String cvUrl;

    public Candidat(String nom, int anneeXP, String mail, List<Skill> techSkills, List<Skill> softSkills, String cvUrl) {
        this.nom = nom;
        this.anneeXP = anneeXP;
        this.mail = mail;
        this.techSkills = techSkills;
        this.softSkills = softSkills;
        this.cvUrl = cvUrl;
    }

    public String getNom() {
        return nom;
    }

    public int getAnneeXP() {
        return anneeXP;
    }

    public String getMail() {
        return mail;
    }

    public List<Skill> getTechSkills() {
        return techSkills;
    }

    public List<Skill> getSoftSkills() {
        return softSkills;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidat)) return false;
        Candidat candidat = (Candidat) o;
        return getAnneeXP() == candidat.getAnneeXP() &&
                Objects.equals(getNom(), candidat.getNom()) &&
                Objects.equals(getMail(), candidat.getMail()) &&
                Objects.equals(getTechSkills(), candidat.getTechSkills()) &&
                Objects.equals(getSoftSkills(), candidat.getSoftSkills()) &&
                Objects.equals(getCvUrl(), candidat.getCvUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getAnneeXP(), getMail(), getTechSkills(), getSoftSkills(), getCvUrl());
    }
}
