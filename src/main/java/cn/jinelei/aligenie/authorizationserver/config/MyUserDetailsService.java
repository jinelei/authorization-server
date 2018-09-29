package cn.jinelei.aligenie.authorizationserver.config;

import cn.jinelei.aligenie.authorizationserver.dao.UserDetailsDao;
import cn.jinelei.aligenie.authorizationserver.po.UserDetailsPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashSet;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOGGER.debug("name: {}", s);
        UserDetailsPO userDetailsPO = userDetailsDao.findUserDetailsPOByUsername(s);
        LOGGER.debug("userDetailPO: {}", userDetailsPO);
        if (userDetailsPO == null
                || userDetailsPO.getUsername().equals("")
                || userDetailsPO.getPassword().equals("")
                || userDetailsPO.getAuthorities().equals(""))
            return null;
        return generateUser(userDetailsPO);
    }

    private User generateUser(UserDetailsPO userDetailsPO) {
        if (userDetailsPO == null
                || userDetailsPO.getUsername().equals("")
                || userDetailsPO.getPassword().equals("")
                || userDetailsPO.getAuthorities().equals(""))
            return null;
        Collection<GrantedAuthority> authorities = new HashSet<>();
        for (String auth : userDetailsPO.getAuthorities().split(",")) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        User user = new User(userDetailsPO.getUsername(), userDetailsPO.getPassword(), userDetailsPO.isEnabled(), userDetailsPO.isAccountNonExpired(), userDetailsPO.isCredentialsNonExpired(), userDetailsPO.isAccountNonLocked(), authorities);
        LOGGER.debug("user: {}", user);
        return user;
    }

}
