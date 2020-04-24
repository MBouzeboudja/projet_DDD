package use_case.entretien;

import exposition.EntretienRequest;
import model.candidat.Candidat;
import model.candidat.Candidats;
import model.consultantRecruteur.ConsultantRecruteur;
import model.consultantRecruteur.ConsultantRecruteurs;
import model.consultantRecruteur.exception.ConsultantRecruteurException;
import model.entretien.Creneau;
import model.entretien.Entretien;
import model.salle.Salle;
import model.salle.Salles;
import model.salle.exception.SalleException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PlanificationEntretien {
    private final Candidats candidats;
    private final ConsultantRecruteurs consultantRecruteurs;
    private final Salles salles;

    public PlanificationEntretien(Candidats candidats, ConsultantRecruteurs consultantRecruteurs, Salles salles) {
        this.candidats = candidats;
        this.consultantRecruteurs = consultantRecruteurs;
        this.salles = salles;
    }

    public Entretien creerEntretien(EntretienRequest request) throws ConsultantRecruteurException, SalleException{

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
