package cn.jinelei.aligenie.authorizationserver.config.security.dao;

import cn.jinelei.aligenie.authorizationserver.config.security.po.UserDetailsPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * OAuth用户Dao
 */
@Repository
public interface UserDetailsDao extends CrudRepository<UserDetailsPO,Integer> {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    UserDetailsPO findUserDetailsPOByUsername(String username);

}
