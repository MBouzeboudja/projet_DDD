package use_caseTest.entretien.infrastructure;

import model.personne.ConsultantRecruteur;
import model.personne.ConsultantRecruteurs;
import model.personne.Niveau;
import model.personne.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultantRecruteursTest implements ConsultantRecruteurs {
    @Override
    public List<ConsultantRecruteur> trouverConsultantRecruteurs(String date) {
        List<ConsultantRecruteur> consultantRecruteurList = new ArrayList<>();

        consultantRecruteurList.add(new ConsultantRecruteur(
                "Patrick",
                10,
                "patrick@soat.fr",
                Arrays.asList(new Skill("java", Niveau.SENIOR), new  Skill("C", Niveau.EXPERT)),
                Arrays.asList(LocalDate.parse("2020-05-04"), LocalDate.parse("2020-05-05"), LocalDate.parse("2020-05-08"), LocalDate.parse("2020-05-11"))
        ));

        consultantRecruteurList.add(new ConsultantRecruteur(
                "Martin",
                8,
                "martin@soat.fr",
                Arrays.asList(new Skill("java", Niveau.CONFIRME), new  Skill("nodejs", Niveau.EXPERT)),
                Arrays.asList(LocalDate.parse("2020-05-08"), LocalDate.parse("2020-05-12"), LocalDate.parse("2020-05-08"), LocalDate.parse("2020-05-13"))
        ));

        consultantRecruteurList.add(new ConsultantRecruteur(
                "George",
                25,
                "george@soat.fr",
                Arrays.asList(new Skill("Python", Niveau.EXPERT), new  Skill("C", Niveau.DEBUTANT)),
                Arrays.asList(LocalDate.parse("2020-05-11"), LocalDate.parse("2020-05-13"), LocalDate.parse("2020-05-08"), LocalDate.parse("2020-05-17"))
        ));

        return consultantRecruteurList;
    }
}
