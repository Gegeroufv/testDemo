package com.shibo.demo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@ExcelTarget("ExcelModel")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcelModel implements Serializable {
    @Excel(name = "行号")
    private Integer rowNum;
    @Excel(name = "转账时间",format = "yyyy/MM/dd")
    private Date transTime;
    @Excel(name = "流水号")
    private String serialNum;
    @Excel(name = "银行名称")
    private String bankName;
    @Excel(name = "付款人名称")
    private String payName;
    @Excel(name = "转账金额")
    private String amount;
    @Excel(name = "充值金额")
    private String recharge;
}
