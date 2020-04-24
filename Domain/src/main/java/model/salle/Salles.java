package model.salle;

import java.time.LocalDateTime;
import java.util.List;

public interface Salles {

    public List<Salle> trouverSallesDisponibles(String datetime, int duree);
}
