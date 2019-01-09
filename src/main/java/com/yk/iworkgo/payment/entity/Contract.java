package com.yk.iworkgo.payment.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同
 * </p>
 *
 * @author guojing
 * @since 2019-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("contactId")
    private Integer contactId;

    @TableField("contractNo")
    private String contractNo;

    @TableField("enterpriseId")
    private Integer enterpriseId;

    @TableField("enterpriseName")
    private String enterpriseName;

    @TableField("parkId")
    private Integer parkId;

    @TableField("parkName")
    private String parkName;

    @TableField("buildingId")
    private Integer buildingId;

    @TableField("buildingName")
    private String buildingName;

    @TableField("floorIds")
    private String floorIds;

    private String floors;

    @TableField("roomIds")
    private String roomIds;

    private String rooms;

    @TableField("leaseBeginDate")
    private String leaseBeginDate;

    @TableField("leaseEndDate")
    private String leaseEndDate;

    @TableField("isDel")
    private String isDel;

    @TableField("cTime")
    private LocalDateTime cTime;

    @TableField("uTime")
    private LocalDateTime uTime;

    @TableField(exist = false)
    private String leaseId;

    @TableField(exist = false)
    private String leaseTermType;

}
