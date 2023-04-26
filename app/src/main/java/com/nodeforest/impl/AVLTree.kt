package com.nodeforest.impl

interface AVLTree<T : Comparable<T>> {

    fun contains(value: T): Boolean
    fun insert(value: T)

    fun delete(value: T)

    fun getLeftChild(): AVLTreeImpl<T>

    fun getRightChild(): AVLTreeImpl<T>

    fun clear()

    fun isEmpty(): Boolean

}