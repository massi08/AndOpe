package Controllers;

import Metier.UserManager;
import Model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "usermanager")
    private UserManager usermanager;


    /**
     * ATTENTION : Cette méthode n'est pas censée être appelée, mais existe pour empêcher le serveur de planter en cas
     * d'appel inattendu (ou forcé par une attaque du système) à cette méthode.
     *
     * @param reponse   Réponse du serveur.
     * @return  ObjetReponse contenant un retour d'erreur.
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView receiveGet(HttpServletResponse reponse) {
        return new ModelAndView("index");
    }

    /**
     * Gère la connexion utilisateur en vérifiant son existence et la correspondance de son mot de passe.
     *
     * @param pseudo    Pseudo de l'utilisateur renvoyé par le formulaire.
     * @param password  Mot de passe de l'utilisateur renvoyé par le formulaire.
     * @param session   Session HTML de l'utilisateur.
     * @return  ObjetReponse indiquant la réussite ou l'échec de l'authentification.
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    @SessionScope
    public ModelAndView receivePost(@RequestParam(value="pseudo", required = true) String pseudo,
                                    @RequestParam(value="password", required = true) String password,
                                    HttpSession session) {


        User user = usermanager.checkUser(pseudo, password);

        if(user != null) {
            ObjectMapper mapper = new ObjectMapper();
            session.setAttribute("pseudo", user.getPseudo());
            return new ModelAndView("redirect:/cours");
        }


        return new ModelAndView("index", "", "Pseudo ou mot de passe incorrect.");
    }
}