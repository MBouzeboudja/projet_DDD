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
import model.salle.exception.SalleException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CreerEntretien {
    private final Candidats candidats;
    private final ConsultantRecruteurs consultantRecruteurs;
    private final Salles salles;

    public CreerEntretien(Candidats candidats, ConsultantRecruteurs consultantRecruteurs, Salles salles) {
        this.candidats = candidats;
        this.consultantRecruteurs = consultantRecruteurs;
        this.salles = salles;
    }

    public Entretien creerEntretien(EntretienRequest request){

        Candidat candidat = candidats.trouveCandidat(request.getCandidatID());

        List<ConsultantRecruteur> listeConsultantRecruteur = consultantRecruteurs.trouverConsultantRecruteurs(request.getDate());
        Optional<ConsultantRecruteur> consultantRecruteur = listeConsultantRecruteur.stream()
                .filter(cr -> cr.couvreLesSkills(candidat.getTechSkills()))
                .findFirst();
        if(!consultantRecruteur.isPresent()){
            throw new ConsultantRecruteurException("Aucun consultant recruteur n'a été trouvé");
        }

        List<Salle> listeSalle = salles.trouverSallesDisponibles(request.getDate(), request.getDuree());
        Optional<Salle> salle = listeSalle.stream()
                .findFirst();
        if(!salle.isPresent()){
            throw new SalleException("Aucune salle n'a été trouvé pour cette date et heure");
        }

        LocalDateTime dateHeure = LocalDateTime.parse(request.getDate());

        Creneau creneau = new Creneau(dateHeure, request.getDuree());

        return new Entretien(creneau, consultantRecruteur.get(), candidat, salle.get());
    }
}
