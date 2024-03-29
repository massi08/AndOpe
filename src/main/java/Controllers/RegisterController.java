package Controllers;

import Metier.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier(value = "usermanager")
    private UserManager userManager;

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
        return new ModelAndView("inscription");
    }

    /**
     * Gère l'enregistrement de l'utilisateur en vérifiant son existence et la validité de son mot de passe.
     *
     * @param pseudo    Pseudo de l'utilisateur renvoyé par le formulaire.
     * @param password  Mot de passe de l'utilisateur renvoyé par le formulaire.
     * @return  ObjetReponse indiquant la réussite ou l'échec de l'enregistrement.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView receivePost(@RequestParam(value="pseudo", required = true) String pseudo,
                                    @RequestParam(value="password", required = true) String password,
                                    @RequestParam(value="confirm_password", required = true) String confirm_password,
                                    @RequestParam(value = "firstname", required = false, defaultValue = "") String firstname,
                                    @RequestParam(value = "lastname", required = false, defaultValue = "") String lastname,
                                    @RequestParam(value = "email", required = false, defaultValue = "") String email) {
        if(pseudo.length() <= 45 && password.length() <= 45 && confirm_password.length() <= 45) {
            if(!password.equals(confirm_password)){
                return new ModelAndView("redirect:/inscription");
            }
            if(userManager.newUser(pseudo, password, firstname, lastname, email) != null) {
                return new ModelAndView("redirect:/index");
            } else {
                return new ModelAndView("redirect:/inscription");
            }
        } else {
            return new ModelAndView("redirect:/inscription");
        }
    }
}
