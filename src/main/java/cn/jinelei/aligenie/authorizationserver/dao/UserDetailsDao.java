package cn.jinelei.aligenie.authorizationserver.dao;

import cn.jinelei.aligenie.authorizationserver.po.UserDetailsPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends CrudRepository<UserDetailsPO,Integer> {

    UserDetailsPO findUserDetailsPOByUsername(String username);

}
