import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  @Test
  public void testPut(){
	   BST<Integer, Integer> bst = new BST<Integer, Integer>();
       bst.put(7, null);
       assertNull("Check that the value put into the tree is null", bst.get(7));
        
       bst = new BST<Integer, Integer>();
						       //  -7
						       //   |-3
						       //   | |-1
						       //   | | |-null
       bst.put(7, 7);          //   | |  -2
	   bst.put(8, 8);          //   | |   |-null
	   bst.put(3, 3);          //   | |    -null
	   bst.put(1, 1);          //   |  -6
	   bst.put(2, 2);          //   |   |-4
	   bst.put(6, 6);          //   |   | |-null
       bst.put(4, 4);          //   |   |  -5
	   bst.put(5, 5);          //   |   |   |-null
						       //   |   |    -null
						       //   |    -null
						       //    -8
						       //     |-null
						       //      -null
      
	   assertEquals("Check the right", "8", "" + bst.get(8));
       assertEquals("Check the left", "3", "" + bst.get(3));
      
       assertEquals("Check the root ", "7", "" + bst.get(7));
        
       bst = new BST<Integer, Integer>();
       bst.put(7, null);
       assertNull("putting in a null key", bst.get(7));
        
       bst = new BST<Integer, Integer>();
       bst.put(7, 7);
       bst.put(7, 7);
       assertEquals("Putting in the same value again", Integer.valueOf(7), bst.get(7));
  }
  @Test
  public void testGet(){
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertNull("Checking empty tree, expect null", bst.get(7));
	  bst.put(7, 7);
	  bst.put(8, 8);       
	  bst.put(3, 3);
	  bst.put(1, 1);
	  assertNull("Checking tree for incorrect value", bst.get(10));
	  assertEquals("Checking tree for left value", Integer.valueOf(3), bst.get(3));
	  assertEquals("Checking tree for right value", Integer.valueOf(8), bst.get(8));
	  
  }
  @Test
  public void testContains(){
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertFalse("Checking empty tree", bst.contains(7));
	  bst.put(7, 7);
	  bst.put(8, 8);       
	  bst.put(3, 3);
	  assertFalse("Checking for incorrect key in binary tree with keys", bst.contains(10));
	  assertTrue("Checking for correct key in binary tree with keys", bst.contains(7));
  }

  @Test
  public void testHeight(){
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  int negativeOne = -1;
	  assertEquals("Checking the height of an empty tree",negativeOne, bst.height());
	  bst.put(7, 7);
	  int zero = 0;
	  assertEquals("Checking the height of a tree with a single node", zero, bst.height());
	  
	  				   //	        _7_
      bst.put(8, 8);   //1	      /     \
      bst.put(3, 3);   //	    _3_      8
      bst.put(1, 1);   //2	  /     \
      bst.put(2, 2);   //	 1       6
      bst.put(6, 6);   //3 	  \     /
      bst.put(4, 4);   //	   2   4
      bst.put(5, 5);   //4	        \
                       //	         5
      
      int expectedAnswer = 4;
      assertEquals("Checking the height of a tree with 5 nodes", expectedAnswer, bst.height());
  }

  @Test
  public void testMedian(){
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertNull("Checking empty tree", bst.median());
	  bst.put(7, 7);
	  assertEquals("Checking tree with single value",Integer.valueOf(7),bst.median());
      					   //  -7
					       //   |-3
					       //   | |-1
					       //   | | |-null
	  					   //   | |  -2
	  bst.put(8, 8);       //   | |   |-null
	  bst.put(3, 3);       //   | |    -null
	  bst.put(1, 1);       //   |  -6
	  bst.put(2, 2);       //   |   |-4
	  bst.put(6, 6);       //   |   | |-null
	  bst.put(4, 4);       //   |   |  -5
	  bst.put(5, 5);       //   |   |   |-null
					       //   |   |    -null
					       //   |    -null
					       //    -8
					       //     |-null
					       //      -null
	  assertEquals("Checking a tree with  values", Integer.valueOf(4), bst.median());
  }
  
  @Test
  public void testPrintKeysInOrder(){
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	     assertEquals("Checking printing in order of empty tree", "()", bst.printKeysInOrder());
	     
	     bst.put(7, 7);
	     
	     assertEquals("Checking printing in order with single node ", "(()7())", bst.printKeysInOrder());
	     
	     bst.put(8, 8);
	     
	     assertEquals("Checking printing in order with node on the right ", "(()7(()8()))", bst.printKeysInOrder());
	     
	     bst = new BST<Integer, Integer>();
	     bst.put(7, 7);
	     bst.put(3, 3);
	     
	     assertEquals("Checking printing in order with node on the left ", "((()3())7())", bst.printKeysInOrder());
	     
	     				  //        _7_
            			  //      /     \
	     bst.put(8, 8);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
	     assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	     
  }
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     
    
}
