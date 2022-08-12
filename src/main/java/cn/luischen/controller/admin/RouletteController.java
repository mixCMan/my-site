package cn.luischen.controller.admin;

import cn.luischen.controller.BaseController;
import cn.luischen.service.roulette.RouletteService;
import cn.luischen.service.user.UserService;
import cn.luischen.utils.APIResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by chenyuanmeng on 2022/8/4.
 */
@Api("轮盘类")
@Controller
@RequestMapping(value = "/roulette")
public class RouletteController extends BaseController {

    @Autowired
    private RouletteService rouletteService;
    @GetMapping("/index")
    public String index(HttpServletRequest request){

        return  "site/roulette";
    }
    @PostMapping("/bigHappy")
    @ResponseBody
    public APIResponse bigHappy(HttpServletRequest request){
        List<Integer> numberList = rouletteService.bigHappy();
//        request.setAttribute("numberList",numberList);

        return APIResponse.success(numberList);
    }
    @PostMapping("/doubleColor")
    @ResponseBody
    public APIResponse doubleColor(HttpServletRequest request){
        List<Integer> numberList = rouletteService.doubleColor();

        return APIResponse.success(numberList);
    }


}