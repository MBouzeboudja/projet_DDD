package model.salle;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Localisation)) return false;
        Localisation that = (Localisation) o;
        return Objects.equals(getAdresse(), that.getAdresse()) &&
                Objects.equals(getBatiment(), that.getBatiment()) &&
                Objects.equals(getEtage(), that.getEtage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdresse(), getBatiment(), getEtage());
    }
}
