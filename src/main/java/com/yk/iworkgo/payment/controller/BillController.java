package com.yk.iworkgo.payment.controller;


import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yk.iworkgo.common.BaseController;

import java.util.Map;

/**
 * <p>
 * 账单 前端控制器
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
@RestController
@RequestMapping("/payment/bill")
public class BillController extends BaseController {

    @Autowired
    BillService billService;

    @RequestMapping("list")
    public PageVO<Bill> listPage(@RequestParam Map<String, String> condition){
//        billService.listPage();
return null;
    }

}
