package com.nodeforest

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class BinarySearchTreeImplTest {

    private lateinit var bst: BinarySearchTreeImpl<Int>

    @Before
    fun setUp() {
        bst = BinarySearchTreeImpl<Int>()
        bst.insert(5)
        bst.insert(3)
        bst.insert(7)

    }

    @Test
    fun getRootValue() {
        assertEquals(5, bst.getRootValue())
    }

    @Test
    fun contains() {
        assertEquals(true, bst.contains(5))
        assertEquals(true, bst.contains(3))
        assertEquals(true, bst.contains(7))
        assertEquals(false, bst.contains(0))
    }

    @Test
    fun insert() {
    }

    @Test
    fun remove() {
    }

    @Test
    fun hasLeftChild() {
        assertEquals(true, bst.hasLeftChild())
        assertEquals(false, bst.getLeftChild().hasLeftChild())
    }

    @Test
    fun getLeftChild() {
        val bstLeftChild = BinarySearchTreeImpl<Int>()
        bstLeftChild.insert(3)
        assertEquals(bstLeftChild, bst.getLeftChild())

    }

    @Test
    fun hasRightChild() {
        assertEquals(true, bst.hasRightChild())
        assertEquals(false, bst.getRightChild().hasRightChild())
    }

    @Test
    fun getRightChild() {
        val bstRightChild = BinarySearchTreeImpl<Int>()
        bstRightChild.insert(7)
        assertEquals(bstRightChild, bst.getRightChild())
    }

    @Test
    fun clear() {
        val aux = bst
        aux.clear()
        assertEquals(null, aux.getRootValue())
    }

    @Test
    fun isEmpty() {
        val empty = BinarySearchTreeImpl<Int>()
        assertEquals(false, bst.isEmpty())
        assertEquals(true, empty.isEmpty())


    }
}