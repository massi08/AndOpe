package Controllers;


import Metier.CoursManager;
import Model.Cours;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idCours", required = false) String idCours) {
        Cours cours = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(title != null && !title.equals("")) {
                cours = coursManager.getCours(title);
                return new ModelAndView("manage_project", "", mapper.writeValueAsString(cours));
            }
            else if(idCours != null && !idCours.equals("")){
                int idC = Integer.valueOf(idCours);
                cours = coursManager.getCours(idC);
                return new ModelAndView("manage_project", "", mapper.writeValueAsString(cours));
            }
            else if(idCours == null && title == null){
                ModelAndView modelAndView = new ModelAndView("manage_project");
                List<Cours> allCours = coursManager.getAllCours();
                List<String> allCoursForJson = new ArrayList<>();
                for (Cours c:allCours) {
                    allCoursForJson.add(mapper.writeValueAsString(c));
                }
                Gson gson = new Gson();
                modelAndView.addObject("cours", allCours);
                return modelAndView;
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ModelAndView("index", "", "Une erreur est survenue lors de la récupération du cours.");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="nbExercices", required = true, defaultValue = "0") int nbExercices,
                                    HttpSession session) {
        Cours cours = coursManager.newCours(title,nbExercices);
        if(cours != null) {
            new File("src/main/webapp/html_files/"+title).mkdir();
            new File("src/main/webapp/html_files/"+title+"/cours").mkdir();
            new File("src/main/webapp/html_files/"+title+"/exercices").mkdir();
            return new ObjetReponse("success", "", "Le cours " + cours.getTitle() + " est bien crée.");
        }
        return new ObjetReponse("error", "", "Une erreur est survenue lors de la création du cours.");
    }
}
