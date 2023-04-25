package com.nodeforest

import com.nodeforest.impl.AVLTreeImpl
import com.nodeforest.impl.BinarySearchTreeImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AVLTreeImplTest {

    private lateinit var avltree : AVLTreeImpl<Int>

    /*
        50
       / \
      10   100
     */
    @Before
    fun setUp() {
        avltree = AVLTreeImpl<Int>()
        avltree.insert(10)
        avltree.insert(100)
        avltree.insert(50)

    }

    /*
            50
           / \
          5   100
         / \
        5  25
     */
    @Test
    fun insertNoBalanceLeft(){
        avltree.insert(5)
        avltree.insert(25)
        val leftChild = avltree.getRoot()!!.getLeftChild()
        assertEquals(10, leftChild!!.getValue())
        assertEquals(5, leftChild.getLeftChild()!!.getValue())
        assertEquals(25, leftChild.getRightChild()!!.getValue())
    }

    /*
            50
           / \
          5   100
         / \
        3  10
     */
    @Test
    fun insertBalanceLeft(){
        avltree.insert(3)
        avltree.insert(5)
        val leftChild = avltree.getRoot()!!.getLeftChild()
        assertEquals(5, leftChild!!.getValue())
        assertEquals(3, leftChild.getLeftChild()!!.getValue())
        assertEquals(10, leftChild.getRightChild()!!.getValue())
    }

    /*
           50
          / \
         5   100
            /  \
           75  125
    */
    @Test
    fun insertNoBalanceRight(){
        avltree.insert(75)
        avltree.insert(125)
        val rightChild = avltree.getRoot()!!.getRightChild()
        assertEquals(100, rightChild!!.getValue())
        assertEquals(75, rightChild.getLeftChild()!!.getValue())
        assertEquals(125, rightChild.getRightChild()!!.getValue())
    }
    /*
            50
           / \
          5   68
             / \
            55 100
     */
    @Test
    fun insertBalanceRight(){
        avltree.insert(55)
        avltree.insert(68)
        val rightChild = avltree.getRoot()!!.getRightChild()
        assertEquals(68, rightChild!!.getValue())
        assertEquals(55, rightChild.getLeftChild()!!.getValue())
        assertEquals(100, rightChild.getRightChild()!!.getValue())
    }

    /*
            22
           / \
          10   50
         / \    \
        1   21  100
     */
    @Test
    fun insertBalanceRoot(){
        avltree.insert(1)
        avltree.insert(22)
        //Produce desequilibrio
        avltree.insert(21)

        assertEquals(22, avltree.getRoot()!!.getValue())
        assertEquals(10, avltree.getRoot()!!.getLeftChild()!!.getValue())
        assertEquals(50, avltree.getRoot()!!.getRightChild()!!.getValue())
        assertEquals(1, avltree.getRoot()!!.getLeftChild()!!.getLeftChild()!!.getValue())
        assertEquals(21, avltree.getRoot()!!.getLeftChild()!!.getRightChild()!!.getValue())
        assertEquals(100, avltree.getRoot()!!.getRightChild()!!.getRightChild()!!.getValue())


    }

    /*
            50
           / \
          22   100
         /
        1
     */
    @Test
    fun deleteNoBalanceLeft(){
        avltree.insert(1)
        avltree.insert(22)
        avltree.delete(10)
        val leftChild = avltree.getRoot()!!.getLeftChild()
        assertEquals(22, leftChild!!.getValue())
        assertEquals(1, leftChild!!.getLeftChild()!!.getValue())
    }

    /*
            50
           /  \
          10  125
               /
              75
     */
    @Test
    fun deleteNoBalaceRight(){
        avltree.insert(75)
        avltree.insert(125)
        avltree.delete(100)
        val rightChild = avltree.getRoot()!!.getRightChild()
        assertEquals(125, rightChild!!.getValue())
        assertEquals(75, rightChild!!.getLeftChild()!!.getValue())
    }

    /*
            75
           /  \
          10  100
         / \    \
        1  25   125

     */
    @Test
    fun deleteRoot(){
        avltree.insert(1)
        avltree.insert(25)
        avltree.insert(75)
        avltree.insert(125)
        avltree.delete(50)
        assertEquals(75, avltree.getRoot()!!.getValue())
        assertEquals(10, avltree.getRoot()!!.getLeftChild()!!.getValue())
        assertEquals(100, avltree.getRoot()!!.getRightChild()!!.getValue())
        assertEquals(1, avltree.getRoot()!!.getLeftChild()!!.getLeftChild()!!.getValue())
        assertEquals(25, avltree.getRoot()!!.getLeftChild()!!.getRightChild()!!.getValue())
        assertEquals(125, avltree.getRoot()!!.getRightChild()!!.getRightChild()!!.getValue())
    }

    //TODO: añadir mas test para desequilibrios
}