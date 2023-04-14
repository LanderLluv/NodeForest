package com.nodeforest

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MaxHeapImplTest {

    private lateinit var heap: MaxHeapImpl<Int>

    /*
        7
       / \
      3   5
     */
    @Before
    fun setUp() {
        heap = MaxHeapImpl<Int>()
        heap.insert(5)
        heap.insert(3)
        heap.insert(7)
    }

    @Test
    fun isEmptyTrue(){
        val heapEmpty = MaxHeapImpl<Int>()
        assertEquals(true, heapEmpty.isEmpty())
    }

    @Test
    fun isEmptyFalse(){
        assertEquals(false, heap.isEmpty())
    }

    @Test
    fun removeMaxValueNull(){
        val heapEmpty = MaxHeapImpl<Int>()
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

    //El valor insertado se debe colocar como raiz
    @Test
    fun insertRoot(){
        heap.insert(11)
        assertEquals(11, heap.getMaxValue())
    }

    //El valor insertado no se debe colocar como raiz
    @Test
    fun insertNotRoot(){
        heap.insert(1)
        assertEquals(7, heap.removeMaxValue())
    }
}