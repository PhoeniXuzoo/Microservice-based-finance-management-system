package cn.phoenixuzoo.incomeservice.DAO;

import cn.phoenixuzoo.incomeservice.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {

}
