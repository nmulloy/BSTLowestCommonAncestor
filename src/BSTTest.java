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
     
     @Test	  	
	 public void testLca()
	{
		BST<Integer, Integer> BST = new BST<Integer, Integer>();  
		BST = new BST<Integer, Integer>();

		BST.put(7, 7);   //        _7_

		BST.put(8, 8);   //      /     \

		BST.put(3, 3);   //    _3_      8

		BST.put(1, 1);   //  /     \      \
											
		BST.put(2, 2);   // 1       6		_12_

		BST.put(6, 6);   //  \     /	   /   \

		BST.put(4, 4);   //   2   4		 11      13
		
		BST.put(12, 12);
		
		BST.put(11,11);
		
		BST.put(13, 13);
		
		assertEquals("Checking the LCA of root and left node","7", BST.lca(7,3));
		
		assertEquals("Checking the LCA of root and right node","7", BST.lca(7,8));
		
		assertEquals("Checking the LCA of 1 and 6","3", BST.lca(1,6)); // checks for standard lca of a subtree 

		assertEquals("Cheking the LCA of 1 and 2","1", BST.lca(1,2)); // if only 1 child return the parent
		
		assertEquals("Checking the LCA of 11 and 13", "12", BST.lca(11,13)); // checks rhs lca of a subtree
		
		assertEquals("Checking the LCA of 12 and 4", "7", BST.lca(12,4)); // checks rhs and lhs lca both of which are in subtrees
		
		
		BST = new BST<Integer, Integer>();
		BST.put(7, 7);
		BST.put(8, 8);
		
		assertEquals("Checking the LCA of a tree with one child", "7", BST.lca(8,7));
		
		
	} 
     @Test
 	public void testPutLCA()
 	{
 		BST<Integer, Integer> BST = new BST<Integer, Integer>();
 		
 		BST = new BST<Integer, Integer>();
 		
 		BST.put(7, 7);
 		assertNull("Checking the LCA of a tree with no children", BST.lca(7,7)); // passing in the root twice will return null
 		assertNull("Checking the LCA on a tree with one node", BST.lca(7,null)); // passing in null will return null also
 		
 		BST = new BST<Integer, Integer>();
 		
 		BST.put(null, 1);
 		assertEquals("Testing when null key and valid value inserted", 0, BST.size());
 		
 		BST.put(1, null);
 		assertEquals("Testing when valid key and null value inserted", 0, BST.size());

 		BST.put(7, 7);   //        _7_
         BST.put(7, 8);   //        _7_
         assertEquals("Check if code properly insert nodes based upon key", 1, BST.size()); // size is one and not 2 despite two puts as keys are the same
        
         BST = new BST<Integer, Integer>();
  		BST.put(7, 7);
  		BST.put(10, 10);
  		BST.put(12, 12);
  		BST.put(6, 6);
  		BST.put(3, 3);
  		BST.put(5, 5);
  	
  		assertNull("Checking LCA of a node that is not present", BST.lca(4, 6));
  		assertNull("Checking LCA of two nodes that are not present", BST.lca(4, 2));
  		
      	BST = new BST<Integer, Integer>();
          BST.put(7, 7);   //        _7_
          BST.put(8, 8);   //      /     \
          BST.put(3, 3);   //    _3_      8
          BST.put(1, 1);   //  /     \
          BST.put(2, 2);   // 1       6
          BST.put(6, 6);   //  \     /
          BST.put(4, 4);   //   2   4
          BST.put(5, 5);   //  /     \
                           //         5
          assertEquals("Check if the nodes are inserted in the correct order", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BST.printKeysInOrder());
 		
 	}
    
     @Test
 	public void testLcaNegative()
 	{
 		BST<Integer, Integer> BST = new BST<Integer, Integer>();  
 		BST = new BST<Integer, Integer>();

 		BST.put(7, 7);  
 		BST.put(-8, -8);   
 		BST.put(-6, -6);
 		BST.put(-9, -9);   
 		BST.put(10, 10);
 		
 		assertEquals("Checking the lca of negative nodes", "-8", BST.lca(-6, -9));
 		
 		assertEquals("Checking the lca of a negative node and a positive node", "7", BST.lca(10, -9));
 		
 	}
}
