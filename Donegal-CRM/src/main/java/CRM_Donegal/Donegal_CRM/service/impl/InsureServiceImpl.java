package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.domain.Mission;
import CRM_Donegal.Donegal_CRM.domain.ProductInformation;
import CRM_Donegal.Donegal_CRM.mapper.CarMessageMapper;
import CRM_Donegal.Donegal_CRM.mapper.ClientMapper;
import CRM_Donegal.Donegal_CRM.mapper.InsuranceMapper;
import CRM_Donegal.Donegal_CRM.mapper.ProductInformationMapper;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.service.IInsureService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.SerialGenerator;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.lang.Iterable;

@Service
public class InsureServiceImpl implements IInsureService {
    @Autowired
    InsuranceMapper insuranceMapper;
    @Autowired
    ClientMapper clientMapper;
    @Autowired
    CarMessageMapper carMapper;
    @Autowired
    ProductInformationMapper productMapper;

    @Override
    public void save(Insurance entity) {
        Client client = clientMapper.selectByClient(entity.getClient().getId());
       
        if (client == null) {
            clientMapper.insert(entity.getClient());
        }
        
        CarMessage car = carMapper.selectByPrimaryKey(entity.getCar().getId());
        if (car == null) {
            carMapper.insert(entity.getCar());
        }
        
        BigDecimal amount = BigDecimal.ZERO;
        
        /*
        //////
        
        public void printPairs() {
            ArrayList<Integer> num=new ArrayList<Integer>();

            NumberList numbers = new NumberList(50);
            numbers.add(4);
            numbers.add(5);
            numbers.add(6);

            for(Number n1: numbers){
                System.out.println(n1);
            }
        }
        
        
        @Override
        public Iterator<Number> iterator() {
            return Arrays.asList(numbers).subList(0, numItems).iterator();
        }
        
        */ 
        
      // Iterator<ProductInformation> iterator(){
        //	return Arrays.asList(entity.getProducts).subList().iterator();
        //}
        
        /*
        for (ProductInformation product : entity.getProducts()) {
            ProductInformation p = productMapper.selectByPrimaryKey(product.getId());
            amount = amount.add(p.getAnnualFee());
        }
        */
        entity.setAmount(amount);
       
        entity.setApplytime(new Date());
       
        long serialId = new SerialGenerator().getSerialId();
        entity.setApplysn(serialId+"");

     
        entity.setInputer(UserContext.getCurrentUser());
       
        entity.setBillstatus(Insurance.BILL_MOMENT_STORE);
     
        insuranceMapper.insert(entity);
        
        /*
        @Override
    public void saveOrUpdate(Mission entity) {
        if (entity.getId() == null) {
         
            Employee e = employeeMapper.selectByRealname(entity.getName());
          
            String dept = ((Mission) e.getDept()).getName();
           
            entity.setDept(dept);
            
            entity.setState(false);
            missionMapper.insert(entity);
        } else {
           
            Employee e = employeeMapper.selectByRealname(entity.getName());
          
            String dept = ((Mission) e.getDept()).getName();
           
            entity.setDept(dept);
            missionMapper.updateByPrimaryKey(entity);
        }
    }

      
         */
        
        
    
        for (ProductInformation p : entity.getProducts()) {
            insuranceMapper.insertProductRelation(entity.getId(), p.getId());
        }
    }

    private Object getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void update(Insurance entity){
        Client client = clientMapper.selectByClient(entity.getClient().getId());
       
        if (client == null) {
            clientMapper.insert(entity.getClient());
        }
        
        CarMessage car = carMapper.selectByPrimaryKey(entity.getCar().getId());
        if (car == null) {
            carMapper.insert(entity.getCar());
        }
    
        BigDecimal amount = BigDecimal.ZERO;
     
        for (ProductInformation product : entity.getProducts()) {
            ProductInformation p = productMapper.selectByPrimaryKey(product.getId());
            amount = amount.add(p.getAnnualFee());
        }
        entity.setAmount(amount);
        
        entity.setBillstatus(Insurance.BILL_MOMENT_STORE);
        
        for (ProductInformation p : entity.getProducts()) {
            insuranceMapper.deleteProductRelation(entity.getId());
            insuranceMapper.insertProductRelation(entity.getId(), p.getId());
        }
        insuranceMapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Long id) {
        insuranceMapper.deleteProductRelation(id);
        insuranceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Insurance get(Long id) {
        return insuranceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Insurance> selectAll() {
        return insuranceMapper.selectAll();
    }

    @Override
    public PageResult queryWaitAndEdit(QueryObject qo) {
        Integer total = insuranceMapper.queryWaitAndEditForCount(qo);
        if (total > 0) {
            List<?> list = insuranceMapper.queryWaitAndEditForList(qo);
            return new PageResult(list, total);
        }
        return PageResult.EMPTY_PAGE;
    }

    public void updateBillStatus(Insurance insurance) {

       
        insurance.setBillstatus(Insurance.BILL_EDIT_AUDIT_WAIT);
        insuranceMapper.updateBillStatus(insurance);

    }

    @Override
    public void changeAsRollback(Long id) {
        insuranceMapper.changeAsRollback(id);
    }

    @Override
    public void changeAsAudit(Long id) {
        insuranceMapper.changeAsAudit(id);
    }

    @Override
    public PageResult query(QueryObject qo) {
        Integer total = insuranceMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(insuranceMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    /**
     * Query out the pending order status
     * @return
     */
    @Override
    public List<Insurance> selectByInsuranceAutit(ReviewQueryObject qo) {
        return insuranceMapper.selectByInsuranceAutit(qo);
    }

    public PageResult selectPayInfoState(ReviewQueryObject qo) {

        Integer count = insuranceMapper.queryForCount(qo);

        List<Insurance> list = insuranceMapper.selectPayInfoState(qo);


        return new PageResult(list,count);
    }

}
