package Controllers;

import Metier.ChapitreManager;
import Metier.CoursManager;
import Metier.UserManager;
import Model.Chapitre;
import Model.Cours;
import Model.User;
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
public class ChapitreController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "chapitremanager")
    private ChapitreManager chapitreManager;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @Autowired
    @Qualifier(value = "usermanager")
    private UserManager usermanager;

    @RequestMapping(value = "/chapitre", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idChapitre", required = false) String idChapitre,
                                   @RequestParam(value="idCours", required = false) String idCours,
                                   HttpSession session) {
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Chapitre chapitre = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(title != null && !title.equals("")) {
                chapitre = chapitreManager.getChapitre(title);
                return new ModelAndView("chapitre", "", mapper.writeValueAsString(chapitre));
            }
            else if(idChapitre != null && !idChapitre.equals("")){
                int idC = Integer.valueOf(idChapitre);
                chapitre = chapitreManager.getChapitre(idC);
                return new ModelAndView("chapitre", "", mapper.writeValueAsString(chapitre));
            }
            else if(idCours != null && !idCours.equals("")){
                ModelAndView modelAndView = new ModelAndView("chapitre");
                int idC = Integer.valueOf(idCours);
                List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
                List<String> allChapitreForJson = new ArrayList<>();
                for (Chapitre c:allChapitre) {
                    allChapitreForJson.add(mapper.writeValueAsString(c));
                }
                modelAndView.addObject("chapitre",allChapitre);
                modelAndView.addObject("user", user);
                return modelAndView;
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ModelAndView("manage_project");
    }

    @GetMapping("/chapitre/cours/{idCours}")
    @ResponseBody
    public ModelAndView receiveGetChapitre(@PathVariable String idCours,
                                           HttpSession session){
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView("chapitre");
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.addObject("chapitres",allChapitre);
        return modelAndView;
    }

    @GetMapping("/addchapitre/cours/{idCours}")
    @ResponseBody
    public ModelAndView receiveGetAddChapitre(@PathVariable String idCours,
                                              HttpSession session){
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView("add_chapitre");
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        return modelAndView;
    }

    @RequestMapping(value = "/chapitre", method = RequestMethod.POST)
    @ResponseBody
    public ObjetReponse receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="idCours", required = true) String idCours,
                                    @RequestParam(value="cours", required = true) String coursContent,
                                    HttpSession session) {
        int coursId = Integer.valueOf(idCours);
        Cours cours = coursManager.getCours(coursId);
        if (cours == null){
            return new ObjetReponse("error", "", "Une erreur est survenue lors de la récupération du chapitre.");
        }
        Chapitre chapitre = chapitreManager.newChapitre(title,"id",cours);
        if(chapitre != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                File file = new File("src/main/webapp/html_files/"+cours.getIdCours()+"/cours/"+chapitre.getIdC()+".jsp");
                FileWriter writer = new FileWriter(file);
                writer.write(coursContent);
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
