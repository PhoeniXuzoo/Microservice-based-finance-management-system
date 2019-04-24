package cn.phoenixuzoo.accountservice.service;

import cn.phoenixuzoo.accountservice.doamin.Account;

public interface AccountService {
    Account loadAccountByUsername(String username);
    String setPersonalInfo(Account update);
}
