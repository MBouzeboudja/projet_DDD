package use_caseTest.entretien.infrastructure;

import model.salle.Salle;
import model.salle.Salles;

import java.util.ArrayList;
import java.util.List;

public class SallesIndisponiblesTest implements Salles {
    @Override
    public List<Salle> trouverSallesDisponibles(String datetime, int duree) {
        return new ArrayList<>();
    }
}
