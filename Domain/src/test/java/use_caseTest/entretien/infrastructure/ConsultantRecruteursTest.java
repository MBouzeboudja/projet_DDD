package use_caseTest.entretien.infrastructure;

import model.commun.Niveau;
import model.commun.Skill;
import model.consultantRecruteur.ConsultantRecruteur;
import model.consultantRecruteur.ConsultantRecruteurs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultantRecruteursTest implements ConsultantRecruteurs {
    @Override
    public List<ConsultantRecruteur> trouverConsultantRecruteurs(String date) {



        List<ConsultantRecruteur> consultantRecruteurList = new ArrayList<>();

        if(date == "2020-05-12T18:10:00.000"){
            consultantRecruteurList.add(new ConsultantRecruteur(
                    "Patrick",
                    10,
                    "patrick@soat.fr",
                    Arrays.asList(new Skill("java", Niveau.SENIOR), new  Skill("C", Niveau.EXPERT)),
                    Arrays.asList(LocalDate.parse("2020-05-04"), LocalDate.parse("2020-05-12"), LocalDate.parse("2020-05-08"), LocalDate.parse("2020-05-11"))
            ));
            consultantRecruteurList.add(new ConsultantRecruteur(
                    "Martin",
                    8,
                    "martin@soat.fr",
                    Arrays.asList(new Skill("java", Niveau.CONFIRME), new  Skill("nodejs", Niveau.EXPERT)),
                    Arrays.asList(LocalDate.parse("2020-05-04"), LocalDate.parse("2020-05-12"),  LocalDate.parse("2020-05-13"))
            ));
        }

        return consultantRecruteurList;
    }
}
