package modelTest.salle;

import model.salle.Equipement;
import model.salle.Localisation;
import model.salle.Salle;
import model.salle.exception.SalleException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;

public class SalleTest {

    @Test
    public void salle_valide(){
        Localisation localisation = new Localisation("2 rue des Bois jolis", "A", "3");
        List<Equipement> equipements = new ArrayList<Equipement>();
        Salle salle = new Salle("A32","reunion_entretien", localisation, equipements, 3);
        Assert.assertEquals(salle.getCapacite(), 3);
        Assert.assertEquals(salle.getEquipement(), equipements);
        Assert.assertEquals(salle.getLocalisation(), localisation);
        Assert.assertEquals(salle.getNom(), "reunion_entretien");
        Assert.assertEquals(salle.getSalleID(), "A32");
    }

    @Test
    public void exception_si_capacite_salle_faible(){
        Localisation localisation = new Localisation("2 rue des Bois jolis", "A", "3");
        List<Equipement> equipements = new ArrayList<Equipement>();
        assertThrows(SalleException.class,
                ()->{
                    Salle salle = new Salle("A32","A32", localisation, equipements, 1);
                });
    }
}
