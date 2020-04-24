package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.service.IInsureService;
import CRM_Donegal.Donegal_CRM.service.IReviewService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Object: Pending Order Window
 * Author: Thunder Lei
 */
@Controller
@RequestMapping("review")
public class ReviewController {
    @Autowired
    IReviewService reviewService;
    @Autowired
    IInsureService insureService;

    @RequestMapping("view")
    @RequiresPermissions({"review:view", "The single page of Pending Order Window"})
    public String view() {
        return "review/review";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(ReviewQueryObject qo) {
        return reviewService.selectByInsuranceAutit(qo);
    }

    /**
     *
     * @return
     */
    @RequestMapping("billedit")
    public String billedit() {
        return "billedit/billedit";
    }

    /**
     * Find out all customers who have paid
     *
     * @param qo
     * @return
     */
    @RequestMapping("billeditstate")
    @ResponseBody
    public PageResult billeditstate(ReviewQueryObject qo) {

        return insureService.selectPayInfoState(qo);
    }

    /**
     * Security modification
     * @param id
     * @return
     */
    @RequestMapping("updateBillStatus")
    @ResponseBody
    public JSONResult updateBillStatus(Insurance insurance) {

        JSONResult json = new JSONResult();
        try {
            insureService.updateBillStatus(insurance);
        } catch (Exception e) {
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    };

    /*
        Policy rollback
        Change the status of the policy
     */
    @RequestMapping("rollback")
    @ResponseBody
    public Object rollback(Long id) {
        try {
            reviewService.rollback(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark("Rollback failed");
        }
        return new JSONResult();
    }

    /*
      Policy Pass
      Change the status of the policy
   */
    @RequestMapping("pass")
    @ResponseBody
    public Object pass(Long id) {
        try {
            reviewService.pass(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark("Fail to Pass!");
        }
        return new JSONResult();
    }

    /*
  Save Document
     */
    @RequestMapping("updateByMessager")
    @ResponseBody
    public Object updateByMessager(Insurance insurance) {
        try {
            reviewService.updateByMessager(insurance);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark("Fail to Save!");
        }
        return new JSONResult();
    }

}
