package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.IncomeItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class incomeClientFallback implements IncomeClient{
    @Override
    public List<IncomeItem> loadIncomeItem(String username) {
        return null;
    }
}
