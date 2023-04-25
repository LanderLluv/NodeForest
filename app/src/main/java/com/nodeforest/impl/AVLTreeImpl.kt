package com.nodeforest.impl

import java.lang.Integer.max

class AVLTreeImpl<T : Comparable<T>> : AVLTree<T>{

    private var root: AVLNode<T>?

    init {
        root = null
    }

    fun getRoot(): AVLNode<T>? {
        return root
    }

    override fun insert(value: T) {
        root = insertNode(root, value)
    }

    private fun insertNode(node: AVLNode<T>?, value: T): AVLNode<T>? {
        if (node == null) {
            return AVLNode(value)
        }

        if (value < node.getValue()) {
            node.setLeftChild(insertNode(node.getLeftChild(), value))
        } else {
            node.setRightChild(insertNode(node.getRightChild(), value))
        }

        val newHeight = 1 + max(node.getLeftChild()?.getHeight() ?: 0, node.getRightChild()?.getHeight() ?: 0)
        node.setHeight(newHeight)
        val newBalance = getBalance(node)

        if (newBalance > 1 && value < node.getLeftChild()!!.getValue()) {
            return rightRotate(node)
        }

        if (newBalance < -1 && value > node.getRightChild()!!.getValue()) {
            return leftRotate(node)
        }

        if (newBalance > 1 && value > node.getLeftChild()!!.getValue()) {
            node.setLeftChild(leftRotate(node.getLeftChild()!!))
            return rightRotate(node)
        }

        if (newBalance < -1 && value < node.getRightChild()!!.getValue()) {
            node.setRightChild(rightRotate(node.getRightChild()!!))
            return leftRotate(node)
        }

        return node
    }

    override fun delete(value: T) {
        root = deleteNode(root, value)
    }

    private fun deleteNode(node: AVLNode<T>?, value: T): AVLNode<T>? {
        if (node == null) {
            return null
        }

        if (value < node.getValue()) {
            node.setLeftChild(deleteNode(node.getLeftChild(),value))
        } else if (value > node.getValue()) {
            node.setRightChild(deleteNode(node.getRightChild(), value))
        } else {
            if (node.getLeftChild() == null || node.getRightChild() == null) {
                val temp = node.getLeftChild() ?: node.getRightChild()
                if (temp == null) {
                    return null
                } else {
                    return temp
                }
            } else {
                val successor = getSuccessor(node.getRightChild()!!)
                node.setValue(successor.getValue())
                node.setRightChild(deleteNode(node.getRightChild(), successor.getValue()))
            }
        }

        if (node == null) {
            return null
        }

        val newHeight = 1 + max(node.getLeftChild()?.getHeight() ?: 0, node.getRightChild()?.getHeight() ?: 0)
        node.setHeight(newHeight)
        val balance = getBalance(node)

        if (balance > 1 && getBalance(node.getLeftChild()!!) >= 0) {
            return rightRotate(node)
        }

        if (balance > 1 && getBalance(node.getLeftChild()!!) < 0) {
            node.setLeftChild(leftRotate(node.getLeftChild()!!))
            return rightRotate(node)
        }

        if (balance < -1 && getBalance(node.getRightChild()!!) <= 0) {
            return leftRotate(node)
        }

        if (balance < -1 && getBalance(node.getRightChild()!!) > 0) {
            node.setRightChild(rightRotate(node.getRightChild()!!))
            return leftRotate(node)
        }

        return node
    }

    private fun getSuccessor(node: AVLNode<T>): AVLNode<T> {
        var current = node
        while (current.getLeftChild() != null) {
            current = current.getLeftChild()!!
        }
        return current
    }

    private fun getBalance(node: AVLNode<T>?): Int {
        val heightLeft = node?.getLeftChild()?.getHeight() ?: 0
        val heightRight = node?.getRightChild()?.getHeight() ?: 0
        return heightLeft - heightRight
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.getLeftChild()!!
        val rightGrandChild = leftChild.getRightChild()

        leftChild.setRightChild(node)
        node.setLeftChild(rightGrandChild)

        val newHeight = 1 + max(node.getLeftChild()?.getHeight() ?: 0, node.getRightChild()?.getHeight() ?: 0)
        node.setHeight(newHeight)
        val newHeightLeft = 1 + max(leftChild.getLeftChild()?.getHeight() ?: 0, leftChild.getRightChild()?.getHeight() ?: 0)
        leftChild.setHeight(newHeightLeft)

        return leftChild
    }

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.getRightChild()!!
        val leftGrandChild = rightChild.getLeftChild()

        rightChild.setLeftChild(node)
        node.setRightChild(leftGrandChild)

        val newHeight = 1 + max(node.getLeftChild()?.getHeight() ?: 0, node.getRightChild()?.getHeight() ?: 0)
        node.setHeight(newHeight)
        val newHeightRight = 1 + max(rightChild.getLeftChild()?.getHeight() ?: 0, rightChild.getRightChild()?.getHeight() ?: 0)
        rightChild.setHeight(newHeightRight)

        return rightChild
    }

}
