package Controllers;

import Metier.ChapitreManager;
import Metier.CoursManager;
import Model.Chapitre;
import Model.Cours;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chapitre")
public class ChapitreController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "chapitremanager")
    private ChapitreManager chapitreManager;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ObjetReponse receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idChapitre", required = false) String idChapitre,
                                   @RequestParam(value="idCours", required = false) String idCours) {
        Chapitre chapitre = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(title != null && !title.equals("")) {
                chapitre = chapitreManager.getChapitre(title);
                return new ObjetReponse("success", "", mapper.writeValueAsString(chapitre));
            }
            else if(idChapitre != null && !idChapitre.equals("")){
                int idC = Integer.valueOf(idChapitre);
                chapitre = chapitreManager.getChapitre(idC);
                return new ObjetReponse("success", "", mapper.writeValueAsString(chapitre));
            }
            else if(idCours != null && !idCours.equals("")){
                int idC = Integer.valueOf(idCours);
                List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
                List<String> allChapitreForJson = new ArrayList<>();
                for (Chapitre c:allChapitre) {
                    allChapitreForJson.add(mapper.writeValueAsString(c));
                }
                Gson gson = new Gson();
                return new ObjetReponse("success", "", gson.toJson(allChapitreForJson));
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ObjetReponse("error", "", "Une erreur est survenue lors de la récupération du chapitre.");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="path", required = true) String path,
                                    @RequestParam(value="idCours", required = true) String idCours,
                                    HttpSession session) {
        int coursId = Integer.valueOf(idCours);
        Cours cours = coursManager.getCours(coursId);
        if (cours == null){
            return new ObjetReponse("error", "", "Une erreur est survenue lors de la récupération du chapitre.");
        }
        Chapitre chapitre = chapitreManager.newChapitre(title,path,cours);
        System.out.println(chapitre);
        System.out.println("broo");
        if(chapitre != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                File file = new File("src/main/webapp/html_files/"+cours.getTitle()+"/cours/"+path);
                FileWriter writer = new FileWriter(file);
                writer.write("Hello World\n");
                writer.write("Okay ");
                writer.flush();
                writer.close();
                return new ObjetReponse("success", "", mapper.writeValueAsString(chapitre));
            }
            catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return new ObjetReponse("error", "", "Une erreur est survenue lors de la création du cours.");
    }
}
