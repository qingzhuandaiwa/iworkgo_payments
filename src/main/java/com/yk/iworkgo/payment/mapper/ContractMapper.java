package com.yk.iworkgo.payment.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.iworkgo.payment.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 合同(主表) Mapper 接口
 * </p>
 *
 * @author guojing
 * @since 2019-01-09
 */
public interface ContractMapper extends BaseMapper<Contract> {
    @Select("SELECT c.*, t.lease_id, t.lease_term_type FROM ( SELECT * FROM contract WHERE enterprise_id = #{tenantId} ) c LEFT JOIN  contract_lease_term t ON c.contract_id = t.contract_id")
    List<Contract> getContractSByTenantId(Page<Contract> page, @Param("tenantId")String tenantId);
}
