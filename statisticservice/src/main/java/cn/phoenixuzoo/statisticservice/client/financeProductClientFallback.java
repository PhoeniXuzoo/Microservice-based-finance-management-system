package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.FinanceProductItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class financeProductClientFallback implements FinanceProductClient{
    @Override
    public Map<String, List<FinanceProductItem>> loadFinanceProductItem(String username) {
        return null;
    }
}
