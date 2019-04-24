package cn.phoenixuzoo.statisticservice.service;

import cn.phoenixuzoo.statisticservice.domain.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatisticService {
    boolean generateExcelFile(String username, Date date, List<IncomeItem> incomeItems, List<ExpenseItem> expenseItems, Map<String, List<RealAssetsItem>> realAssetsItems);
}
