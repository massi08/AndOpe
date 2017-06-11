package Controllers.Vuejs.Exercices;

import Controllers.ObjetReponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/vuejs/exercice3")
public class Exercice3 {


    @GetMapping
    @ResponseBody
    public ModelAndView receiveGet(HttpServletResponse reponse) {
        return new ModelAndView("exercice3");
    }

    @PostMapping
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="answer", required = true) String answer,
                                    HttpSession session) {
        System.out.println(answer);
        //String pattern = "(var\\ +(app)\\ +=\\ +new\\ +(Vue)\\ *\\(\\ *\\{\n*\\ +)";
        String createVuePattern = "(?m)(^\\s*var\\s+([a-zA-Z0-9_-]+)\\s+=\\s+new\\s+(Vue)\\s*\\(\\s*\\{(.|\\n|\\s)*\\}(\\n|\\s)*\\))";
        String vueElementPattern = "(?m)(\\n*\\s*el\\s*:\\s*\'([a-z0-9_.#-]+)\',?)";
        //String vueDataPattern = "(?m)(\\s*data\\s*:\\s*\\{\\n*(\\s*([a-zA-Z0-9:#,']|\\s*)*\\n)*\\s*\\})";
        String vueDataPattern = "(\\s*data\\s*:\\s*\\{((\\n|\\s|[a-zA-Z0-9:!#,'])*)\\})";
        //data: \{\n*(\s*([a-zA-Z0-9:#,']|\s*)*\n)*\s*\}
        String insideDataPattern = "\\n*\\s*([a-zA-Z0-9]*)\\s*:\\s*\'([a-zA-Z0-9:!#, ]*)\'";
        Pattern vueR = Pattern.compile(createVuePattern);
        Pattern elementR = Pattern.compile(vueElementPattern);
        Pattern dataR = Pattern.compile(vueDataPattern);
        Pattern insideDataR = Pattern.compile(insideDataPattern, Pattern.MULTILINE);
        Matcher m = vueR.matcher(answer);
        Matcher mElement = elementR.matcher(answer);
        Matcher mData = dataR.matcher(answer);
        if (mElement.find()){
            System.out.println("el trouve");
            for (int i=0; i<=mElement.groupCount(); i++) {
                if(i==2){
                    if (!mElement.group(i).equals("#app")){
                        return new ObjetReponse("success", "almost", "Vérifiez bien si le nom de l'élément de la vue correspond à celui qui est demandé.");
                    }
                }
            }
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'un element d'une Vue :)");
        }
        HashMap<String,String> data = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if(mData.find()){
            for (int i=0; i<=mData.groupCount(); i++) {
                if(i==2){
                    String []all = mData.group(i).split(",");
                    int nbCounter = 0;
                    for (String s:all) {
                        Matcher md = insideDataR.matcher(s);
                        if(md.find()){
                            for (int j = 0 ; j<=md.groupCount(); j++) {
                                System.out.println(j + " --> " + md.group(j));
                                if(j == 1 && md.group(j).equals("firstname")  || md.group(j).equals("lastname")) {
                                    nbCounter++;
                                }
                            }
                            data.put(md.group(1),md.group(2));
                        }
                    }
                    if(nbCounter < 2){
                        return new ObjetReponse("success", "almost", "Rajouter bien les données firstname et lastname");
                    }
                }
            }
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'un data d'une Vue :)");
        }
        if (m.find()) {
            for (int i = 0 ; i<=m.groupCount(); i++) {
                if(i==2){
                    if (!m.group(i).equals("app")){
                        return new ObjetReponse("success", "almost", "Vérifiez bien si le nom de la variable correspond à celui qui est demandé.");
                    }
                }
            }
            try {
                return new ObjetReponse("success", "done", mapper.writeValueAsString(data));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else {
            return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'une Vue :)");
        }
        return new ObjetReponse("error", "", "Vérifie bien la syntaxe pour la création d'une Vue :)");
    }
}
