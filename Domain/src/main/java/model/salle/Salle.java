package model.salle;

import java.util.List;

public class Salle {
    private final String salleID;
    private String nom;
    private final Localisation localisation;
    private List<Equipement> equipement;
    private int capacite;

    public Salle(String salleID, String nom, Localisation localisation, List<Equipement> equipement, int capacite) {
        this.salleID = salleID;
        this.nom = nom;
        this.localisation = localisation;
        this.equipement = equipement;
        this.capacite = capacite;
    }

    public String getSalleID() {
        return salleID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(List<Equipement> equipement) {
        this.equipement = equipement;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Localisation getLocalisation() {
        return localisation;
    }
}