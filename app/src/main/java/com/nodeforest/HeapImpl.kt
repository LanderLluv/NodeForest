package com.nodeforest

import java.util.Collections

class HeapImpl<T: Comparable<T>> : Heap<T> {

    private var size: Int
    private var array: ArrayList<T?>

    init{
        size = 0
        array = ArrayList<T?>()
    }


    fun getArray(): ArrayList<T?>{
        return array
    }
    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun getMaxValue(): T? {
        if(isEmpty()){
            return null
        }else{
            return array[0]
        }

    }

    override fun removeMaxValue(): T? {
        if(isEmpty()){
           return null
        }else{
            Collections.swap(array, 0, size-1)
            val value = array.removeAt(size-1)
            size--
            checkDown(0)
            return value
        }
    }

    /*
    Dado un indice, elige el mejor candidato para esa posicion
     */
    private fun checkDown(index: Int){
        var parent = index
        var candidate = Int.MAX_VALUE
        while(true){
            val leftChildIndex = parent*2+1
            val rightChildIndex = parent*2+2
            candidate = parent
            if(leftChildIndex < size && array[leftChildIndex]!!.compareTo(array[candidate]!!) > 0){
                candidate = leftChildIndex
            }

            if(rightChildIndex < size && array[rightChildIndex]!!.compareTo(array[candidate]!!) > 0){
                candidate = rightChildIndex
            }

            if(candidate == parent){
                return
            }

            Collections.swap(array, parent, candidate)
            parent = candidate

        }
    }

    override fun clear() {
        array.clear()
        size = 0
    }

    override fun insert(value: T) {
        array.add(value)
        size++
        checkUp(size-1)

    }

    /*
    Dado un indice, comprueba el valor del padre y lo sube en caso de ser mayor
     */
    private fun checkUp(index: Int){
        var child = index
        var parent = (child-1)/2

        while(child > 0 && array[child]!!.compareTo(array[parent]!!) >  0){
            Collections.swap(array, child, parent)
            child = parent
            parent = (child-1)/2
        }
    }
}