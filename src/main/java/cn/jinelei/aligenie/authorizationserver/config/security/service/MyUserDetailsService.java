package cn.jinelei.aligenie.authorizationserver.config.security.service;

import cn.jinelei.aligenie.authorizationserver.config.security.dao.UserDetailsDao;
import cn.jinelei.aligenie.authorizationserver.config.security.po.UserDetailsPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) {
        UserDetailsPO userDetailsPO = userDetailsDao.findUserDetailsPOByUsername(s);
        UserDetails userDetails = generateUser(userDetailsPO);
        if (userDetails == null)
            return null;
        return userDetails;
    }

    private UserDetails generateUser(UserDetailsPO userDetailsPO) {
        if (userDetailsPO == null
                || userDetailsPO.getUsername().equals("")
                || userDetailsPO.getPassword().equals("")
                || userDetailsPO.getAuthorities().equals(""))
            return null;
        Collection<GrantedAuthority> authorities = new HashSet<>();
        for (String auth : userDetailsPO.getAuthorities().split(",")) {
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        UserDetails user = new User(userDetailsPO.getUsername(), userDetailsPO.getPassword(), userDetailsPO.isEnabled(), userDetailsPO.isAccountNonExpired(), userDetailsPO.isCredentialsNonExpired(), userDetailsPO.isAccountNonLocked(), authorities);
        LOGGER.debug("user: {}", user);
        return user;
    }

}
