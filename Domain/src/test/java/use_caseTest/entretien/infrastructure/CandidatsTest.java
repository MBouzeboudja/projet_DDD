package use_caseTest.entretien.infrastructure;

import model.candidat.Candidat;
import model.candidat.Candidats;
import model.commun.Niveau;
import model.commun.Skill;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CandidatsTest implements Candidats {

    private static Candidat createCandiats() {
        List<Skill> listSkillTech = Arrays.asList( new Skill("java", Niveau.CONFIRME));
        List<Skill> listSoftSkills= Arrays.asList(new Skill("lecture", Niveau.EXPERT));
        return  new Candidat(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"), "ieueeuaahnn", 2, "yohan@mail.com", listSkillTech, listSoftSkills, "/photos" );
    }

    @Override
    public Candidat trouveCandidat(String id) {
        return createCandiats();
    }
}
