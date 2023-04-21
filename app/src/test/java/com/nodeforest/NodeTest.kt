package com.nodeforest

import com.nodeforest.impl.Node
import org.junit.Assert.*

import org.junit.Test

class NodeTest {

    @Test
    fun getValue() {
        val num = 4
        val node = Node(num, null, null)
        assertEquals(num, node.getValue())
    }

    @Test
    fun setValue() {
        val num1 = 4
        val num2 = 3
        val node = Node(num1,null,null)
        node.setValue(num2)
        assertEquals(num2, node.getValue())

    }

    @Test
    fun getLeftChildValue() {
        val numLeft = 3
        val numRoot = 5
        val leftChild = Node(numLeft,null,null)
        val root = Node(numRoot, leftChild,null)
        assertEquals(leftChild, root.getLeftChild())


    }

    @Test
    fun getLeftChildNull() {
        val num = 3
        val root = Node(num, null,null)
        assertEquals(null, root.getLeftChild())


    }

    @Test
    fun setLeftChildValue() {
        val numLeft = 3
        val numRoot = 5
        val leftChild = Node(numLeft,null,null)
        val root = Node(numRoot, leftChild,null)
        val newLeftChild = Node(numRoot, null, null)
        root.setLeftChild(newLeftChild)
        assertEquals(newLeftChild, root.getLeftChild())
    }

    @Test
    fun setLeftChildNull() {
        val numLeft = 3
        val numRoot = 5
        val leftChild = Node(numLeft,null,null)
        val root = Node(numRoot, leftChild,null)
        root.setLeftChild(null)
        assertEquals(null, root.getLeftChild())
    }

    @Test
    fun getRightChildValue() {
        val numRight = 4
        val numRoot = 6
        val rightChild = Node(numRight,null,null)
        val root = Node(numRoot, null,rightChild)
        assertEquals(rightChild, root.getRightChild())
    }

    @Test
    fun getRightChildNull() {
        val num = 6
        val root = Node(num, null,null)
        assertEquals(null, root.getRightChild())
    }

    @Test
    fun setRightChildValue() {
        val numRight = 4
        val numRoot = 6
        val rightChild = Node(numRight,null,null)
        val root = Node(numRoot, null,rightChild)
        val newRightChild = Node(numRoot, null, null)
        root.setRightChild(newRightChild)
        assertEquals(newRightChild, root.getRightChild())
    }

    @Test
    fun setRightChildNull() {
        val numRight = 3
        val numRoot = 5
        val rightChild = Node(numRight,null,null)
        val root = Node(numRoot, null,rightChild)
        root.setRightChild(null)
        assertEquals(null, root.getRightChild())
    }
}