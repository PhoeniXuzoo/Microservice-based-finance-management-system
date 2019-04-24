package cn.phoenixuzoo.expenseservice.DAO;

import cn.phoenixuzoo.expenseservice.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {

}
