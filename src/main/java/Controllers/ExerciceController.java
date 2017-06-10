package Controllers;

import Metier.ChapitreManager;
import Metier.ExerciceManager;
import Model.Chapitre;
import Model.Exercice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exercice")
public class ExerciceController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "chapitremanager")
    private ChapitreManager chapitreManager;

    @Autowired
    @Qualifier(value = "exercicemanager")
    private ExerciceManager exerciceManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idChapitre", required = false) String idChapitre,
                                   @RequestParam(value="idExercice", required = false) String idExercice) {
        Exercice exercice = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(title != null && !title.equals("")) {
                exercice = exerciceManager.getExercice(title);
                return new ModelAndView("success", "", mapper.writeValueAsString(exercice));
            }
            else if(idExercice != null && !idExercice.equals("")){
                int idE = Integer.valueOf(idExercice);
                exercice = exerciceManager.getExercice(idE);
                return new ModelAndView("success", "", mapper.writeValueAsString(exercice));
            }
            else if(idChapitre != null && !idChapitre.equals("")){
                int idC = Integer.valueOf(idChapitre);
                List<Exercice> allExercices = exerciceManager.getAllExercicesByCoursId(idC);
                List<String> allExercicesForJson = new ArrayList<>();
                for (Exercice e:allExercices) {
                    allExercicesForJson.add(mapper.writeValueAsString(e));
                }
                Gson gson = new Gson();
                return new ModelAndView("redirect:/", "", gson.toJson(allExercicesForJson));
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ModelAndView("error", "", "Une erreur est survenue lors de la récupération du exercice.");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="path", required = true) String path,
                                    @RequestParam(value="idChapitre", required = true) String idChapitre,
                                    HttpSession session) {
        int chapitreId = Integer.valueOf(idChapitre);
        Chapitre chapitre = chapitreManager.getChapitre(chapitreId);
        if (chapitre == null){
            return new ObjetReponse("error", "", "Une erreur est survenue lors de la récupération du chapitre.");
        }
        Exercice exercice = exerciceManager.newExercice(title,path,chapitre);
        if(exercice != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                new File("src/main/webapp/html_files/"+chapitre.getCoursByIdCours().getIdCours()+"/exercices/"+exercice.getIdE()).mkdir();
                File file = new File("src/main/webapp/html_files/"+chapitre.getCoursByIdCours().getIdCours()+"/exercices/"+exercice.getIdE()+"/"+exercice.getPath());
                FileWriter writer = new FileWriter(file);
                writer.write("Okay ");
                writer.flush();
                writer.close();
                return new ObjetReponse("success", "", mapper.writeValueAsString(exercice));
            }
            catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return new ObjetReponse("error", "", "Une erreur est survenue lors de la création du chapitre.");
    }
}
