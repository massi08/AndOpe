package controllers.Vuejs.Exercices;
import controllers.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.persistence.EntityManager;
//import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vuejs/exercice1")
public class Exercice1 {

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
        System.out.println("exo1");
        if(answer == 2)
            return new ObjetReponse("success", "", "Bravo! Passez à l'exercice suivant.");
        else
            return new ObjetReponse("error", "", "Ceci n'est pas la bonne réponse");
    }

}
