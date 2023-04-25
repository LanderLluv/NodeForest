package com.nodeforest.impl

interface AVLTree<T : Comparable<T>> {
    fun insert(value: T)

    fun delete(value: T)
}