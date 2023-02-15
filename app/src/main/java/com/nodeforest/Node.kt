package com.nodeforest

class Node<Int>(_value: Int, _leftChild: Node<Int>?, _rightChild: Node<Int>?) {
    private var value = _value
    private var leftChild = _leftChild
    private var rightChild = _rightChild


    fun getValue(): Int {
        return value
    }

    fun setValue(_value: Int){
        value = _value
    }

    fun getLeftChild(): Node<Int>?{
        return leftChild
    }

    fun setLeftChild(_leftChild: Node<Int>?){
        leftChild = _leftChild
    }

    fun getRightChild(): Node<Int>?{
        return rightChild
    }

    fun setRightChild(_rightChild: Node<Int>?){
        rightChild = _rightChild
    }
}

fun main(args: Array<String>){
    val prueba1 = Node<Int>(3,null,null)
    val prueba2 = Node<Int>(6,null,null)
    val prueba3 = Node<Int>(5,prueba1,prueba2)

    println(prueba3.getValue().toString())
    println(prueba3.getLeftChild()?.getValue().toString())
    println(prueba3.getRightChild()?.getValue().toString())


}