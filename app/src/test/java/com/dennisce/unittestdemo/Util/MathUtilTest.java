package com.dennisce.unittestdemo.Util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dennis on 21/05/2017.
 * so.....
 */
public class MathUtilTest {
    MathUtil mMathUtil;
    @Before
    public void setUp(){
        mMathUtil=new MathUtil();
    }
    @Test
    public void add() throws Exception {
        int result=mMathUtil.add(1,3);
        Assert.assertEquals(result,4);
        int err=mMathUtil.add(999999999,999999999);
        Assert.assertEquals(err,1999999998);
    }

}