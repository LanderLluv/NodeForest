package com.nodeforest

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class HeapImplTest {

    private lateinit var heap: HeapImpl<Int>

    /*
        7
       / \
      3   5
     */
    @Before
    fun setUp() {
        heap = HeapImpl<Int>()
        heap.insert(5)
        heap.insert(3)
        heap.insert(7)
        println("bp")
    }

    @Test
    fun isEmptyTrue(){
        val heapEmpty = HeapImpl<Int>()
        assertEquals(true, heapEmpty.isEmpty())
    }

    @Test
    fun isEmptyFalse(){
        assertEquals(false, heap.isEmpty())
    }

    @Test
    fun removeMaxValueNull(){
        val heapEmpty = HeapImpl<Int>()
        assertEquals(null, heapEmpty.removeMaxValue())
    }

    @Test
    fun removeMaxValue(){
        assertEquals(7, heap.removeMaxValue())
    }

    @Test
    fun clear(){
        heap.clear()
        assertEquals(true, heap.isEmpty())
    }

    @Test
    fun insert(){
        heap.insert(11)
        assertEquals(11, heap.getMaxValue())
    }
}