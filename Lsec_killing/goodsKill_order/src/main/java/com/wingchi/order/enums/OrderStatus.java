package com.wingchi.order.enums;
//1、未付款 2、已付款,未发货
// 3、已发货,未确认 4、确认收货，交易成功
// 5、交易取消，订单关闭 6、交易结束，已评价',


public enum OrderStatus {
    CREATE(1,"未付款"),
    PAYED(2,"已付款，未发货"),
    CONSIGN(3,"已发货，未确认"),
    ACK(4,"确认收货，交易成功"),
    FAIL(5,"交易取消，订单关闭"),
    FINISH(6,"交易结束");
    private int values;
    private String desc;

    OrderStatus(int values, String desc) {
        this.values = values;
        this.desc = desc;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
