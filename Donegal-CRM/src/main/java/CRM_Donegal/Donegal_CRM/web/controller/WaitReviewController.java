package CRM_Donegal.Donegal_CRM.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *Pending Auditing 
 */
@Controller
@RequestMapping("waitReview")
public class WaitReviewController {

    @RequestMapping("view")
    public String view(){
        return "/waitReview/view";
    }

}
