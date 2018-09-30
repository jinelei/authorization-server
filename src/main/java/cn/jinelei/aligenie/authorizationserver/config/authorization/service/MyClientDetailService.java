package cn.jinelei.aligenie.authorizationserver.config.authorization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class MyClientDetailService implements ClientDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyClientDetailService.class);
    @Autowired
    private DataSource dataSource;
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        JdbcClientDetailsService jdbcClientDetailsService= new JdbcClientDetailsService(dataSource);
        ClientDetails clientDetails = jdbcClientDetailsService.loadClientByClientId(s);
        return clientDetails;
    }
}
