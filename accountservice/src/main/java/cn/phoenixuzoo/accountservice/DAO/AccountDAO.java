package cn.phoenixuzoo.accountservice.DAO;

import cn.phoenixuzoo.accountservice.doamin.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {

}
