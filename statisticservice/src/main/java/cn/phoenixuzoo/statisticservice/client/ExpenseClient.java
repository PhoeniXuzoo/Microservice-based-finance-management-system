package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.ExpenseItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "expenseservice", fallback = expenseClientFallback.class)
public interface ExpenseClient {
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    List<ExpenseItem> loadExpenseItem(@PathVariable("username") String username);
}
