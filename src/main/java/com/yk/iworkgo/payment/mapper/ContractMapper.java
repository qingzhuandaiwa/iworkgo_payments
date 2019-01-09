package com.yk.iworkgo.payment.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.payment.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 合同 Mapper 接口
 * </p>
 *
 * @author guojing
 * @since 2019-01-07
 */
public interface ContractMapper extends BaseMapper<Contract> {

    @Select("SELECT c.*, t.leaseId, t.leaseTermType FROM ( SELECT * FROM t_contract WHERE enterpriseId = #{tenantId} ) c LEFT JOIN  t_contract_lease_term t ON c.contactId = t.contractId")
    List<Contract> getContractSByTenantId(Page<Contract> page, @Param("tenantId")String tenantId);

}
