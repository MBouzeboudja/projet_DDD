package exposition;

public class EntretienRequest {
    private final String candidatID;
    private final String salleID;
    private final String date;
    private final int duree;

    public EntretienRequest(String candidatID, String salleID, String date, int duree) {
        this.candidatID = candidatID;
        this.salleID = salleID;
        this.date = date;
        this.duree = duree;
    }

    public String getCandidatID() {
        return candidatID;
    }

    public String getSalleID() {
        return salleID;
    }

    public String getDate() {
        return date;
    }

    public int getDuree() {
        return duree;
    }
}
