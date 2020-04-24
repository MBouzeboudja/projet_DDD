package model.personne;

import java.util.Comparator;
import java.util.Objects;

public class Skill{
    private final String nom;
    private final Niveau niveau;

    public Skill(String nom, Niveau niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(getNom(), skill.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getNiveau());
    }

    public boolean comparerQualification(Skill skill){
        if(this.getNom() != skill.getNom())return false;
        System.out.println(this.getNiveau().ordinal());
        System.out.println(skill.getNiveau().ordinal());

        if(this.getNiveau().ordinal() >=  skill.getNiveau().ordinal()){
            return true;
        }
        return false;
    }



}
