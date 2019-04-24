package cn.phoenixuzoo.realassetsservice.controller;

import cn.phoenixuzoo.realassetsservice.domain.Item;
import cn.phoenixuzoo.realassetsservice.service.RealAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class RealAssetsController {

    @Autowired
    RealAssetsService realAssetsService;

    @RequestMapping(value = "/addRealAssetsItem/{username}", method = RequestMethod.POST)
    public Map<String, List<Item>> addRealAssetsItem(@PathVariable String username, @Valid @RequestBody Item item) {
        return realAssetsService.addRealAssetsItem(username, item);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Map<String, List<Item>> loadRealAssetsItem(@PathVariable String username) {
        return realAssetsService.loadRealAssets(username);
    }

    @RequestMapping(value = "/editRealAssetsItem/{username}/{index}", method = RequestMethod.POST)
    public Map<String, List<Item>> editRealAssetsItem(@PathVariable String username, @PathVariable String index, @Valid @RequestBody Item item) {
        return realAssetsService.editRealAssetsItem(username, item, Integer.parseInt(index));
    }

    @RequestMapping(value = "/deleteRealAssetsItem/{username}/{realAssetsItemName}/{realAssetsItemTimePoint}", method = RequestMethod.POST)
    public Map<String, List<Item>> deleteRealAssetsItem(@PathVariable String username, @PathVariable String realAssetsItemName, @PathVariable String realAssetsItemTimePoint) {
        return realAssetsService.deleteRealAssetsItem(username, realAssetsItemName, realAssetsItemTimePoint);
    }
}
