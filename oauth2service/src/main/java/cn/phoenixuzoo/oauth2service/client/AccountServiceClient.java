package cn.phoenixuzoo.oauth2service.client;

import cn.phoenixuzoo.oauth2service.domain.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "accountservice")
public interface AccountServiceClient {
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    Account getAccountsByUsername(@PathVariable("username") String username);
}
