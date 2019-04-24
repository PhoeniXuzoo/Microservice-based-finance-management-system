package cn.phoenixuzoo.statisticservice.client;

import cn.phoenixuzoo.statisticservice.domain.ExpenseItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class expenseClientFallback implements ExpenseClient{
    @Override
    public List<ExpenseItem> loadExpenseItem(String username) {
        return null;
    }
}
