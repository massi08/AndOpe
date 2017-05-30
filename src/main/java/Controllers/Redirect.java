package Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Team Sharkode on 18/11/16.
 */
@RestController
public class Redirect {

    /**
     * Renvoie la liste des commits d'une branche, ou du projet si le nom de la branche est vide.
     *
     * @param servletRequest    Requête envoyée au serveur.
     * @param servletResponse   Réponse de la redirection.
     * @return  ObjetReponse contenant une redirection, ou un message d'erreur.
     */
    @RequestMapping("/redirect")
    public ModelAndView redirect(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getRequestURI();

        ((HttpServletResponse)servletResponse).setStatus(401);
        if(uri.contains("/api/")) {
            return new ModelAndView("redirect", "", "La session a expiré.");
        }
        else {
            try {
                servletRequest.getRequestDispatcher("").forward(servletRequest, servletResponse);
            }
            catch(Exception e) {
                System.err.println(e);
            }

        }
        return new ModelAndView("error", "", "redirection non gérée.");
    }
}
