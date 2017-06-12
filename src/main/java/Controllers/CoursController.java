package Controllers;


import Metier.CoursManager;
import Metier.ProfileManager;
import Metier.UserChapitreManager;
import Metier.UserManager;
import Model.Cours;
import Model.Profile;
import Model.User;
import Model.Userchapitre;
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
import java.util.HashMap;
import java.util.List;


@RestController

public class CoursController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @Autowired
    @Qualifier(value = "usermanager")
    private UserManager usermanager;

    @Autowired
    @Qualifier(value = "userchapitremanager")
    private UserChapitreManager userChapitreManager;

    @Autowired
    @Qualifier(value = "profilemanager")
    private ProfileManager profileManager;

    @RequestMapping(value = "/addcours", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetAddCours(HttpSession session) {
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        ModelAndView modelAndView = new ModelAndView("ajout_cours");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/cours", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGet(@RequestParam(value="title", required = false) String title,
                                   @RequestParam(value="idCours", required = false) String idCours,
                                   HttpSession session) {
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        if(user == null)
            return new ModelAndView("redirect:/index");
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
                List<Double> stats = new ArrayList<>();
                List<Integer> coursIds = new ArrayList<>();
                for (Cours c:allCours) {
                    List<Profile> allExoDone = profileManager.getAllUserchapitreByUserAndCours(user,c);
                    List<Userchapitre> allChapitreDone = userChapitreManager.getAllUserchapitreByUserAndCours(user,c);
                    if(c.getNbChapitre() !=0 && c.getNbExercices() != 0)
                        stats.add((allExoDone.size()+allChapitreDone.size())/Double.valueOf(c.getNbExercices()+c.getNbChapitre()));
                    else
                        stats.add(0.0);
                    coursIds.add(c.getIdCours());
                }
                modelAndView.addObject("cours", allCours);
                modelAndView.addObject("user", user);
                modelAndView.addObject("stats", stats);
                modelAndView.addObject("coursids", coursIds);
                return modelAndView;
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ModelAndView("index", "", "Une erreur est survenue lors de la récupération du cours.");
    }

    @RequestMapping(value = "/cours", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="image", required = true) String image,
                                    @RequestParam(value="description", required = true) String description,
                                    @RequestParam(value="nbExercices", required = true, defaultValue = "0") int nbExercices,
                                    HttpSession session) {
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.newCours(title, image, description, nbExercices);
        if(cours != null) {
            ModelAndView modelAndView = new ModelAndView("redirect:/cours");
            modelAndView.addObject("user", user);
            new File("src/main/webapp/html_files/"+cours.getIdCours()).mkdir();
            new File("src/main/webapp/html_files/"+cours.getIdCours()+"/cours").mkdir();
            new File("src/main/webapp/html_files/"+cours.getIdCours()+"/exercices").mkdir();
            return modelAndView;
        }
        return new ModelAndView("redirect:/addcours");
    }
}
