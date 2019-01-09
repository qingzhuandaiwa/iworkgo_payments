package com.yk.iworkgo.payment.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.payment.entity.Bill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 账单 Mapper 接口
 * </p>
 *
 * @author guojing
 * @since 2019-01-09
 */
public interface BillMapper extends BaseMapper<Bill> {

    List<Bill> getCurrentBillS(Page<Bill> page, @Param("cond") Map<String, String> condition);

    List<Bill> getOverdueBillS(Page<Bill> page, @Param("cond") Map<String, String> condition);

    List<Bill> getHistoryBillS(Page<Bill> page, @Param("cond") Map<String, String> condition);
}
