package com.yk.iworkgo.payment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.mapper.BillMapper;
import com.yk.iworkgo.payment.service.BillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yk.iworkgo.utils.BuildPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单 服务实现类
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {

    @Autowired
    private BillMapper billMapper;


    @Override
    public PageVO<Bill> listRentCurrentBill(Map<String, String> condition) {
        Page<Bill> page = BuildPageHelper.buildPage(condition);
        List<Bill> billS = billMapper.getCurrentRentBillS(page,condition);
        return new PageVO<>(billS,page);
    }

    @Override
    public PageVO<Bill> listRentOverdueBill(Map<String, String> condition) {
        Page<Bill> page = BuildPageHelper.buildPage(condition);
        List<Bill> billS = billMapper.getOverdueRentBillS(page,condition);
        return new PageVO<>(billS,page);
    }

    @Override
    public PageVO<Bill> listRentHistoryBill(Map<String, String> condition) {
        Page<Bill> page = BuildPageHelper.buildPage(condition);
        List<Bill> billS = billMapper.getHistoryRentBillS(page,condition);
        return new PageVO<>(billS,page);
    }

//    @Resource
//    DataservicesService dataservicesService;

//    @Override
//    public Bill getCurrentPeriod(Map<String, Object> condition) {
//        String token = dataservicesService.getAccessToken();
//
//
//        return null;
//    }




}
