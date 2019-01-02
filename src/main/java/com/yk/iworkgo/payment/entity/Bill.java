package com.yk.iworkgo.payment.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账单
 * </p>
 *
 * @author guojing
 * @since 2018-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("billId")
    private String billId;

    @TableField("billNo")
    private String billNo;

    /**
     * 账单类型
     */
    private String action;

    /**
     * 联系人
     */
    @TableField("adjustedPrimeAmount")
    private BigDecimal adjustedPrimeAmount;

    /**
     * 填写的要收的滞纳金
     */
    @TableField("actualAmount")
    private BigDecimal actualAmount;

    /**
     * 滞纳金比例
     */
    private BigDecimal rate;

    /**
     * 根据条款算出的理论滞纳金
     */
    @TableField("overDueFineTheoryAmount")
    private BigDecimal overDueFineTheoryAmount;

    /**
     * 费用类型
     */
    @TableField("billType")
    private String billType;

    /**
     * 邮箱
     */
    @TableField("buildingId")
    private String buildingId;

    /**
     * 关联楼盘
     */
    @TableField("buildingName")
    private String buildingName;

    /**
     * 关闭状态
     */
    @TableField("closedStatus")
    private String closedStatus;

    /**
     * 关闭状态名称
     */
    @TableField("closedStatusName")
    private String closedStatusName;

    /**
     * 创建时间
     */
    @TableField("createdDate")
    private LocalDateTime createdDate;

    /**
     * 逾期状态
     */
    @TableField("dateScope")
    private String dateScope;

    /**
     * 逾期状态名
     */
    @TableField("dueStatusName")
    private String dueStatusName;

    /**
     * 结束时间
     */
    @TableField("endDate")
    @JsonFormat(pattern = "yyyy.MM.dd",timezone="GMT+8")
    private LocalDateTime endDate;

    /**
     * 逾期天数
     */
    @TableField("expiredDay")
    private Integer expiredDay;

    /**
     * 生成通知单次数
     */
    @TableField("generatedReminderCount")
    private Integer generatedReminderCount;

    /**
     * 经手人
     */
    private String handler;

    @TableField("invoiceAmount")
    private String invoiceAmount;

    @TableField("invoiceStatus")
    private String invoiceStatus;

    @TableField("invoiceStatusName")
    private String invoiceStatusName;

    /**
     * 开具收据次数
     */
    @TableField("issueReceiptCount")
    private Integer issueReceiptCount;

    @TableField("matchId")
    private String matchId;

    /**
     * 其他详情里面匹配的金额
     */
    @TableField("matchedAmount")
    private BigDecimal matchedAmount;

    /**
     * 货币单位
     */
    @TableField("monetaryUnit")
    private String monetaryUnit;

    /**
     * 账单关联的id
     */
    @TableField("objectId")
    private String objectId;

    /**
     * 账单关联的type
     */
    @TableField("objectType")
    private String objectType;

    /**
     * 账单关联的编号
     */
    @TableField("orderNo")
    private String orderNo;

    /**
     * 交易对方
     */
    private String other;

    /**
     * 滞纳金收齐状态
     */
    @TableField("overDueFineStatus")
    private String overDueFineStatus;

    /**
     * 滞纳金收齐状态名称
     */
    @TableField("overDueFineStatusName")
    private String overDueFineStatusName;

    /**
     * 应付时间
     */
    @TableField("payDate")
    private LocalDateTime payDate;

    /**
     * 实收实付金额
     */
    @TableField("payedAmount")
    private BigDecimal payedAmount;

    /**
     * 实收(付)金额
     */
    @TableField("primeAmount")
    private BigDecimal primeAmount;

    /**
     * 账单开具收据金额
     */
    @TableField("receiptAmount")
    private BigDecimal receiptAmount;

    /**
     * 需要收（付）金额
     */
    @TableField("remainingAmount")
    private BigDecimal remainingAmount;

    /**
     * 房号
     */
    @TableField("roomNumber")
    private String roomNumber;

    /**
     * 结清状态
     */
    @TableField("settleStatus")
    private String settleStatus;

    /**
     * 结清状态名称
     */
    @TableField("settleStatusName")
    private String settleStatusName;

    /**
     * 结清时间
     */
    @TableField("settledDate")
    @JsonFormat(pattern = "yyyy.MM.dd",timezone="GMT+8")
    private LocalDateTime settledDate;

    /**
     * 开始时间
     */
    @TableField("startDate")
    @JsonFormat(pattern = "yyyy.MM.dd",timezone="GMT+8")
    private LocalDateTime startDate;

    /**
     * 承租人id
     */
    @TableField("tenantId")
    private String tenantId;

    /**
     * 协议或条款id
     */
    @TableField("termId")
    private String termId;

    /**
     * 退租结算调整金额
     */
    @TableField("terminationIncomeAdjust")
    private BigDecimal terminationIncomeAdjust;

    /**
     * 实际收入支出
     */
    @TableField("theoryAmount")
    private BigDecimal theoryAmount;

    /**
     * 保证金转交金额
     */
    @TableField("transferAmount")
    private BigDecimal transferAmount;

    /**
     * 租金结转金额
     */
    @TableField("transferToOtherBillAmount")
    private BigDecimal transferToOtherBillAmount;

    /**
     * 账单类型名称
     */
    @TableField("typeNme")
    private String typeNme;

    /**
     * 是否删除(0未删除，1删除)
     */
    @TableField("isDel")
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
