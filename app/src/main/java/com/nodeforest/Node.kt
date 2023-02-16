package com.nodeforest

class Node<T : Comparable<T>>(_value: T, _leftChild: Node<T>?, _rightChild: Node<T>?) {

    private var value: T
    private var leftChild: Node<T>?
    private var rightChild: Node<T>?
    init{
        value = _value
        leftChild = _leftChild
        rightChild = _rightChild
    }

    fun getValue(): T {
        return value
    }

    fun setValue(_value: T){
        value = _value
    }

    fun getLeftChild(): Node<T>?{
        return leftChild
    }

    fun setLeftChild(_leftChild: Node<T>?){
        leftChild = _leftChild
    }

    fun getRightChild(): Node<T>?{
        return rightChild
    }

    fun setRightChild(_rightChild: Node<T>?){
        rightChild = _rightChild
    }
}

fun main(args: Array<String>){
    val prueba1 = Node(3,null,null)
    val prueba2 = Node(6,null,null)
    val prueba3 = Node(5,prueba1,prueba2)

    println(prueba3.getValue().toString())
    println(prueba3.getLeftChild()?.getValue().toString())
    println(prueba3.getRightChild()?.getValue().toString())
    println(prueba1.getLeftChild() == null)
    println(prueba2.getRightChild() == null)


}