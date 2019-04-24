package cn.phoenixuzoo.financeproductservice.client;

import cn.phoenixuzoo.financeproductservice.domain.IncomeItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "incomeservice")
public interface IncomeClient {
    @RequestMapping(value = "/addIncomeItem/{username}", method = RequestMethod.POST)
    void addFinanceProductIntoIncomeManagement(@PathVariable("username") String username, @RequestBody IncomeItem incomeItem);

    @RequestMapping(value = "/deleteIncomeItemFromFinanceManagement/{username}/{itemName}/{timePoint}", method = RequestMethod.POST)
    boolean deleteFinanceProductFromIncomeManagement(@PathVariable("username") String username, @PathVariable("itemName") String itemName, @PathVariable("timePoint") String timePoint );

    @RequestMapping(value = "/editIncomeItem/{username}", method = RequestMethod.POST)
    boolean editFinanceProductFromIncomeManagement(@PathVariable("username") String username, @RequestBody IncomeItem incomeItem);

}
