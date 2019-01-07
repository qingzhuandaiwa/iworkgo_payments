package com.yk.iworkgo.payment.service;

import com.yk.iworkgo.common.PageVO;
import com.yk.iworkgo.payment.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 合同 服务类
 * </p>
 *
 * @author guojing
 * @since 2019-01-07
 */
public interface ContractService extends IService<Contract> {

    PageVO<Contract> listAllContract(Map<String,String> condition);
}
