package com.nodeforest.activity

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