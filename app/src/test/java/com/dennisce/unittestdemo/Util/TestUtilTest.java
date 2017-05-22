package com.dennisce.unittestdemo.Util;

import com.dennisce.unittestdemo.entity.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dennis on 21/05/2017.
 * so.....
 */
public class TestUtilTest {
    @Spy
    TestUtil mTestUtil;

    @Mock
    TestUtil testUtilMock;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockShow(){
        //mock数据
        Mockito.when(testUtilMock.add(1,3)).thenReturn(5);
        //验证mock结果
        int resultMock= testUtilMock.add(1,3);
        Assert.assertEquals(resultMock,5);
        //验证mock是否调用(1,5)
        Mockito.verify(testUtilMock).add(1,5);
        //验证mock是否调用
        Mockito.verify(testUtilMock).add(Mockito.anyInt(),Mockito.anyInt());
        //验证次数
        Mockito.verify(testUtilMock,Mockito.times(2)).add(Mockito.anyInt(),Mockito.anyInt());
    }

    @Test
    public void add() throws Exception {
        int result=mTestUtil.add(1,3);
        Assert.assertEquals(result,4);
    }

    @Test
    public void equalsObject() throws Exception {
        String a="abc";
        String b="abc";
        String c=new String("abc");
        Assert.assertEquals(true,mTestUtil.equalsObject(a,b));
        Assert.assertEquals(true,mTestUtil.equalsObject(a,c));
    }
}