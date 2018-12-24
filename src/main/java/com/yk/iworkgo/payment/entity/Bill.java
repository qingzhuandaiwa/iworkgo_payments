package com.yk.iworkgo.payment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账单
 * </p>
 *
 * @author guojing
 * @since 2018-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    private String billId;

    private String billNo;

    /**
     * 账单类型
     */
    private String action;

    /**
     * 联系人
     */
    private BigDecimal adjustedPrimeAmount;

    /**
     * 填写的要收的滞纳金
     */
    private BigDecimal actualAmount;

    /**
     * 滞纳金比例
     */
    private BigDecimal rate;

    /**
     * 根据条款算出的理论滞纳金
     */
    private BigDecimal overDueFineTheoryAmount;

    /**
     * 费用类型
     */
    private String billType;

    /**
     * 邮箱
     */
    private String buildingId;

    /**
     * 关联楼盘
     */
    private String buildingName;

    /**
     * 关闭状态
     */
    private String closedStatus;

    /**
     * 关闭状态名称
     */
    private String closedStatusName;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 逾期状态
     */
    private String dateScope;

    /**
     * 逾期状态名
     */
    private String dueStatusName;

    /**
     * 结束时间
     */
    private LocalDateTime endDate;

    /**
     * 逾期天数
     */
    private Integer expiredDay;

    /**
     * 生成通知单次数
     */
    private Integer generatedReminderCount;

    /**
     * 经手人
     */
    private String handler;

    private String invoiceAmount;

    private String invoiceStatus;

    private String invoiceStatusName;

    /**
     * 开具收据次数
     */
    private Integer issueReceiptCount;

    private String matchId;

    /**
     * 其他详情里面匹配的金额
     */
    private BigDecimal matchedAmount;

    /**
     * 货币单位
     */
    private String monetaryUnit;

    /**
     * 账单关联的id
     */
    private String objectId;

    /**
     * 账单关联的type
     */
    private String objectType;

    /**
     * 账单关联的编号
     */
    private String orderNo;

    /**
     * 交易对方
     */
    private String other;

    /**
     * 滞纳金收齐状态
     */
    private String overDueFineStatus;

    /**
     * 滞纳金收齐状态名称
     */
    @TableField("overDueFineStatusName")
    private String overDueFineStatusName;

    /**
     * 应付时间
     */
    private LocalDateTime payDate;

    /**
     * 实收实付金额
     */
    private BigDecimal payedAmount;

    /**
     * 实收(付)金额
     */
    private BigDecimal primeAmount;

    /**
     * 账单开具收据金额
     */
    private BigDecimal receiptAmount;

    /**
     * 需要收（付）金额
     */
    private BigDecimal remainingAmount;

    /**
     * 房号
     */
    private String roomNumber;

    /**
     * 结清状态
     */
    private String settleStatus;

    /**
     * 结清状态名称
     */
    private String settleStatusName;

    /**
     * 结清时间
     */
    @TableField("settledDate")
    private LocalDateTime settledDate;

    /**
     * 开始时间
     */
    private LocalDateTime startDate;

    /**
     * 承租人id
     */
    private String tenantId;

    /**
     * 协议或条款id
     */
    private String termId;

    /**
     * 退租结算调整金额
     */
    private BigDecimal terminationIncomeAdjust;

    /**
     * 实际收入支出
     */
    private BigDecimal theoryAmount;

    /**
     * 保证金转交金额
     */
    private BigDecimal transferAmount;

    /**
     * 租金结转金额
     */
    private BigDecimal transferToOtherBillAmount;

    /**
     * 账单类型名称
     */
    private String typeNme;

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
