package com.yk.iworkgo.payment.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 账单 服务类
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
public interface BillService extends IService<Bill> {

    PageVO<Bill> listCurrentBill(Map<String,String> condition);

    PageVO<Bill> listOverudeBill(Map<String,String> condition);

}
