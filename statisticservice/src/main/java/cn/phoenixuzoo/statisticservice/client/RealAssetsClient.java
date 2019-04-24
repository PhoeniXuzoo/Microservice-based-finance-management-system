package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.RealAssetsItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "realassetsservice", fallback = realAssetsClientFallback.class)
public interface RealAssetsClient {
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    Map<String, List<RealAssetsItem>> loadRealAssetsItem(@PathVariable("username") String username);
}
