package com.yk.iworkgo.payment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Bill;
import com.yk.iworkgo.payment.entity.Contract;
import com.yk.iworkgo.payment.mapper.ContractMapper;
import com.yk.iworkgo.payment.service.ContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yk.iworkgo.utils.BuildPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 合同 服务实现类
 * </p>
 *
 * @author guojing
 * @since 2019-01-07
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements ContractService {

    @Resource
    private ContractMapper contractMapper;

    @Override
    public PageVO<Contract> listAllContract(Map<String, String> condition) {
        Page<Contract> page = BuildPageHelper.buildPage(condition);
        QueryWrapper<Contract> qw = new QueryWrapper();
        qw.eq(condition.containsKey("tenantId"),"enterpriseId",condition.get("tenantId"));
        IPage<Contract> resultS = contractMapper.selectPage(page,qw);
        return new PageVO<>(resultS.getRecords(),(int)resultS.getTotal(),(int)resultS.getPages(),
                (int)resultS.getCurrent(),(int)resultS.getSize());
    }
}
