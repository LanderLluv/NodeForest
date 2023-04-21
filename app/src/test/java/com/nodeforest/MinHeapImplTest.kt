package com.nodeforest

import com.nodeforest.impl.MinHeapImpl
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MinHeapImplTest {

    private lateinit var heap: MinHeapImpl<Int>

    /*
        3
       / \
      7   5
     */
    @Before
    fun setUp() {
        heap = MinHeapImpl<Int>()
        heap.insert(5)
        heap.insert(3)
        heap.insert(7)
    }

    @Test
    fun isEmptyTrue(){
        val heapEmpty = MinHeapImpl<Int>()
        assertEquals(true, heapEmpty.isEmpty())
    }

    @Test
    fun isEmptyFalse(){
        assertEquals(false, heap.isEmpty())
    }

    @Test
    fun removeMinValueNull(){
        val heapEmpty = MinHeapImpl<Int>()
        assertEquals(null, heapEmpty.removeMinValue())
    }

    @Test
    fun removeMinValue(){
        assertEquals(3, heap.removeMinValue())
    }

    @Test
    fun clear(){
        heap.clear()
        assertEquals(true, heap.isEmpty())
    }

    //El valor insertado se debe colocar como raiz
    @Test
    fun insertRoot(){
        heap.insert(1)
        assertEquals(1, heap.getMinValue())
    }

    //El valor insertado no se debe colocar como raiz
    @Test
    fun insertNotRoot(){
        heap.insert(11)
        assertEquals(3, heap.removeMinValue())
    }
}