package CRM_Donegal.Donegal_CRM.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("login.do")
    public String login(){
        System.out.println(1234);
        return "redirect:/login.jsp";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
