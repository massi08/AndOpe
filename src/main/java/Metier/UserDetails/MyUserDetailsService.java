package Metier.UserDetails;

import DAO.UserDao;
import Model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {


    private UserDao userdao;

    public MyUserDetailsService(UserDao userdao) {
        this.userdao = userdao;
    }

    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        //com.mkyong.users.model.User user = userDao.findByUserName(username);
        User user = userdao.getUserByPseudo(username);
        //MyUserDetails userdetails = new MyUserDetails(user.getPseudo(), user.getPassword(), user.getAuthorities());
        //userdetails.setUser(user);
        //System.out.println(user.getPseudo());
        /*List<GrantedAuthority> authorities =
                buildUserAuthority(user.getAccess());*/
        //UserDetails user2=new UserDetails();
        return null;
    }
}
