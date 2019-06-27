package com.shibo.demo.testPojo;

public enum Color {
    RED("红色",1),GREEN("绿色",2),White("白色",3);
    private String name;
    private Integer index;

    Color(String name, Integer i) {
        this.name=name;
        this.index=i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
