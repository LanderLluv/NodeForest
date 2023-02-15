package com.nodeforest

class BinarySearchTreeImpl<Int> : BinarySearchTree<Int> {
    private var root: Node<Int>?
    init {
        root = null
    }

    override fun getRootValue(): Int {
        return root!!.getValue()
    }

    //TODO:no funciona si no se pasan a String, no deja ni hacer compareTo con los Int ni usar operador <

    override fun contains(value: Int): Boolean {
        var aux: Node<Int>? = root
        while(aux != null){
            if(aux.getValue() == value){
                return true
            }else if(aux.getLeftChild() == null && aux.getRightChild() == null){
                //Hemos llegado a la hoja
                return false
            }else if(value.toString().compareTo(aux.getValue().toString()) == 1 && aux.getRightChild() != null){
                //El valor es mayor y tenemos nodo a la derecha
                aux = aux.getRightChild()
            }else if(value.toString().compareTo(aux.getValue().toString()) == -1 && aux.getLeftChild() != null) {
                //El valor es menor y tenemos nodo a la izquierda
                aux = aux.getLeftChild()
            }else{
                //El valor es mayor y no hay nodo a la derecha o el valor es menor y no hay nodo a la izquierda
                return false
            }
        }
        return false
    }

    override fun insert(value: Int) {
        TODO("Not yet implemented")
    }

    override fun remove(value: Int) {
        TODO("Not yet implemented")
    }

    override fun hasLeftChild(): Boolean {
        return root?.getLeftChild() != null
    }

    override fun getLeftChild(): BinarySearchTreeImpl<Int> {
        val leftChild = BinarySearchTreeImpl<Int>()

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

    override fun getRightChild(): BinarySearchTreeImpl<Int> {
        val rightChild = BinarySearchTreeImpl<Int>()

        if(hasRightChild()){
            rightChild.root!!.setValue(root!!.getRightChild()!!.getValue())
            rightChild.root!!.setLeftChild(root!!.getRightChild()?.getLeftChild())
            rightChild.root!!.setRightChild(root!!.getRightChild()?.getRightChild())
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
    var num = "2"
    var num2 = "1"
    println(num.compareTo(num2) == -1)
}