package cn.jjx.coding.leetcode.classification.aatest;

public class Father {
    public int field =0;
    private int getField(){
        return field;
    }

    public static void main(String[] args) {
        Father father = new Son();

        System.out.println(father.getField());
    }
}
