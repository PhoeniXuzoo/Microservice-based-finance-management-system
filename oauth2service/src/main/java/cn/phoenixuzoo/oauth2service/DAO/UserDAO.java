package cn.phoenixuzoo.oauth2service.DAO;

import cn.phoenixuzoo.oauth2service.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, String> {

}
