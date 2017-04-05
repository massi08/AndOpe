package controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.persistence.EntityManager;
//import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/login")
public class LoginController {
    //private EntityManager em = CreateEntity.em;
    //private UserManager userManager = new UserManager(em);

    /**
     * ATTENTION : Cette méthode n'est pas censée être appelée, mais existe pour empêcher le serveur de planter en cas
     * d'appel inattendu (ou forcé par une attaque du système) à cette méthode.
     *
     * @param reponse   Réponse du serveur.
     * @return  ObjetReponse contenant un retour d'erreur.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView receiveGet(HttpServletResponse reponse) {
        reponse.setStatus(405);
        return new ModelAndView("error", "", "la demande n'est pas prise en compte (GET sur login).");
    }

    /**
     * Gère la connexion utilisateur en vérifiant son existence et la correspondance de son mot de passe.
     *
     * @param pseudo    Pseudo de l'utilisateur renvoyé par le formulaire.
     * @param password  Mot de passe de l'utilisateur renvoyé par le formulaire.
     * @param session   Session HTML de l'utilisateur.
     * @return  ObjetReponse indiquant la réussite ou l'échec de l'authentification.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView receivePost(@RequestParam(value="pseudo", required = true) String pseudo,
                                    @RequestParam(value="password", required = true) String password,
                                    HttpSession session) {

        /*Security security = new Security();
        User user = userManager.checkUser(pseudo, security.createPwd(password));

        if(user != null) {
            session.setAttribute("userName", user.getUserName());
            return new ObjetReponse();
        }

        return new ObjetReponse("error", "", "Pseudo ou mot de passe incorrect.");*/
        return new ModelAndView();
    }
}