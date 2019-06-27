package com.shibo.demo.validation;

/**
 * 开户行
 * @date  2019/05/08
 * @author 古博今
 */
public enum BankNames {
    XINGYE_ZZ_SHANGWUWAIHUAN("兴业银行郑州商务外环路支行", 1, "一般户（税户）"),
    GONGSHANG_ZZ_SHANGDULU("中国工商银行郑州商都路支行", 2, "充值户"),
    GONGSHANG_ZZ_SHANGDULU2("中国工商银行郑州商都路支行",3,"一般户"),
    JIANSHE_ZZ_HANGKONGGANG("中国建设银行股份有限公司郑州航空港区支行",4,"充值户"),
    JIANSHE_ZZ_HENANSHENG("中国建设银行河南省分行",5,"充值户"),
    ZHONGGUO_ZZ_CAIFUGUANGCHANG("中国银行郑州财富广场支行",6,"充值户"),
    ZHONGGUO_ZZ_CAIFUGUANGCHANG2("中国银行郑州财富广场支行",7,"一般户"),
    ZHONGGUO_ZZ_WENHUALU("中国银行郑州文化路支行",8,"一般户-038帐套结算账户"),
    ZHONGGUO_ZZ_ZIMAOQU("中国银行郑州自贸区分行",9,"基本户"),
    YOUZHENG_ZZ_ZHONGYIXILU("中国邮政储蓄银行郑州市众意西路支行",10,"充值户");
    //银行名称
    private String bankName;
    //银行编号
    private Integer num;
    //账户性质
    private String property;

    BankNames(String bankName, Integer num, String property) {
        this.bankName = bankName;
        this.num = num;
        this.property = property;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * 把银行编号转换为银行名称
     * @param num 银行编号
     * @return
     */
    public static String num2Name(Integer num){
        for(BankNames b:BankNames.values()){
            if(b.num.equals(num)){
                return b.bankName;
            }
        }
        return null;
    }
    /**
     * 判断银行名称是否存在
     * @param bankName
     * @return
     */
    public static boolean isLegal(String bankName){
        for(BankNames b:BankNames.values()){
            if(b.bankName.equals(bankName)){
                return true;
            }
        }
        return false;
    }
}
