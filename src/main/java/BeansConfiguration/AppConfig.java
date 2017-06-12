package BeansConfiguration;

import DAO.*;
import Metier.*;
import Metier.UserDetails.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration

public class AppConfig {

    @Autowired
    ApplicationContext ctx;

    @Bean
    @Scope("singleton")
    public EntityManagerFactory EntityManagerfactory(){ return Persistence.createEntityManagerFactory("andope") ;}

    @Bean
    @Qualifier(value = "coursmanager")
    @Scope("singleton")
    public CoursManager coursManager() {
        return new CoursManager(entitymanager(), coursDao());
    }

    @Bean
    @Qualifier(value = "exercicemanager")
    @Scope("singleton")
    public ExerciceManager exerciceManager() {
        return new ExerciceManager (entitymanager(), exerciceDao());
    }

    @Bean(name = "usermanager")
    @Qualifier(value = "usermanager")
    @Scope("singleton")
    public UserManager userManager() {
        return new UserManager(entitymanager(), userDAO());
    }

    @Bean
    @Qualifier(value = "inscriptionmanager")
    @Scope("singleton")
    public InscriptionManager inscriptionManager() {
        return new InscriptionManager(entitymanager(), coursDao(), userDAO(), inscritDao());
    }

    @Bean
    @Qualifier(value = "chapitremanager")
    @Scope("singleton")
    public ChapitreManager chapitreManager(){
        return new ChapitreManager(entitymanager(), coursDao(), chapitreDao());
    }

    @Bean
    @Qualifier(value = "userchapitremanager")
    @Scope("singleton")
    public UserChapitreManager userChapitreManager(){
        return new UserChapitreManager(entitymanager(), userChapitreDao(), userDAO(), chapitreDao());
    }

    @Bean
    @Qualifier(value = "profilemanager")
    @Scope("singleton")
    public ProfileManager profileManager(){
        return new ProfileManager(entitymanager(), profileDao(), userDAO(), exerciceDao());
    }


    @Bean
    @Qualifier(value = "entityManager")
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public EntityManager entitymanager() {
        return EntityManagerfactory().createEntityManager();
    }

    @Bean(name = "MyUserDetailsService")

    @Scope("singleton")
    public MyUserDetailsService MyUserDetailsService() {
        return new MyUserDetailsService(userDAO());
    }

    @Bean(name = "dataSource")
    @Scope("singleton")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/andope");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler
    savedRequestAwareAuthenticationSuccessHandler() {

        SavedRequestAwareAuthenticationSuccessHandler auth
                = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setDefaultTargetUrl("/Home");
        return auth;
    }

    @Bean
    @Scope("singleton")
    public ProfileDao profileDao() {
        return new ProfileDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public InscritDao inscritDao() {
        return new InscritDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public ExerciceDao exerciceDao() {
        return new ExerciceDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public CoursDao coursDao() {
        return new CoursDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public ChapitreDao chapitreDao() {
        return new ChapitreDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public UserDao userDAO() {
        return new UserDao(entitymanager());
    }

    @Bean
    @Scope("singleton")
    public UserChapitreDao userChapitreDao() {
        return new UserChapitreDao(entitymanager());
    }

}