package com.nodeforest

import com.nodeforest.impl.AVLNode
import org.junit.Assert
import org.junit.Test

class AVLNodeTest {

    @Test
    fun getValue() {
        val num = 4
        val node = AVLNode(num, null, null)
        Assert.assertEquals(num, node.getValue())
    }

    @Test
    fun setValue() {
        val num1 = 4
        val num2 = 3
        val node = AVLNode(num1, null, null)
        node.setValue(num2)
        Assert.assertEquals(num2, node.getValue())

    }

    @Test
    fun getLeftChildValue() {
        val numLeft = 3
        val numRoot = 5
        val leftChild = AVLNode(numLeft, null, null)
        val root = AVLNode(numRoot, null, null)
        root.setLeftChild(leftChild)
        Assert.assertEquals(leftChild, root.getLeftChild())


    }

    @Test
    fun getLeftChildNull() {
        val num = 3
        val root = AVLNode(num, null, null)
        Assert.assertEquals(null, root.getLeftChild())


    }

    @Test
    fun setLeftChildValue() {
        val numRoot = 5
        val numLeft = 3
        val leftChild = AVLNode(numLeft, null, null)
        val root = AVLNode(numRoot, null, null)
        root.setLeftChild(leftChild)
        Assert.assertEquals(leftChild, root.getLeftChild())
    }

    @Test
    fun setLeftChildNull() {
        val numRoot = 5
        val root = AVLNode(numRoot, null, null)
        root.setLeftChild(null)
        Assert.assertEquals(null, root.getLeftChild())
    }

    @Test
    fun getRightChildValue() {
        val numRight = 4
        val numRoot = 6
        val rightChild = AVLNode(numRight, null, null)
        val root = AVLNode(numRoot, null, null)
        root.setRightChild(rightChild)
        Assert.assertEquals(rightChild, root.getRightChild())
    }

    @Test
    fun getRightChildNull() {
        val num = 6
        val root = AVLNode(num, null, null)
        Assert.assertEquals(null, root.getRightChild())
    }

    @Test
    fun setRightChildValue() {
        val numRight = 4
        val numRoot = 6
        val rightChild = AVLNode(numRight, null, null)
        val root = AVLNode(numRoot, null, null)
        root.setRightChild(rightChild)
        Assert.assertEquals(rightChild, root.getRightChild())
    }

    @Test
    fun setRightChildNull() {
        val numRoot = 5
        val root = AVLNode(numRoot, null, null)
        root.setRightChild(null)
        Assert.assertEquals(null, root.getRightChild())
    }

     @Test
     fun getHeightValue(){
         val root = AVLNode(3, null, null)
         Assert.assertEquals(1, root.getHeight())
     }

    @Test
    fun setHeightValue(){
        val root = AVLNode(3, null, null)
        root.setHeight(10)
        Assert.assertEquals(10, root.getHeight())
    }
}