package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.ProductInformation;
import CRM_Donegal.Donegal_CRM.query.ProductInformationQueryObject;
import CRM_Donegal.Donegal_CRM.service.IProductInformationService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Object: The informatin of Institution Product 
 * Author: Thunder Lei
 */
@Controller
@RequestMapping("productInformation")
public class ProductInformationController {
    @Autowired
    IProductInformationService productInformationService;

    @RequestMapping("view")
    @RequiresPermissions({"productInformation:view","The page of product information"})
    public String view(){
        return "information/productInformation";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(ProductInformationQueryObject qo){
        PageResult query = productInformationService.query(qo);
        return query;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<ProductInformation> selectAll() {
        return productInformationService.selectAll();
    }


    /*
        Query institutional products based on institutional id
        Back to the institutional product is displayed in 
        the drop-down box of the institutional product
     */
    @RequestMapping("selectByOranication")
    @ResponseBody
    public List<ProductInformation> selectByOranication(Long id) {
        return productInformationService.selectByOranication(id);
    }

    @RequestMapping("saveOrUpdate")
    @RequiresPermissions({"productInformation:saveOrUpdate", "The Change of product information"})
    @ResponseBody
    public Object saveOrUpdate(ProductInformation entity) {
        try {
            productInformationService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}
