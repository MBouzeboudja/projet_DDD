package use_caseTest.entretien.infrastructure;

import model.salle.Equipement;
import model.salle.Localisation;
import model.salle.Salle;
import model.salle.Salles;

import java.util.ArrayList;
import java.util.List;

public class SallesTest implements Salles {
    @Override
    public List<Salle> trouverSallesDisponibles(String datetime, int duree) {
        Localisation localisation = new Localisation("2 rue des Bois jolis", "A", "3");
        List<Equipement> equipements = new ArrayList<Equipement>();
        equipements.add(Equipement.CHAISE);
        equipements.add(Equipement.TABLEAU);
        equipements.add(Equipement.GEL_HYDRO);
        Salle salle = new Salle("A32","reunion_entretien", localisation, equipements, 3);

        Localisation localisation2 = new Localisation("14 andre maleraux", "B", "1");
        List<Equipement> equipements2 = new ArrayList<Equipement>();
        Salle salle2 = new Salle("B1","reunion_entretien", localisation, equipements, 10);

        Localisation localisation3 = new Localisation("102 les belles rues", "C", "2");
        List<Equipement> equipements3 = new ArrayList<Equipement>();
        Salle salle3 = new Salle("C2","reunion_entretien", localisation, equipements, 12);

        List<Salle> salles = new ArrayList<>();
        salles.add(salle);
        salles.add(salle2);
        salles.add(salle3);

        return salles;
    }
}
