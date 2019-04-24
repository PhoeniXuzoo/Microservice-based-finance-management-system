package cn.phoenixuzoo.financeproductservice.DAO;

import cn.phoenixuzoo.financeproductservice.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends CrudRepository<Account, String> {

}
