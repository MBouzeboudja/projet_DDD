package exposition;

public class EntretienRequest {
    private final String candidatID;
    private final String salleID;
    private final String date;
    private final String duree;

    public EntretienRequest(String candidatID, String salleID, String date, String duree) {
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

    public String getDuree() {
        return duree;
    }
}
