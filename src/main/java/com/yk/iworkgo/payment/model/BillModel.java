package com.yk.iworkgo.payment.model;

import lombok.Data;

import java.io.PipedReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class BillModel {

    private String billId;

    private String billType;

    private String buildingName;

    private String roomNumber;

    private Timestamp startDate;

    private Timestamp endDate;

    private BigDecimal primeAmount;

    //理论滞纳金
    private  BigDecimal overDueFineTheoryAmount;

    //实际滞纳金
    private BigDecimal actualAmount;

    //结清状态
    private String settle_status;

    //结清状态名称
    private String SettledStatusName;

    //逾期名称
    private String dueStatusName;

    //逾期天数
    private Integer expired_day;

}
