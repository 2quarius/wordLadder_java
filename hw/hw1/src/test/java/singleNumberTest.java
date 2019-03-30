//package test.;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
* singleNumber Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 6, 2019</pre> 
* @version 1.0 
*/ 
public class singleNumberTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String [] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...

} 


/** 
* 
* Method: helperFunc(ArrayList<Integer> array) 
* 
*/ 
@Test
public void testHelperFunc() throws Exception { 
//TODO: Test goes here...
    singleNumber single = new singleNumber();
    ArrayList<Integer> test1 = new ArrayList<Integer>();
    test1.add(3);
    test1.add(3);
    test1.add(8);
    test1.add(3);
    assertEquals(8,single.helperFunc(test1));
    ArrayList<Integer> test2 = new ArrayList<Integer>();
    test2.add(1);
    test2.add(2);
    test2.add(2);
    test2.add(1);
    test2.add(3);
    test2.add(1);
    test2.add(2);
    assertEquals(3,single.helperFunc(test2));
    ArrayList<Integer> test3 = new ArrayList<Integer>();
    test3.add(5);
    test3.add(8);
    test3.add(8);
    test3.add(5);
    test3.add(6);
    test3.add(8);
    test3.add(5);
    assertEquals(6,single.helperFunc(test3));
/* 
try { 
   Method method = singleNumber.getClass().getMethod("helperFunc", ArrayList<Integer>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
