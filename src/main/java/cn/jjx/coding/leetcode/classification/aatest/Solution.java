package cn.jjx.coding.leetcode.classification.aatest;



public class Solution {



    public void test(){
        Sub sub = new Sub();
        Sub sub1 = new Suber();

        System.out.println(sub.getFiled());
        System.out.println(sub1.getFiled());
        System.out.println(sub.filed);


        Father father = new Father();
        Father father1 = new Son();

//        System.out.println(father1.getField());
//        System.out.println(father.getField());
    }


    public static void main(String[] args) {
        Sub sub = new Sub();
        Sub sub1 = new Suber();

        System.out.println(sub.getFiled());
        System.out.println(sub1.getFiled());
        Father father = new Father();
        Father father1 = new Son();
        System.out.println(father.field);



    }
}

class Sub{
    public int filed=0;
    public int getFiled(){
        return filed+100;
    }
    private static int xx(){
        return 111;
    }
}

class  Suber extends Sub{
    public int filed=1;
    public int getFiled(){
        return filed;
    }
}
