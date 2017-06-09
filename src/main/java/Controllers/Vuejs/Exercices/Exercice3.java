package Controllers.Vuejs.Exercices;

import Controllers.ObjetReponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/vuejs/exercice3")
public class Exercice3 {


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
        //String pattern = "(var\\ +(app)\\ +=\\ +new\\ +(Vue)\\ *\\(\\ *\\{\n*\\ +)";
        String createVuePattern = "(?m)(^var\\ +([a-z]+)\\ +=\\ +new\\ +(Vue)\\ *\\(\\ *\\{)";
        String vueElementPattern = "(?m)(\\ *el\\ *:\\ *\'([a-z]+)\',)";
        String vueDataPattern = "(?m)(\\ *data\\ *:\\ *\\{\\s+)";
        Pattern vueR = Pattern.compile(createVuePattern);
        Pattern elementR = Pattern.compile(vueElementPattern);
        Pattern dataR = Pattern.compile(vueDataPattern);
        Matcher m = vueR.matcher(answer);
        Matcher mElement = elementR.matcher(answer);
        Matcher mData = dataR.matcher(answer);
        if (mElement.find()){
            for (int i=0; i<=mElement.groupCount(); i++) {
                if(i==2){
                    if (!mElement.group(i).equals("app")){
                        return new ObjetReponse("success", "almost", "Vérifiez bien si le nom de l'élément de la vue correspond à celui qui est demandé.");
                    }
                }
            }
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'un element d'une Vue :)");
        }
        if(mData.find()){
            for (int i=0; i<=mData.groupCount(); i++) {
                if(i==2){
                    if (!mData.group(i).equals("app")){
                        return new ObjetReponse("success", "almost", "Vérifiez bien si le nom de l'élément de la vue correspond à celui qui est demandé.");
                    }
                }
                System.out.println(i + " found: " + mData.group(i));
            }
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'un element d'une Vue :)");
        }
        if (m.find()) {
            for (int i = 0 ; i<=m.groupCount(); i++) {
                if(i==2){
                    if (!m.group(i).equals("app")){
                        return new ObjetReponse("success", "almost", "Vérifiez bien si le nom de la variable correspond à celui qui est demandé.");
                    }
                }
            }
            return new ObjetReponse("success", "", "Bravo! Passez à l'exercice suivant.");
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'une Vue :)");
        }

    }
}
