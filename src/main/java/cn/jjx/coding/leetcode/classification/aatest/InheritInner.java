package cn.jjx.coding.leetcode.classification.aatest;

public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner withInner){
        withInner.super();

    };

    public static void main(String[] args) {

        WithInner withInner = new WithInner(1);
        InheritInner ii = new InheritInner(withInner);

    }
}

class WithInner{
    WithInner(Integer a){

    }
    class Inner{}
}
