package model.salle;

import java.util.List;

public interface Salles {

    public List<Salle> trouverSallesDisponibles(String datetime, int duree);
}
