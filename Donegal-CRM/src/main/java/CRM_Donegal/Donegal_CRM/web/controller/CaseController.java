package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.domain.Case;
import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.CaseQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICaseService;
import CRM_Donegal.Donegal_CRM.service.IInsureService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: Thunder Lei
 * Function: Claims
 */

@Controller
@RequestMapping("case")
public class CaseController {
    @Autowired
    ICaseService caseService;
    @Autowired
    IInsureService iInsureService;

    @RequestMapping("view")
    public String view(){
        return "case/case";
    }

    /**
     * Author: Thunder Lei
     * Function: Audit report form page display
     * @param qo
     * @return
     */
    @RequestMapping("audit")
    public String viewAudit(){
        return "case/caseAudit2";
    }

    /**
     * Function: page display of report form query
     * @param qo
     * @return
     */
    @RequestMapping("listAll")
    public String listAll(){
        return "case/caseList";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(CaseQueryObject qo){
        return caseService.query(qo);
    }

    /**
     * Author: Thunder Lei
     * Function: Advanced query to review the report form
     * @param qo
     * @return
     */
    @RequestMapping("queryForAudit")
    @ResponseBody
    public Object queryForAudit(CaseQueryObject qo){
        return caseService.queryForAudit(qo);
    }

    /**
     * Author: Thunder Lei
     * 
		Function: Advanced query for report form query
     * @param qo
     * @return
     */
    @RequestMapping("queryForCaseList")
    @ResponseBody
    public Object queryForCaseList(CaseQueryObject qo){
        return caseService.queryForCaseList(qo);
    }


  

    @RequestMapping("validInsuranceId")
    @ResponseBody
    public Object validInsuranceId(Long insuranceId){
      //if id is the same as the incoming id, it is confirmed as an edit operation
        Insurance insurance = iInsureService.get(insuranceId);
        //true stands for available 
       return insurance != null;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return caseService.selectAll();
    }

    /**
     * Function: Click the button to set the report form to an invalid state
     */
    @RequestMapping("makeInvalidById")
    @ResponseBody
    public Object makeInvalidById(Long id){
        caseService.makeInvalidById(id);
        return new JSONResult();
    }

    /**
    
* 	Interface: audit report form
     * Function: Click the button to set the report form as approved and paid
     */
    @RequestMapping("makePassById")
    @ResponseBody
    public Object makePassById(Long id){
        caseService.makePassById(id);
        return new JSONResult();
    }

    /**
    
* Interface: audit report form
     * Function: Click the button to set the report form to a deductible state
     */
    @RequestMapping("makeNopayById")
    @ResponseBody
    public Object makeNopayById(Long id){
        caseService.makeNopayById(id);
        return new JSONResult();
    }

    /**
    * Function: survey and determine damage, update the report form;
     * @param caseBill Encapsulate the three update parameters passed from the front desk, and id
     * @return
     */
    @RequestMapping("checkUpdate")
    @ResponseBody
    public Object checkUpdate(Case caseBill){
        caseService.checkUpdate(caseBill);
        return new JSONResult();
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Case entity){
        try {
            caseService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}
