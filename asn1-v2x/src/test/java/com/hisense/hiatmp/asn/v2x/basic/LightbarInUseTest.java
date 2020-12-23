package com.hisense.hiatmp.asn.v2x.basic;

import net.gcdc.asn1.uper.UperEncoder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * LightbarInUse Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/15/2020</pre>
 */
public class LightbarInUseTest {
    LightbarInUse lightbarInUse = LightbarInUse.arrowSignsActive;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void encode() throws Exception {
        final byte[] encode = UperEncoder.encode(lightbarInUse);
        System.out.println(Arrays.toString(encode));
    }

    @Test
    public void decode() throws Exception {
    }

    /**
     * Method: getValue()
     */
    @Test
    public void testGetValue() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: toString()
     */
    @Test
    public void testToString() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: values()
     */
    @Test
    public void testValues() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: valueOf(java.lang.String name)
     */
    @Test
    public void testValueOf() throws Exception {
//TODO: Test goes here... 
    }


} 
