package model.personne;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConsultantRecruteur {
    private final String nom;
    private final int anneeXP;
    private final String mail;
    private final List<Skill> techSkills;
    private final List<LocalDate> disponibilite;

    public ConsultantRecruteur(String nom, int anneeXP, String mail, List<Skill> techSkills, List<LocalDate> disponibilite) {
        this.nom = nom;
        this.anneeXP = anneeXP;
        this.mail = mail;
        this.techSkills = techSkills;
        this.disponibilite = disponibilite;
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

    public List<LocalDate> getDisponibilite() {
        return disponibilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsultantRecruteur)) return false;
        ConsultantRecruteur that = (ConsultantRecruteur) o;
        return getAnneeXP() == that.getAnneeXP() &&
                Objects.equals(getNom(), that.getNom()) &&
                Objects.equals(getMail(), that.getMail()) &&
                Objects.equals(getTechSkills(), that.getTechSkills()) &&
                Objects.equals(getDisponibilite(), that.getDisponibilite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getAnneeXP(), getMail(), getTechSkills(), getDisponibilite());
    }

    public boolean estDisponibleLe(LocalDate date){
        return disponibilite.contains(date);
    }

    public boolean couvreLesSkills(List<Skill> skills){
        if(!techSkills.containsAll(skills)) return false;
        for (Skill skill: skills ) {
            skill.comparerQualification(techSkills.get(techSkills.indexOf(skill)));
        }
        return true;
    }
}
