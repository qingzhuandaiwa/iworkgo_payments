package com.yk.iworkgo.payment.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.common.RespVo;
import com.yk.iworkgo.common.UserInfoVO;
import com.yk.iworkgo.payment.entity.Contract;
import com.yk.iworkgo.payment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yk.iworkgo.common.BaseController;

import java.util.Map;

/**
 * <p>
 * 合同 前端控制器
 * </p>
 *
 * @author guojing
 * @since 2019-01-07
 */
@Controller
@RequestMapping("/enterprise")
public class ContractController extends BaseController {

    @Autowired
    ContractService contractService;

    @RequestMapping("/contract")
    public String toPropertyPage(@ModelAttribute("userInfo") UserInfoVO userInfo, @RequestParam String userId, @RequestParam String enterpriseId, @RequestParam String tel){
        userInfo.setUserId(userId);
        userInfo.setEnterpriseId(enterpriseId);
        userInfo.setTel(tel);
        return "payment/contract";
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

        if(StringUtils.isEmpty(object.getString("tenantId"))) {
            rsp.setCode(201);
            rsp.setMessage("未传入企业id！");
            return rsp;
        }

        try {
            PageVO<Contract> data = contractService.listAllContract(condition);
            rsp.setData(data);
            return rsp;
        }catch (Exception ex){
            rsp.setCode(500);
            rsp.setMessage("服务器内部错误,请联系管理员!");
            return rsp;
        }
    }

}
