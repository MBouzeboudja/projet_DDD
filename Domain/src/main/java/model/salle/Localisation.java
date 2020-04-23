package model.salle;

public class Localisation {
    private final String adresse;
    private final String batiment;
    private final String etage;

    public Localisation(String adresse, String batiment, String etage) {
        this.adresse = adresse;
        this.batiment = batiment;
        this.etage = etage;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBatiment() {
        return batiment;
    }

    public String getEtage() {
        return etage;
    }
}
