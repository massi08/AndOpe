package Controllers;

import Metier.ChapitreManager;
import Metier.CoursManager;
import Metier.ExerciceManager;
import Metier.UserManager;
import Model.Chapitre;
import Model.Cours;
import Model.Exercice;
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
import java.util.HashMap;
import java.util.List;

@RestController
public class ExerciceController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "coursmanager")
    private CoursManager coursManager;

    @Autowired
    @Qualifier(value = "usermanager")
    private UserManager usermanager;

    @Autowired
    @Qualifier(value = "chapitremanager")
    private ChapitreManager chapitreManager;

    @Autowired
    @Qualifier(value = "exercicemanager")
    private ExerciceManager exerciceManager;

    @RequestMapping(value = "/exercice", method = RequestMethod.GET)
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
                List<Exercice> allExercices = exerciceManager.getAllExercicesByChapitreId(idC);
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

    @RequestMapping(value = "/exercice/cours/{idCours}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetByCours(@PathVariable String idCours,
                                          HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        modelAndView.addObject("user", user);
        modelAndView.setViewName("exercices");

        if(idCours != null && !idCours.equals("")){
            int idC = Integer.valueOf(idCours);
            Cours cours = coursManager.getCours(idC);
            List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
            List<Exercice> allExercices = new ArrayList<>();
            for (Chapitre chapitre:allChapitre) {
                allExercices.addAll(exerciceManager.getAllExercicesByChapitreId(chapitre.getIdC()));
            }
            modelAndView.addObject("exercices", allExercices);
            modelAndView.addObject("cours", cours);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/addexercice/cours/{idCours}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetAddExercice(@PathVariable String idCours,
                                              HttpSession session) {
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.setViewName("ajout_exo");
        return modelAndView;
    }

    @RequestMapping(value = "/addexercice/cours/{idCours}/qcm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetAddExerciceQcm(@PathVariable String idCours,
                                                 HttpSession session) {
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.addObject("chapitres", allChapitre);
        modelAndView.setViewName("ajout_qcm");
        return modelAndView;
    }

    @RequestMapping(value = "/addexercice/cours/{idCours}/drag", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGetAddExerciceDrag(@PathVariable String idCours,
                                                  HttpSession session) {
        int idC = Integer.valueOf(idCours);
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        Cours cours = coursManager.getCours(idC);
        List<Chapitre> allChapitre = chapitreManager.getAllChapitreByCoursId(idC);
        modelAndView.addObject("user", user);
        modelAndView.addObject("cours", cours);
        modelAndView.addObject("chapitres", allChapitre);
        modelAndView.setViewName("ajout_drag");
        return modelAndView;
    }

    @RequestMapping(value = "/exercice/qcm/messages", method = RequestMethod.GET)
    @ResponseBody
    public ObjetReponse receiveGetMessagesQcm(HttpSession session) {
        ObjetReponse objetReponse = new ObjetReponse();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        HashMap<Integer,String> messages = new HashMap<>();
        messages.put(0,"beforeCreate() est appelée avant la création d'une vue");
        messages.put(1,"created() est appelée dès que la vue est créé avant d'entamer le processus de montage");
        messages.put(2,"beforeMount() est appelée avant le montage d'une vue");
        messages.put(3,"mounted() est appelée une fois que la vue est montée");
        messages.put(4,"beforeUpdate() est appelée quand un changement va arriver");
        messages.put(5,"updated() est appelée après le changemente");
        messages.put(6,"beforeDestroy() est appelée avant la destrution d'une vue");
        messages.put(7,"destroyed() est appelée après la destruction d'une vue");
        ObjectMapper mapper = new ObjectMapper();
        Gson gson = new Gson();
        //try {
            return new ObjetReponse("success","",gson.toJson(messages));
        /*} catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ObjetReponse("error","","couldn't fetch");
    */}

    @RequestMapping(value = "/exercice", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView receivePost(@RequestParam(value="title", required = true) String title,
                                    @RequestParam(value="path", required = true) String path,
                                    @RequestParam(value="idChapitre", required = true) String idChapitre,
                                    HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        User user = usermanager.getUser((String) session.getAttribute("pseudo"));
        modelAndView.addObject("user", user);
        int chapitreId = Integer.valueOf(idChapitre);
        Chapitre chapitre = chapitreManager.getChapitre(chapitreId);
        if (chapitre == null){
            modelAndView.setViewName("exercice");
            return modelAndView;
        }
        Exercice exercice = exerciceManager.newExercice(title,path,chapitre);
        if(exercice != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                File file = new File("src/main/webapp/html_files/"+chapitre.getCoursByIdCours().getIdCours()+"/exercices/"+exercice.getPath());
                FileWriter writer = new FileWriter(file);
                writer.write("Okay ");
                writer.flush();
                writer.close();
                modelAndView.setViewName("exercice");
                return modelAndView;
            }
            catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        modelAndView.setViewName("exercice");
        return modelAndView;
    }
}
