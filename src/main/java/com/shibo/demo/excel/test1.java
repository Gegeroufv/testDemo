package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class test1 implements Serializable {
//    @Excel(name = "行数")
//    private Integer rowNum;
//    @Excel(name = "原因")
//    private String reason;
//    @Excel(name = "业务类型")
//    private String type;
//    @Excel(name = "开户银行")
//    private String bankName;
//    @Excel(name = "付款人账号")
//    private String payAccount;
//    @Excel(name = "付款人名称")
//    private String payName;
//    @Excel(name = "收款人账号")
//    private String receiveAccount;
//    @Excel(name = "收款人名称")
//    private String receiveName;
//    @Excel(name = "交易号")
//    private String tradeNum;
//    @Excel(name = "交易日期",importFormat = "yyyy/mm/dd")
//    private Date tradeDate;
//    @Excel(name = "交易金额")
//    private Long amount;
@Excel(name = "行数")
private String rowNum;
    //这里要求excel中的格式有规定
    @Excel(name = "转账日期",format = "yyyy/MM/dd")
    private Date transferTime;
    @Excel(name = "流水号")
    private String 	serialNumber;
    @Excel(name = "开户银行")
    private String bankName;
    @Excel(name = "付款人名称")
    private String customerName;
    @Excel(name = "转账金额")
    private String transferAmount;
    @Excel(name = "充值金额")
    private String rechargeAmount;

}
