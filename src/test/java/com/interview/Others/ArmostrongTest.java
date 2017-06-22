package com.interview.Others;

import com.interview.armstrong.ArmstrongChecker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Mike on 2017-04-15.
 */
public class ArmostrongTest {

    ArmstrongChecker asCh;

    @Before
    public void setUp(){
        asCh = new ArmstrongChecker();
    }

    @After
    public void destroy(){
        asCh=null;
    }

    @Test
    public void disambleNumberTest(){

        List<Integer> list=asCh.disambleNumber(467);

        assertThat(list).contains(4);
        assertThat(list).contains(6);
        assertThat(list).contains(7);

    }

    @Test
    public void doMathTest(){

        Integer number = asCh.doMath(new ArrayList<>(Arrays.asList(1, 2, 3)));

        assertThat(number).isEqualTo(36);

    }

    @Test
    public void checkIfArmostrongTest(){

        assertThat(asCh.checkIfArmstrong(407)).isEqualTo(true);
        assertThat(asCh.checkIfArmstrong(153)).isEqualTo(true);
        assertThat(asCh.checkIfArmstrong(370)).isEqualTo(true);
        assertThat(asCh.checkIfArmstrong(574747132)).isEqualTo(false);

    }

    @Test
    public void checkIfArmostrongBigIntegerTest(){

        BigInteger number = new BigInteger("115132219018763992565095597973971522401");

        assertThat(asCh.checkIfArm(number)).isEqualTo(true);


    }

}
