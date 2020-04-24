package use_caseTest.entretien.infrastructure;

import model.personne.Candidat;
import model.personne.Candidats;
import model.personne.Niveau;
import model.personne.Skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CandidatsTest implements Candidats {

    private static Candidat createCandiats() {
        List<Skill> listSkillTech = Arrays.asList( new Skill("java", Niveau.CONFIRME));
        List<Skill> listSoftSkills= Arrays.asList(new Skill("lecture", Niveau.EXPERT));
        return  new Candidat(UUID.fromString("azerty"), "Yohan", 2, "yohan@mail.com", listSkillTech, listSoftSkills, "/photos" );
    }

    @Override
    public Candidat trouveCandidat(String id) {
        return createCandiats();
    }
}
