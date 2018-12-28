package com.yk.iworkgo.payment.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.common.RespVo;
import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.service.BillService;
import com.yk.iworkgo.payment.service.DataservicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.yk.iworkgo.common.BaseController;

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

    @RequestMapping("/index")
    public String index(){
        return "payment/property";
    }


    @RequestMapping("/listPage")
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
        if (StringUtils.isEmpty(object.getString("tel"))){
            rsp.setCode(400);
            rsp.setMessage("未传入用户的电话号码");
            return rsp;
        }
//        Long parkId = Optional.ofNullable(condition.get("parkId")).map(Long::parseLong).orElse(0L);
//        return this.listPage(condition);
//        condition.put("pageFrom","1");
//        condition.put("pageSize","10");
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

}
