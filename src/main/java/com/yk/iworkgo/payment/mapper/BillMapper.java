package com.yk.iworkgo.payment.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.payment.entity.Bill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 账单 Mapper 接口
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
public interface BillMapper extends BaseMapper<Bill> {

    List<Bill> getCurrentBillS(Page<Bill> page);

}
