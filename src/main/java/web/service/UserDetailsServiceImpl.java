package web.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

     User user = userDao.getUserByLogin(s);
            if(user == null){
                throw new UsernameNotFoundException("can't found this user");
            }
            return user;

    }
}
