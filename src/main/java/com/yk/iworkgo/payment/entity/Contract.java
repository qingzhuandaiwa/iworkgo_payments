package com.yk.iworkgo.payment.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同(主表)
 * </p>
 *
 * @author guojing
 * @since 2019-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    private String contractId;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 企业id
     */
    private String enterpriseId;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 合同状态
     */
    private String contractState;

    /**
     * 楼宇id
     */
    private String buildingId;

    /**
     * 楼宇名称
     */
    private String buildingName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 面积
     */
    private String areaSize;

    /**
     * 建筑类型
     */
    private String buildingType;

    /**
     * 押金
     */
    private String deposit;

    /**
     * 押金单位
     */
    @TableField("depositUnitEnum")
    private String depositUnitEnum;

    /**
     * 租约开始时间
     */
    private LocalDateTime leaseBeginDate;

    /**
     * 租约结束时间
     */
    private LocalDateTime leaseEndDate;

    /**
     * 签订日期
     */
    @JsonFormat(pattern = "yyyy.MM.dd",timezone="GMT+8")
    private LocalDateTime signDate;

    /**
     * 是否删除(0未删除，1删除)
     */
    private String isDel;

    /**
     * 创建时间
     */
    private LocalDateTime ctime;

    /**
     * 更新时间
     */
    private LocalDateTime utime;


}
