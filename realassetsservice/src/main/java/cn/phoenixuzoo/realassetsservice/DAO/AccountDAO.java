package cn.phoenixuzoo.realassetsservice.DAO;

import cn.phoenixuzoo.realassetsservice.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {

}
