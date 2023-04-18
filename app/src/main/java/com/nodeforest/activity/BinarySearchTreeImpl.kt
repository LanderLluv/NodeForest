package com.nodeforest.activity

class BinarySearchTreeImpl<T: Comparable<T>> : BinarySearchTree<T> {
    private var root: Node<T>?
    init {
        root = null
    }

    fun getRoot(): Node<T>?{
        return root
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
                    if(value.compareTo(aux.getValue()) == 1 || value.compareTo(aux.getValue()) == 0){
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
        root = removeNode(root, value)
    }

    /*
    Eliminada el nodo con el valor value, llamada de forma recursiva
     */
    private fun removeNode(root: Node<T>?, value: T): Node<T>? {
        var aux = root

        if(aux == null){
            return aux
        }


        if(aux.getValue().compareTo(value) == 1){
            //En caso de que coincida el valor
            aux.setLeftChild(removeNode(aux.getLeftChild(),value))
        }else if(aux.getValue().compareTo(value) == -1){
            //En caso de que el el nodo actual sea menor que el valor que buscamos
            aux.setRightChild(removeNode(aux.getRightChild(),value))
        }else{
            if(aux.getLeftChild() == null && aux.getRightChild() == null){
                //No tiene hijos
                aux = null
            }else if(aux.getRightChild() == null){
                //No tiene hijo derecho
                aux = aux.getLeftChild()
            }else if(aux.getLeftChild() == null){
                //No tiene hijo derecho
                aux = aux.getRightChild()
            }else{
                //Tiene dos hijos y debemos encontrar el menor valor del subarbol de la derecha
                val temp = findMinFromRight(aux.getRightChild()!!)
                aux.setValue(temp.getValue())
                aux.setRightChild(removeNode(aux.getRightChild(),temp.getValue()))
            }
        }
        return aux
    }

    /*
    Devuelve el menor valor de un subarbol derecho
     */
    private fun findMinFromRight(node: Node<T>): Node<T> {
        var nodeAux = node
        while(nodeAux.getLeftChild() != null){
            nodeAux = nodeAux.getLeftChild()!!
        }
        return nodeAux
    }

    override fun hasLeftChild(): Boolean {
        return root?.getLeftChild()?.getValue() != null
    }

    override fun getLeftChild(): BinarySearchTreeImpl<T>? {
        val leftChild = BinarySearchTreeImpl<T>()
        leftChild.root = getLeftChildNode(root)
        return leftChild
    }

    /*
    Recursion para obtener el nodo del hijo izquierdo
     */
    private fun getLeftChildNode(node: Node<T>?): Node<T>?{
        if(node == null || node.getLeftChild() == null){
            return null
        }
        return Node<T>(node.getLeftChild()!!.getValue(),
        getLeftChildNode(node.getLeftChild()), getRightChildNode(node.getLeftChild()))

    }

    override fun hasRightChild(): Boolean {
        return root?.getRightChild()?.getValue() != null
    }

    override fun getRightChild(): BinarySearchTreeImpl<T>? {
        val rightChild = BinarySearchTreeImpl<T>()
        rightChild.root = getRightChildNode(root)
        return rightChild
    }

    /*
    Recursion para obtener el nodo del hijo derecho
     */
    private fun getRightChildNode(node: Node<T>?): Node<T>?{
        if(node == null || node.getRightChild() == null){
            return null
        }
        return Node<T>(node.getRightChild()!!.getValue(),
            getLeftChildNode(node.getRightChild()), getRightChildNode(node.getRightChild()))

    }

    override fun clear() {
        root = null
    }

    override fun isEmpty(): Boolean {
        return root == null
    }

    /*
    Compara el arbol actual y el que se pasa por parametro para ver si son iguales
     */
    fun isSameTree(compareTree: BinarySearchTreeImpl<T>?): Boolean{
        val actualNode = this.getRoot()
        val compareNode = compareTree?.getRoot()
        //Ambos nodos son nulos
        if(actualNode == null && compareNode == null){
            return true
        }
        //Uno de los nodos es nulo y el otro no, o sus valores no coinciden
        if(actualNode == null || compareNode == null || (actualNode.getValue() != compareNode.getValue())){
            return false
        }

        //Llamada recursiva a los hijos izquierdo y derecho de ambos arboles
        return this.getLeftChild()!!.isSameTree(compareTree.getLeftChild()) && this.getRightChild()!!.isSameTree(compareTree.getRightChild())
    }

}