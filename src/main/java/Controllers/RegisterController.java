package Controllers;

import Metier.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

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
    public ObjetReponse receiveGet(HttpServletResponse reponse) {
        reponse.setStatus(405);
        return new ObjetReponse("error", "", "la demande n'a pas été prise en compte (GET sur register)");
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
    public ObjetReponse receivePost(@RequestParam(value="pseudo", required = true) String pseudo,
                                    @RequestParam(value="password", required = true) String password,
                                    @RequestParam(value = "firstname", required = false, defaultValue = "") String firstname,
                                    @RequestParam(value = "lastname", required = false, defaultValue = "") String lastname,
                                    @RequestParam(value = "email", required = false, defaultValue = "") String email) {
        if(pseudo.length() <= 45 && password.length() <= 45) {
            Security security = new Security();
            if(userManager.newUser(pseudo, password, firstname, lastname, email) != null) {
                return new ObjetReponse("success", "", "Votre a été bien crée.");
            } else {
                return new ObjetReponse("error", "", "erreur à la création compte.");
            }
        } else {
            return new ObjetReponse("error", "", "Pseudo ou mot de passe trop long.");
        }
    }
}
