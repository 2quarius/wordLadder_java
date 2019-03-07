//package test.;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.assertNotEquals;

/** 
* wordLadder Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 7, 2019</pre> 
* @version 1.0 
*/ 
public class wordLadderTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...
    wordLadder object = new wordLadder();
    object.start = "hello";
    object.dest = "world";
    object.main();
} 

/** 
* 
* Method: read_english() 
* 
*/ 
@Test
public void testRead_english() throws Exception { 
//TODO: Test goes here...
    wordLadder object = new wordLadder();
    object.read_english();
    assertNotEquals(0,object.english.size());
}

/** 
* 
* Method: input_words() 
* 
*/ 
@Test
public void testInput_words() throws Exception { 
//TODO: Test goes here...
}

/** 
* 
* Method: show_ans(ArrayList<String> ans) 
* 
*/ 
@Test
public void testShow_ans() throws Exception { 
//TODO: Test goes here... 
} 


} 
