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
 * 
 * </p>
 *
 * @author guojing
 * @since 2018-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("staffId")
    private String staffId;

    /**
     * 性别 0-男 1-女
     */
    private String sex;

    /**
     * 员工姓名
     */
    @TableField("staffName")
    private String staffName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 企业id
     */
    @TableField("enterpriseId")
    private Integer enterpriseId;

    @TableField("enterpriseName")
    private String enterpriseName;

    @TableField("isSuperManager")
    private String isSuperManager;

    /**
     * 是否管理员 0-不是 1-是
     */
    @TableField("isManager")
    private String isManager;

    private String status;

    /**
     * 是否删除，1为删除，0为未删除
     */
    @TableField("isDel")
    private String isDel;

    @TableField("cTime")
    private LocalDateTime cTime;

    @TableField("uTime")
    private LocalDateTime uTime;


}
