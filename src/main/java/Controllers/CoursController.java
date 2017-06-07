package Controllers;


import Metier.CoursManager;
import Model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/cours")
public class CoursController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ObjetReponse receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idCours", required = false) String idCours) {
        Cours cours = null;
        if(title != null && !title.equals("")) {
            cours = coursManager.getCours(title);
            return new ObjetReponse("success", "", cours.getTitle());
        }else if(idCours != null && !idCours.equals("")){
            int idC = Integer.valueOf(idCours);
            cours = coursManager.getCours(idC);
            return new ObjetReponse("success", "", "Voici le cours intitulé " + cours.getTitle());
        }
        return new ObjetReponse("error", "", "Une erreur est survenue lors de la récupération du cours.");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="nbExercices", required = true, defaultValue = "0") int nbExercices,
                                    HttpSession session) {


        Cours cours = coursManager.newCours(title,nbExercices);
        if(cours != null) {
            return new ObjetReponse("success", "", "Le cours " + cours.getTitle() + " est bien crée.");
        }

        return new ObjetReponse("error", "", "Une erreur est survenue lors de la création du cours.");
    }
}
