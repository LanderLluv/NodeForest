package com.nodeforest

class BinarySearchTreeImpl<T: Comparable<T>> : BinarySearchTree<T> {
    private var root: Node<T>?
    init {
        root = null
    }

    override fun getRootValue(): T? {
        return root?.getValue()
    }

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
        val toInsert = Node(value, null, null)
        if(root == null){
            root = toInsert
        }else{
            var aux = root
            while(aux != null){
                //Hemos llegado a la hoja
                if(aux.getLeftChild() == null && aux.getRightChild() == null){
                    if(value.compareTo(aux.getValue()) == 1){
                        //Derecha
                        aux.setRightChild(toInsert)
                        aux = null
                    }else{
                        //Izquierda
                        aux.setLeftChild(toInsert)
                        aux = null
                    }
                //No tiene hijo derecho y es mayor
                }else if(value.compareTo(aux.getValue()) == 1 && aux.getRightChild() == null){
                    aux.setRightChild(toInsert)
                    aux = null
                //No tiene hijo izquierdo y es menor
                }else if(value.compareTo(aux.getValue()) == -1 && aux.getLeftChild() == null){
                    aux.setLeftChild(toInsert)
                    aux = null
                }else{
                    //Pasamos al siguiente nodo
                    if(value.compareTo(aux.getValue()) == 1){
                        aux = aux.getRightChild()
                    }else{
                        aux = aux.getLeftChild()
                    }
                }
            }
        }
    }

    override fun remove(value: T) {
        /*var aux = root

        while(aux != null){
            if(aux.getValue() == value){
                var toRemove = aux;
                if(aux.getRightChild() != null){

                }
            }
        }*/
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