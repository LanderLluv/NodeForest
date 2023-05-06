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

    @Test
    fun containsTrue(){
        assertEquals(true, avltree.contains(10))
    }

    @Test
    fun containsFalse(){
        assertEquals(false, avltree.contains(11))
    }

    @Test
    fun clear() {
        val aux = avltree
        aux.clear()
        assertEquals(null, aux.getRoot()?.getValue())
    }

    @Test
    fun isEmptyTrue() {
        val empty = AVLTreeImpl<Int>()
        assertEquals(true, empty.isEmpty())
    }

    @Test
    fun isEmptyFalse() {
        assertEquals(false, avltree.isEmpty())
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

    @Test
    fun insertBalanceLeftLeft(){
        val newAVL = AVLTreeImpl<Int>()
        newAVL.insert(70)
        newAVL.insert(67)
        newAVL.insert(86)
        newAVL.insert(65)
        newAVL.insert(69)
        newAVL.insert(73)
        newAVL.insert(93)
        newAVL.insert(25)
        newAVL.insert(66)
        newAVL.insert(68)
        //Desequilibrio izquieda izquierda
        newAVL.insert(47)
        assertEquals(67, newAVL.getRoot()!!.getValue())
        assertEquals(65, newAVL.getLeftChild().getRoot()!!.getValue())
        assertEquals(70, newAVL.getRightChild().getRoot()!!.getValue())
    }

    @Test
    fun insertBalanceRightRight(){
        val newAVL = AVLTreeImpl<Int>()
        newAVL.insert(70)
        newAVL.insert(67)
        newAVL.insert(86)
        newAVL.insert(65)
        newAVL.insert(69)
        newAVL.insert(93)
        newAVL.insert(25)
        newAVL.insert(66)
        newAVL.insert(68)
        //Desequilibrio derecha derecha
        newAVL.insert(99)
        val rightChild = newAVL.getRightChild()
        assertEquals(93, rightChild.getRoot()!!.getValue())
        assertEquals(86, rightChild.getLeftChild().getRoot()!!.getValue())
        assertEquals(99, rightChild.getRightChild().getRoot()!!.getValue())
    }

    @Test
    fun insertBalanceLeftRight(){
        val newAVL = AVLTreeImpl<Int>()
        newAVL.insert(50)
        newAVL.insert(23)
        newAVL.insert(70)
        newAVL.insert(10)
        newAVL.insert(45)
        //Desequilibrio izquierda derecha
        newAVL.insert(30)
        assertEquals(45, newAVL.getRoot()!!.getValue())
        assertEquals(23, newAVL.getLeftChild().getRoot()!!.getValue())
        assertEquals(50, newAVL.getRightChild().getRoot()!!.getValue())
    }

    @Test
    fun insertBalanceRightLeft(){
        val newAVL = AVLTreeImpl<Int>()
        newAVL.insert(50)
        newAVL.insert(23)
        newAVL.insert(70)
        newAVL.insert(65)
        newAVL.insert(82)
        //Desequilibrio izquierda derecha
        newAVL.insert(68)
        assertEquals(65, newAVL.getRoot()!!.getValue())
        assertEquals(50, newAVL.getLeftChild().getRoot()!!.getValue())
        assertEquals(70, newAVL.getRightChild().getRoot()!!.getValue())
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

    @Test
    fun deleteDoubleBalance(){
        val newAVL = AVLTreeImpl<Int>()
        newAVL.insert(80)
        newAVL.insert(75)
        newAVL.insert(86)
        newAVL.insert(65)
        newAVL.insert(79)
        newAVL.insert(83)
        newAVL.insert(93)
        newAVL.insert(25)
        newAVL.insert(68)
        newAVL.insert(78)
        newAVL.insert(90)
        newAVL.insert(66)
        newAVL.insert(70)
        newAVL.delete(83)
        assertEquals(75, newAVL.getRoot()!!.getValue())
        assertEquals(65, newAVL.getLeftChild().getRoot()!!.getValue())
        assertEquals(80, newAVL.getRightChild().getRoot()!!.getValue())
    }

}