package model.entretien;

import model.candidat.Candidat;
import model.consultantRecruteur.ConsultantRecruteur;
import model.salle.Salle;

import java.util.Objects;
import java.util.UUID;


public class Entretien {
    private final EntretienID entretienId;
    private Statut statut;
    private Creneau creneau;
    private ConsultantRecruteur consultantRecruteur;
    private Candidat candidat;
    private String raisonAnnulation;
    private Salle salle;

    public Entretien(Creneau creneau, ConsultantRecruteur consultantRecruteur, Candidat candidat, Salle salle) {
        this.entretienId = new EntretienID(UUID.randomUUID());
        setStatut(Statut.PLANIFIE);
        this.creneau = creneau;
        this.consultantRecruteur = consultantRecruteur;
        this.candidat = candidat;
        this.salle = salle;
    }

    public EntretienID getEntretienId() {
        return entretienId;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public ConsultantRecruteur getConsultantRecruteur() {
        return consultantRecruteur;
    }

    public void setConsultantRecruteur(ConsultantRecruteur consultantRecruteur) {
        this.consultantRecruteur = consultantRecruteur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public String getRaisonAnnulation() {
        return raisonAnnulation;
    }

    public void setRaisonAnnulation(String raison) {
        this.raisonAnnulation = raison;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entretien)) return false;
        Entretien entretien = (Entretien) o;
        return this.entretienId.equals(entretien.entretienId) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entretienId, statut, creneau, consultantRecruteur, candidat);
    }

    public void confirmer(){
        setStatut(Statut.CONFIRME);
    }

    public void annuler(String raisonAnnulation){
        setStatut(Statut.ANNULE);
        setRaisonAnnulation(raisonAnnulation);
    }
}
