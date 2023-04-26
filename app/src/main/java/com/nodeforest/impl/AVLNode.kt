package com.nodeforest.impl

class AVLNode<T : Comparable<T>>(_value: T, _leftChild: AVLNode<T>?, _rightChild: AVLNode<T>?) {
    private var value: T
    private var leftChild: AVLNode<T>?
    private var rightChild: AVLNode<T>?
    private var height: Int
    init{
        value = _value
        leftChild = _leftChild
        rightChild = _rightChild
        height = 1
    }

    fun getValue(): T {
        return value
    }

    fun setValue(_value: T){
        value = _value
    }

    fun getLeftChild(): AVLNode<T>?{
        return leftChild
    }

    fun setLeftChild(_leftChild: AVLNode<T>?){
        leftChild = _leftChild
    }

    fun getRightChild(): AVLNode<T>?{
        return rightChild
    }

    fun setRightChild(_rightChild: AVLNode<T>?){
        rightChild = _rightChild
    }

    fun getHeight(): Int{
        return height
    }

    fun setHeight(_height: Int){
        height = _height
    }
}