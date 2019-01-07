package com.yk.iworkgo.payment.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.common.RespVo;
import com.yk.iworkgo.common.UserInfoVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.entity.Staff;
import com.yk.iworkgo.payment.service.BillService;
import com.yk.iworkgo.payment.service.DataservicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yk.iworkgo.common.BaseController;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 账单 前端控制器
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {


    @Value("${appKey}")
    private String appKey;

    @Value("${appSecret}")
    private String appSecret;

    @Autowired
    BillService billService;

    @RequestMapping("/property")
    public String toPropertyPage(@ModelAttribute("userInfo") UserInfoVO userInfo, @RequestParam String userId,@RequestParam String enterpriseId,@RequestParam String tel){
        userInfo.setUserId(userId);
        userInfo.setEnterpriseId(enterpriseId);
        userInfo.setTel(tel);
        return "payment/property";
    }

    @RequestMapping("/rent")
    public String toRentPage(@ModelAttribute("userInfo") UserInfoVO userInfo, @RequestParam String userId,@RequestParam String enterpriseId,@RequestParam String tel){
        userInfo.setUserId(userId);
        userInfo.setEnterpriseId(enterpriseId);
        userInfo.setTel(tel);
        return "payment/rent";
    }


    @RequestMapping("/listCurrentPage")
    @ResponseBody
    public RespVo listPage(@RequestParam Map<String, String> condition){
        RespVo rsp = new RespVo();
        String jsonString = JSONUtils.toJSONString(condition);
        JSONObject object = JSONObject.parseObject(jsonString);
        if(object.getInteger("pageFrom") == null || object.getInteger("pageSize") == null) {
            rsp.setCode(400);
            rsp.setMessage("未传入分页参数");
            return rsp;
        }

        if(StringUtils.isEmpty(object.getString("tenantId"))) {
            rsp.setCode(201);
            rsp.setMessage("未传入企业id");
            return rsp;
        }

//        Staff staff = getStaffInfo(object.getString("tel"));
//        if (staff == null || staff.getEnterpriseId() == null){
//            rsp.setCode(201);
//            rsp.setMessage("查询不到企业信息！");
//            return rsp;
//        }
//
//        Integer enterpriseId = staff.getEnterpriseId();


//        condition.put("tenantId",enterpriseId.toString());

        try {
            PageVO<Bill> data = billService.listCurrentBill(condition);
            rsp.setData(data);
            return rsp;
        }catch (Exception ex){
            rsp.setCode(500);
            rsp.setMessage("服务器内部错误,请联系管理员!");
            return rsp;
        }
    }


    @RequestMapping("listOverduePage")
    @ResponseBody
    public RespVo listOverduePage(@RequestParam Map<String, String> condition){
        RespVo rsp = new RespVo();
        String jsonString = JSONUtils.toJSONString(condition);
        JSONObject object = JSONObject.parseObject(jsonString);
        if(object.getInteger("pageFrom") == null || object.getInteger("pageSize") == null) {
            rsp.setCode(400);
            rsp.setMessage("未传入分页参数");
            return rsp;
        }
        if(StringUtils.isEmpty(object.getString("tenantId"))) {
            rsp.setCode(201);
            rsp.setMessage("未传入企业id");
            return rsp;
        }
//        Staff staff = getStaffInfo(object.getString("tel"));
//        if (staff == null || staff.getEnterpriseId() == null){
//            rsp.setCode(201);
//            rsp.setMessage("查询不到企业信息！ ");
//            return rsp;
//        }
//
//        Integer enterpriseId = staff.getEnterpriseId();
//        condition.put("tenantId",enterpriseId.toString());

        try {
            PageVO<Bill> data = billService.listOverdueBill(condition);
//            data.getRows().forEach(o -> o.getPrimeAmount()!=null?o.getPrimeAmount().
//                    add(o.getOverDueFineTheoryAmount()!=null?o.getOverDueFineTheoryAmount():BigDecimal.ZERO):BigDecimal.ZERO);
            if (data != null && data.getRows() != null){
                for (Bill bill : data.getRows()){
                    if (bill.getOverDueFineTheoryAmount()!=null && bill.getOverDueFineTheoryAmount().compareTo(BigDecimal.ZERO) > 0){
                        bill.setPrimeAmount(bill.getPrimeAmount().add(bill.getOverDueFineTheoryAmount()));
                    }
                }
            }

            rsp.setData(data);
            return rsp;
        }catch (Exception ex){
            rsp.setCode(500);
            rsp.setMessage("服务器内部错误,请联系管理员！");
            return rsp;
        }
    }

    @RequestMapping("listHistoryPage")
    @ResponseBody
    public RespVo listHistoryPage(@RequestParam Map<String, String> condition){
        RespVo rsp = new RespVo();
        String jsonString = JSONUtils.toJSONString(condition);
        JSONObject object = JSONObject.parseObject(jsonString);
        if(object.getInteger("pageFrom") == null || object.getInteger("pageSize") == null) {
            rsp.setCode(400);
            rsp.setMessage("未传入分页参数");
            return rsp;
        }
        if(StringUtils.isEmpty(object.getString("tenantId"))) {
            rsp.setCode(201);
            rsp.setMessage("未传入企业id");
            return rsp;
        }
//        Staff staff = getStaffInfo(object.getString("tel"));
//        if (staff == null || staff.getEnterpriseId() == null){
//            rsp.setCode(201);
//            rsp.setMessage("查询不到企业信息！ ");
//            return rsp;
//        }
//
//        Integer enterpriseId = staff.getEnterpriseId();
//        condition.put("tenantId",enterpriseId.toString());

        try {
            PageVO<Bill> data = billService.listHistoryBill(condition);
            if (data != null && data.getRows() != null){
                for (Bill bill : data.getRows()){
                    if (bill.getOverDueFineTheoryAmount()!=null && bill.getOverDueFineTheoryAmount().compareTo(BigDecimal.ZERO) > 0){
                        bill.setPrimeAmount(bill.getPrimeAmount().add(bill.getOverDueFineTheoryAmount()));
                    }
                }
            }
            //test by guojing start
//            if (data != null && data.getRows() != null){
//                int i = 1;
//                for (Iterator<Bill> iterator = data.getRows().iterator();iterator.hasNext();){
//                    Bill bill = iterator.next();
//                    if (i >= 5){
//                        iterator.remove();
//                    }
//                    i++;
//                }
//            }
            //test by guojing end

            rsp.setData(data);
            return rsp;
        }catch (Exception ex){
            rsp.setCode(500);
            rsp.setMessage("服务器内部错误,请联系管理员！");
            return rsp;
        }
    }

}
