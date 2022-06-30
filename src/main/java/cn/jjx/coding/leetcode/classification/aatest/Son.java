package cn.jjx.coding.leetcode.classification.aatest;

public class Son extends Father{
    public int field = 1;
    public int getFiled(){
        return field+100;
    }

    public static void main(String[] args) {
        Father father = new Father();
    }
}
