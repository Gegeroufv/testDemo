package com.shibo.demo.testPojo;

/**
 * 使用delombok可以直接生成类
 */
public class testLomB {
    private String name;
    private Integer age;

    public testLomB() {
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof testLomB)) return false;
        final testLomB other = (testLomB) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$age = this.getAge();
        final Object other$age = other.getAge();
        if (this$age == null ? other$age != null : !this$age.equals(other$age)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof testLomB;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $age = this.getAge();
        result = result * PRIME + ($age == null ? 43 : $age.hashCode());
        return result;
    }

    public String toString() {
        return "testLomB(name=" + this.getName() + ", age=" + this.getAge() + ")";
    }
}
