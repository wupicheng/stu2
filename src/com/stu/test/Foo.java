package com.stu.test;

import com.jcabi.aspects.Loggable;

/**
 * Created with IntelliJ IDEA.
 * User: wupicheng
 * Date: 15-6-1
 * Time: 下午5:33
 * To change this template use File | Settings | File Templates.
 */
public class Foo {

    @Loggable
    public static double pow(int a, int b){
        return Math.pow(a,b);
    }

    public static void main(String[] args) {
        Foo.pow(2,3);
    }
}
