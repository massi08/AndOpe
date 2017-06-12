package Controllers;

import Metier.*;
import Model.Chapitre;
import Model.Cours;
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

    @Autowired
    @Qualifier(value = "inscriptionmanager")
    private InscriptionManager inscriptionManager;

    @Autowired
    @Qualifier(value = "userchapitremanager")
    private UserChapitreManager userChapitreManager;

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

    @RequestMapping(value = "/chapitre/contenu/{idCours}/{idChapitre}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetAddExerciceDrag(@PathVariable String idCours,
                                                  @PathVariable String idChapitre,
                                                  HttpSession session) {
        int idC = Integer.valueOf(idCours);
        int idCh = Integer.valueOf(idChapitre);
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        Chapitre chapitre = chapitreManager.getChapitre(idCh);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.addObject("chapitre", chapitre);
        modelAndView.setViewName("cours");
        return modelAndView;
    }

    @GetMapping("/chapitre/cours/{idCours}")
    @ResponseBody
    public ModelAndView receiveGetChapitre(@PathVariable String idCours,
                                           HttpSession session){
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView("chapitre");
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        inscriptionManager.newInscription(user,cours);
        List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
        List<Userchapitre> userchapitres = userChapitreManager.getAllUserchapitreByUserAndCours(user, cours);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.addObject("chapitres",allChapitre);
        modelAndView.addObject("userchapitres", userchapitres);
        return modelAndView;
    }

    @PostMapping("/chapitre/done/{idChapitre}")
    @ResponseBody
    public ObjetReponse postChapitreDone(@PathVariable String idChapitre,
                                         HttpSession session){
        int idC = Integer.valueOf(idChapitre);
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Chapitre chapitre = chapitreManager.getChapitre(idC);
        if(user == null){
            return new ObjetReponse("error","","User not connected");
        }
        if(userChapitreManager.getUserChapitreByUserAndChapitre(user,chapitre) != null){
            return new ObjetReponse("error","","already exist user chapitre");
        }
        Userchapitre userchapitre = userChapitreManager.newUserChapitre(user,chapitre);
        if(userchapitre == null){
            return new ObjetReponse("error","","couldn't persist user chapitre");
        }
        return new ObjetReponse("success","","");
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
            int nbChapitre = cours.getNbChapitre();
            cours = coursManager.updateCoursChapitreNumber(cours,nbChapitre + 1);
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
