package com.nodeforest

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class BinarySearchTreeImplTest {

    private lateinit var bst: BinarySearchTreeImpl<Int>

    /*
        5
       / \
      3   7
     */
    @Before
    fun setUp() {
        bst = BinarySearchTreeImpl<Int>()
        bst.insert(5)
        bst.insert(3)
        bst.insert(7)

    }

    @Test
    fun getRootValue() {
        assertEquals(5, bst.getRootValue())
    }

    @Test
    fun getRootValueNull() {
        val empty = BinarySearchTreeImpl<Int>()
        assertEquals(null, empty.getRootValue())
    }

    @Test
    fun containsTrue() {
        assertEquals(true, bst.contains(5))
        assertEquals(true, bst.contains(3))
        assertEquals(true, bst.contains(7))
    }

    @Test
    fun containsFalse() {
        assertEquals(false, bst.contains(0))
    }

    //Los insert se comprueban asi temporalmente,
    //en un futuro se podrian hacer con un recorrido
    @Test
    fun insertNull() {
        val empty = BinarySearchTreeImpl<Int>()
        empty.insert(3)
        assertEquals(3,empty.getRootValue())
    }

    @Test
    fun insertLower() {
        val empty = BinarySearchTreeImpl<Int>()
        empty.insert(3)
        empty.insert(1)
        assertEquals(1,empty.getLeftChild()?.getRootValue())

    }

    @Test
    fun insertBigger() {
        val empty = BinarySearchTreeImpl<Int>()
        empty.insert(3)
        empty.insert(4)
        assertEquals(4,empty.getRightChild().getRootValue())
    }

    @Test
    fun insertEqualsRoot() {
        val empty = BinarySearchTreeImpl<Int>()
        empty.insert(3)
        empty.insert(3)
        assertEquals(3,empty.getRightChild().getRootValue())

    }

    @Test
    fun removeLeaf(){
        bst.remove(3)
        assertEquals(null, bst.getLeftChild()?.getRootValue())
    }

    @Test
    fun removeOneChild() {
        //Añadimos el 1, hijo izquierdo del nodo 3
        bst.insert(1)
        bst.remove(3)
        assertEquals(1,bst.getLeftChild()?.getRootValue())
    }

    @Test
    fun removeTwoChild() {
        //Eliminamos la raiz, sube el hijo derecho(7)
        bst.remove(5)
        assertEquals(7,bst.getRootValue())

    }

    @Test
    fun removeNotFound() {
        //Guardamos el valor de bst antes de la eliminacion "falsa"
        val temp = bst
        bst.remove(33)
        assertEquals(true, temp.isSameTree(bst))

    }

    @Test
    fun hasLeftChildTrue() {
        assertEquals(true, bst.hasLeftChild())
    }

    @Test
    fun hasLeftChildFalse() {
        assertEquals(false, bst.getLeftChild()?.hasLeftChild())
    }

    /*
    Creamos un arbol igual al subarbol izquierdo del original
     */
    @Test
    fun getLeftChildTrue() {
        bst.insert(1)
        bst.insert(4)
        val bstLeftChild = BinarySearchTreeImpl<Int>()
        bstLeftChild.insert(3)
        bstLeftChild.insert(1)
        bstLeftChild.insert(4)
        assertEquals(true, bst.getLeftChild()?.isSameTree(bstLeftChild))

    }

    /*
    Creamos un arbol distinto al subarbol izquierdo del original
     */
    @Test
    fun getLeftChildFalse() {
        bst.insert(1)
        bst.insert(4)
        val bstLeftChild = BinarySearchTreeImpl<Int>()
        bstLeftChild.insert(1)
        bstLeftChild.insert(4)
        bstLeftChild.insert(3)
        assertEquals(false, bst.getLeftChild()?.isSameTree(bstLeftChild))

    }

    @Test
    fun hasRightChildTrue() {
        assertEquals(true, bst.hasRightChild())

    }

    @Test
    fun hasRightChildFalse() {
        assertEquals(false, bst.getRightChild().hasRightChild())
    }

    /*
    Creamos un arbol igual al subarbol derecho del original
     */
    @Test
    fun getRightChildTrue() {
        bst.insert(6)
        bst.insert(8)
        val bstRightChild = BinarySearchTreeImpl<Int>()
        bstRightChild.insert(7)
        bstRightChild.insert(6)
        bstRightChild.insert(8)
        assertEquals(true, bst.getRightChild().isSameTree(bstRightChild))
    }

    /*
    Creamos un arbol distinto al subarbol derecho del original
     */
    @Test
    fun getRightChildFalse() {
        bst.insert(6)
        bst.insert(8)
        val bstRightChild = BinarySearchTreeImpl<Int>()
        bstRightChild.insert(6)
        bstRightChild.insert(8)
        bstRightChild.insert(7)
        assertEquals(false, bst.getRightChild().isSameTree(bstRightChild))
    }

    @Test
    fun clear() {
        val aux = bst
        aux.clear()
        assertEquals(null, aux.getRootValue())
    }

    @Test
    fun isEmptyTrue() {
        val empty = BinarySearchTreeImpl<Int>()
        assertEquals(true, empty.isEmpty())
    }

    @Test
    fun isEmptyFalse() {
        assertEquals(false, bst.isEmpty())
    }
}