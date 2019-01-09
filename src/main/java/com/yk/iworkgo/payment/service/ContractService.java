package com.yk.iworkgo.payment.service;

import com.yk.iworkgo.payment.entity.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yk.iworkgo.common.PageVO;
import java.util.Map;

/**
 * <p>
 * 合同(主表) 服务类
 * </p>
 *
 * @author guojing
 * @since 2019-01-09
 */
public interface ContractService extends IService<Contract> {

    PageVO<Contract> listAllContract(Map<String, String> condition);
}
