package com.nodeforest

class HeapImpl<T: Comparable<T>> : Heap<T> {

    private var size: Int
    private var array: ArrayList<T?>

    init{
        size = 0
        array = ArrayList<T?>()
    }


    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun getMaxValue(): T? {
        if(isEmpty()){
            return null
        }else{
            return array[1]
        }

    }

    override fun removeMaxValue(): T? {
        if(isEmpty()){
           return null
        }else{
            val value = this.getMaxValue()
            array[1] = array[size]
            array[size--] = null
            sink(1)
            return value
        }
    }

    private fun sink(hollow: Int){
        var hollowCopy = hollow
        val valueInHollow = array[hollowCopy]

        var child = hollowCopy*2
        var end = false

        while(child <= size && !end){
            val childValue = array[child]
            val nextChildValue = array[child+1]

            if(child < size && nextChildValue!!.compareTo(childValue!!) > 0){
                child++
            }
            if(childValue!!.compareTo(valueInHollow!!) > 0){
                array[hollowCopy] = childValue
                hollowCopy = child
                child = hollowCopy*2
            }else{
                end = true
            }
        }
        array[hollowCopy] = valueInHollow
    }

    override fun clear() {
        for(i in array.indices){
            array[i] = null
        }
        size = 0
    }

    override fun add(value: T) {
        var hollow = ++size
        val parentValue = array[hollow/2]

        while(hollow > 0 && parentValue!!.compareTo(value) < 0){
            array[hollow] = parentValue
            hollow /= 2
        }
        array[hollow] = value
    }
}