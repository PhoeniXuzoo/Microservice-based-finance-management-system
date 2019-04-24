package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.IncomeItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "incomeservice", fallback = incomeClientFallback.class)
public interface IncomeClient {
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    List<IncomeItem> loadIncomeItem(@PathVariable("username") String username);
}
