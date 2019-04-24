package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.FinanceProductItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "financeproductservice", fallback = financeProductClientFallback.class)
public interface FinanceProductClient {
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    Map<String, List<FinanceProductItem>> loadFinanceProductItem(@PathVariable("username") String username);
}
