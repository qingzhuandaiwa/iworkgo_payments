package com.yk.iworkgo.payment.service;

import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 账单 服务类
 * </p>
 *
 * @author guojing
 * @since 2019-01-09
 */
public interface BillService extends IService<Bill> {

    PageVO<Bill> listCurrentBill(Map<String, String> condition);

    PageVO<Bill> listOverdueBill(Map<String, String> condition);

    PageVO<Bill> listHistoryBill(Map<String, String> condition);

}
