package CRM_Donegal.Donegal_CRM.util;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Salary;
import CRM_Donegal.Donegal_CRM.domain.Signed;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.mapper.SalaryMapper;
import CRM_Donegal.Donegal_CRM.mapper.SignedMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The tools of Salary 
 *Thunder Lei
 * Jan, 2020
 * Used to encapsulate the complicated salary business and the set method
 */

public abstract class SalaryUtill {
    public static Salary totalSalary(Salary entity,EmployeeMapper employeeMapper,
        SignedMapper signedMapper) throws ParseException {
        
        String realname = entity.getEmpName();
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        
        Date balancedate = entity.getBalancedate();
       
        String balancedateFormat = simpleDateFormat.format(balancedate);
        //The payroll of String Date
        Date parsebalancedate = simpleDateFormat.parse(balancedateFormat);
        //sql - Query the number of the user's late arrivals in the month
        int count = signedMapper.selectAllLateCount(parsebalancedate, realname);
        
        if (entity.getEmpName() != null) {
            //sql - Query real name of user 
            Employee e = employeeMapper.selectByRealname(realname);
          
            Department d = e.getDept();
          
            entity.setEmpId(e.getId());
         
            entity.setEmpId(e.getTel());
            
            entity.setEmpEmail(e.getEmail());
            
            entity.setDeptId(d.getId());
          
            entity.setDeptName(d.getName());
        }
        //when null, it will be transfer to 0
        Long bouns = entity.getBouns() == null ? 0 : (long) entity.getBouns();
        //When null, to be 0
        Long salary = entity.getSalary() == null ? 0 :(long) entity.getSalary();
        
        entity.setLatecount(count);
        
        if (count > 0) {
            entity.setTotalsalary((long) ((salary - (salary * (count * 0.05)))));
        }else if (count == 0){
            entity.setTotalsalary(bouns + salary);
        }
        return entity;
    }
}
