package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Signed;
import CRM_Donegal.Donegal_CRM.mapper.SignedMapper;
import CRM_Donegal.Donegal_CRM.query.SignedQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISignedService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.SignedUtil;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementing Attendance Management
 * Thunder Lei
 
 */

@Service
public class SignedServiceImpl implements ISignedService {
    @Autowired
    SignedMapper signedMapper;

    /**
     * 
	The Business of checking in when going to work
     */
    @Override
    public void startwork() throws ParseException {
        Signed s = new Signed();
       
        Employee currentUser = UserContext.getCurrentUser();
        
        Long empId = currentUser.getId();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
       
        String dateFormat = simpleDateFormat.format(date);
        
        Date formatDate = simpleDateFormat.parse(dateFormat);
        Signed startwork = signedMapper.selectStartwork(empId, formatDate);//The return here is already signed in and signed in today
        
        String realname = currentUser.getRealname();
        
        String deptName = currentUser.getName();
        if (startwork == null ) {
            SignedUtil.startWork(s,formatDate,realname,deptName,date,empId);
            signedMapper.insert(s);
        }else if (startwork != null){//Not the first time to log in, and there is a log in today
            throw new RuntimeException("\n" + "Don't log in repeatedly please~");
        }
    }

    /**
     * The business of getting off 
     */
    @Override
    public void offwork() throws ParseException {
        Employee currentUser = UserContext.getCurrentUser();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
       
        String dateFormat = simpleDateFormat.format(date);
       
        Date formatDate = simpleDateFormat.parse(dateFormat);
        System.out.println(formatDate);
        //Getting the id 
        Long empId = currentUser.getId();
        Signed signed = signedMapper.selectStartwork(empId,formatDate);// Find out if you have logged in and have checked in
        if (signed != null){// Have Checked in and Login 
              
                Date checkTime = signed.getCheckTime();
               
                String realname = currentUser.getRealname();
                
                String deptName = currentUser.getName();
                
                Date startWork = signed.getStartWork();
                
                Long id = signed.getId();
                
                signed.setId(id);
                
                signed.setCheckTime(checkTime);
                
                signed.setEmpRealname(realname);
               
                signed.setDeptName(deptName);
               
                signed.setStartWork(startWork);
                
                signed.setState(true);
                
                signed.setEmpId(empId);
                signed.setOffWork(date);
                signedMapper.updateOffWork(signed);
        }else if (signed == null){//No check in this morning or check-in time has passed
            throw new RuntimeException("No check in this morning or check-in time has passed");
        }
    }

    public void delete(Long id) {
        signedMapper.deleteByPrimaryKey(id);
    }

    public Signed get(Long id) {
        return signedMapper.selectByPrimaryKey(id);
    }

    public PageResult query(SignedQueryObject qo) {
        Integer total = signedMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(signedMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }
}
