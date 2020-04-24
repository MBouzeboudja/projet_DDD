package use_case.entretien;

import exposition.EntretienRequest;
import model.entretien.Creneau;
import model.entretien.Entretien;
import model.entretien.Entretiens;
import model.personne.Candidat;
import model.personne.Candidats;
import model.personne.ConsultantRecruteur;
import model.personne.ConsultantRecruteurs;
import model.personne.exception.ConsultantRecruteurException;
import model.salle.Salle;
import model.salle.Salles;

import java.util.List;
import java.util.Optional;

public class CreerEntretien {
    private final Candidats candidats;
    private final ConsultantRecruteurs consultantRecruteurs;
    private final Entretiens entretiens;
    private final Salles salles;

    public CreerEntretien(Candidats candidats, ConsultantRecruteurs consultantRecruteurs, Entretiens entretiens, Salles salles) {
        this.candidats = candidats;
        this.consultantRecruteurs = consultantRecruteurs;
        this.entretiens = entretiens;
        this.salles = salles;
    }

    public Entretien creerEntretien(EntretienRequest request){
        List<ConsultantRecruteur> listeConsultantRecruteur = consultantRecruteurs.trouverConsultantRecruteurs(request.getDate());
        Candidat candidat = candidats.trouveCandidat(request.getCandidatID());
        Optional<ConsultantRecruteur> consultantRecruteur = listeConsultantRecruteur.stream().filter(el -> el.couvreLesSkills(candidat.getTechSkills())).findFirst();

        if(!consultantRecruteur.isPresent())throw new ConsultantRecruteurException("Aucun consultant recruteur n'a été trouvé");

        List<Salle> listeSalle = salles.trouverSallesDisponibles(request.getDate());
        Candidat candidat = candidats.trouveCandidat(request.getCandidatID());
        Optional<ConsultantRecruteur> listeSalle = listeconsultantRecruteur.stream().filter(el -> el.couvreLesSkills(candidat.getTechSkills())).findFirst();
        Salle salle = ???
        Creneau creneau = new Creneau()

    }
}
