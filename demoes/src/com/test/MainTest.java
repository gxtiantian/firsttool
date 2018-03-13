package com.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;

import com.entity.AcceptanceDraft;
import com.entity.PledgeApply;
import com.entity.PledgeApplyVo;
import com.entity.TrzAcceptanceDraft;
import com.entity.TrzPledgeApply;

public class MainTest {
    public static void main(String[] args) throws Exception {
        String[] strs = {"123","ab","apple"};
        System.out.println("for a new update");
        System.out.println(Arrays.toString(strs));
    }
    
    public static String mehtod0227(boolean showRow, int rowNum, String message) {


        if (showRow) {

            return String.format(" 第%d行数据  %s", rowNum+1, message);

        } else {

            return String.format("%s", rowNum+1, message);

        }
    }
    
    public static void m1211(int length) {
        
    }
    
    public static void m122901() throws IllegalAccessException, InvocationTargetException {
        AcceptanceDraft acd = new AcceptanceDraft();
        acd.setPkid(100L);
        acd.setAcceptanceDraftNo("123456");
        acd.setAcceptorAccount("998");
        acd.setAcceptorBankName("乌鲁木齐引号");
        acd.setAcceptorBankNo("09090999333");
        
        TrzAcceptanceDraft tacd = new TrzAcceptanceDraft();
        
        BeanUtils.copyProperties(tacd, acd);
        System.out.println("bankno:"+tacd.getAcceptorBankNo());
        System.out.println("acceptor:"+tacd.getAcceptorName());
    }
    
}
