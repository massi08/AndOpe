package Controllers.Vuejs.Exercices;
import Controllers.*;


import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/api/vuejs/exercice2")
public class Exercice2 {

    @GetMapping
    @ResponseBody
    public ObjetReponse receiveGet(HttpServletResponse reponse) {
        reponse.setStatus(405);
        return new ObjetReponse("error", "", "la demande n'est pas prise en compte (GET sur exercice).");
    }

    @PostMapping
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="answer", required = true) String answer,
                                    HttpSession session) {
        System.out.println(answer);
        String pattern = "(^\\{\\{)([a-z]*)(\\}\\}$)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(answer);
        if (m.find()) {
            for (int i=0; i<=m.groupCount(); i++) {
                System.out.println("Found value: " + m.group(i) );
                if(i==2){
                    if(!m.group(i).equals("message")){
                        return new ObjetReponse("success", "almost", "Vous y êtes preques. Vérifiez bien le contenu du chevron ;).");
                    }
                }
            }
            return new ObjetReponse("success", "done", "Bravo! Passez à l'exercice suivant.");
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour le data-binding :)");
        }

    }

}