package bst;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import bst.BinarySearchTree;


 class BSTTest {
    private BinarySearchTree<Integer> bt1;

    @BeforeEach
     void setUp(){
        bt1=new BinarySearchTree<Integer>();
        //BinarySearchTree bt2= new BinarySearchTree<>(null);


    }

    @AfterEach
      void tearDown(){
        bt1=null;

    }
    @Test
     void testEmpty(){
       assertEquals(0, bt1.size(),"Tree is not empty");
    }

    @Test
     public void testHeight(){
        
    }
    @Test
     public void testAdd(){
            bt1.add(10);
            bt1.add(12);
            bt1.add(9);
            

        
        

    }
    @Test
     public void testSize(){
        bt1.add(12);
        bt1.add(10);
        assertEquals(2,bt1.size(),"Wrong size");
        

    }
   
    @Test
    public void testClear(){
        bt1.add(12);
        bt1.add(13);
        assertEquals(2, bt1.height());
        bt1.clear();
        assertEquals(0, bt1.height());


    }
    
}
