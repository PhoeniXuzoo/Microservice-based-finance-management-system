package cn.phoenixuzoo.statisticservice.controller;

import cn.phoenixuzoo.statisticservice.domain.*;
import cn.phoenixuzoo.statisticservice.client.*;
import cn.phoenixuzoo.statisticservice.service.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @Autowired
    IncomeClient incomeClient;

    @Autowired
    ExpenseClient expenseClient;

    @Autowired
    FinanceProductClient financeProductClient;

    @Autowired
    RealAssetsClient realAssetsClient;

    @RequestMapping(value = "/DownloadFile/{username}", method = RequestMethod.GET)
    public void downloadFile(@PathVariable String username, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<IncomeItem> incomeItems = incomeClient.loadIncomeItem(username);
        List<ExpenseItem> expenseItems = expenseClient.loadExpenseItem(username);
        Map<String, List<RealAssetsItem>> realAssetsItems = realAssetsClient.loadRealAssetsItem(username);
        statisticService.generateExcelFile(username, new Date(), incomeItems, expenseItems, realAssetsItems);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + username + ".xls");//默认Excel名称
        response.flushBuffer();
        String filePath = ".\\StatisticFile\\" + username + ".xls";
        File excel = new File(filePath);
        FileInputStream fis = new FileInputStream(excel);
        Workbook wb = new HSSFWorkbook(fis);
        wb.write(response.getOutputStream());
    }

    @RequestMapping(value = "/IncomeStatistics/{username}", method = RequestMethod.GET)
    public List<IncomeItem> loadIncomeStatistics(@PathVariable String username) {
        return incomeClient.loadIncomeItem(username);
    }

    @RequestMapping(value = "/ExpenseStatistics/{username}", method = RequestMethod.GET)
    public List<ExpenseItem> loadExpenseStatistics(@PathVariable String username) {
        return expenseClient.loadExpenseItem(username);
    }

    @RequestMapping(value = "/RealAssetsStatistics/{username}", method = RequestMethod.GET)
    public Map<String, List<RealAssetsItem>> loadRealAssetsItem(@PathVariable String username) {
        return realAssetsClient.loadRealAssetsItem(username);
    }
}
