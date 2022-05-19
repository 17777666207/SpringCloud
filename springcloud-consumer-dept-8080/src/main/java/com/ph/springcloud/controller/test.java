package com.ph.springcloud.controller;

public class test {



    public static void main(String[] args) {
        String a = null;

        if (a != null && a.equals("")){
            System.out.println("is coming");
        }
        System.out.println("is ok");

        // switch 是否可以使用string，byte,short
       String b = "c";

        switch (b){
            case "a":
                System.out.println("A");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("c");

        }

        short s = 1;
        int i  = 1;

        // 类强制转化
       Father father = new Son();

       Son son = new Son();
       son =(Son) father;

        System.out.println(father);
        System.out.println(son);

        Father father1 = new Father();

//        Son son1 = (Son) father1;
        Son son1 = new Son();
        son1.int01();

        // CHAR是否可以存储文字
        String s1 = "汉字";
        System.out.println(s1);

        char c = '字';
        System.out.println(c);

        //------ final
        final StringBuilder s2 =new StringBuilder("abc");
        s2.append("def");
        System.out.println("--------- final"+s2);

        final String s3="1230";
//        s3 = "123456";  // 报错
        System.out.println("--------- replace"+s3);


        //-------  == 和 equals

        String s4  = "123";
        String s5 = "123";
        String s6 =  new String("123");
        System.out.println(s4.equals(s5));
        System.out.println(s4 == s5);
        System.out.println(s6 == s5);
        System.out.println(s6.equals(s5) );

        Double d = new Double(42.0);
        Integer integer =new Integer(42);
        Long l = new Long(42);

        System.out.println("d&i"+integer.equals(d));
        System.out.println("d&i"+d.equals(integer));
        System.out.println(integer.equals(42));

        int i1 = 1;
        




    }
    static class Father{

    }
    public static class Son extends Father{
        public static void int01(){
            int i = 1;
            System.out.println("------"+i);
        }
    }

}
