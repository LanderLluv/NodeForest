package com.nodeforest

class BinarySearchTreeImpl<T: Comparable<T>> : BinarySearchTree<T> {
    private var root: Node<T>?
    init {
        root = null
    }

    override fun getRootValue(): T {
        return root!!.getValue()
    }

    //TODO:no funciona si no se pasan a String, no deja ni hacer compareTo con los Int ni usar operador <

    override fun contains(value: T): Boolean {

        var aux: Node<T>? = root
        while(aux != null){
            if(aux.getValue() == value){
                return true
            }else if(aux.getLeftChild() == null && aux.getRightChild() == null) {
                //Hemos llegado a la hoja
                return false
            }else if(value.compareTo(aux.getValue()) == 1 && aux.getRightChild() != null){
                //El valor es mayor y tenemos nodo a la derecha
                aux = aux.getRightChild()
            }else if(value.compareTo(aux.getValue()) == -1 && aux.getLeftChild() != null) {
                //El valor es menor y tenemos nodo a la izquierda
                aux = aux.getLeftChild()
            }else{
                //El valor es mayor y no hay nodo a la derecha o el valor es menor y no hay nodo a la izquierda
                return false
            }
        }
        return false
    }

    override fun insert(value: T) {
        TODO("Not yet implemented")
    }

    override fun remove(value: T) {
        TODO("Not yet implemented")
    }

    override fun hasLeftChild(): Boolean {
        return root?.getLeftChild() != null
    }

    override fun getLeftChild(): BinarySearchTreeImpl<T> {
        val leftChild = BinarySearchTreeImpl<T>()

        if(hasLeftChild()){
            leftChild.root!!.setValue(root!!.getLeftChild()!!.getValue())
            leftChild.root!!.setLeftChild(root!!.getLeftChild()?.getLeftChild())
            leftChild.root!!.setRightChild(root!!.getLeftChild()?.getRightChild())
        }

        return leftChild
    }

    override fun hasRightChild(): Boolean {
        return root?.getRightChild() != null
    }

    override fun getRightChild(): BinarySearchTreeImpl<T> {
        val rightChild = BinarySearchTreeImpl<T>()

        if(hasRightChild()){
            rightChild.root!!.setValue(root!!.getRightChild()!!.getValue())
            rightChild.root!!.setLeftChild(root!!.getRightChild()!!.getLeftChild())
            rightChild.root!!.setRightChild(root!!.getRightChild()!!.getRightChild())
        }

        return rightChild
    }

    override fun clear() {
        root = null
    }

    override fun isEmpty(): Boolean {
        return root == null
    }

}

fun main(args: Array<String>) {
}