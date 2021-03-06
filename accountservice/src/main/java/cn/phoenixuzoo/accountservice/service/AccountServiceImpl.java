package cn.phoenixuzoo.accountservice.service;

import cn.phoenixuzoo.accountservice.DAO.AccountDAO;
import cn.phoenixuzoo.accountservice.doamin.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account loadAccountByUsername(String username) {
        Account account = accountDAO.findOne(username);

        if (account == null) {
            ;//todo: create and save
            account = new Account();
            account.setUsername(username);
            account.setName("未设置");
            account.setSex("未设置");
            account.setAge("未设置");
            account.setSavingAmount(new BigDecimal(0));
            account.setUpdateTime(new Date());
            accountDAO.save(account);
        }
        else {
            account.setUpdateTime(new Date());
            accountDAO.save(account);
        }

        return account;
    }

    @Override
    public String setPersonalInfo(Account update) {
        Account account = accountDAO.findOne(update.getUsername());

        if (account != null) {
            account.setUpdateTime(update.getUpdateTime());
            account.setName(update.getName());
            account.setAge(update.getAge());
            account.setSex(update.getSex());
            account.setSavingAmount(update.getSavingAmount());
            accountDAO.save(account);
        }
        else return "fail";

        return "success";
    }

}
