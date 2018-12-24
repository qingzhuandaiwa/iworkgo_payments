package com.yk.iworkgo.payment.service.impl;

import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.mapper.BillMapper;
import com.yk.iworkgo.payment.service.BillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
