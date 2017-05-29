package controllers.Vuejs.Exercices;
import controllers.*;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/vuejs/exercice2")
public class Exercice2 {

    @GetMapping
    @ResponseBody
    public ObjetReponse receiveGet(HttpServletResponse reponse) {
        reponse.setStatus(405);
        return new ObjetReponse("error", "", "la demande n'est pas prise en compte (GET sur exercice).");
    }

    @PostMapping
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="answer", required = true) int answer,
                                    HttpSession session) {
        System.out.println("exo2");
        if(answer == 2)
            return new ObjetReponse("success", "", "Bravo! Passez à l'exercice suivant.");
        else
            return new ObjetReponse("error", "", "Ceci n'est pas la bonne réponse");
    }

}