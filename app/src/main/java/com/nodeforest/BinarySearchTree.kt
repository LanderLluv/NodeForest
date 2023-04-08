package com.nodeforest

/**
 * TAD árbol binario de búsqueda.
 *
 * TODO: Completar descripción
 *
 * No soporta el almacenamiento de valores nulos (<code>null</code>).
 *
 * @author Rosalía Laza Fidalgo
 * @author Reyes Pavón Rial
 * @author Lander Lluvia
 *
 * @param <T> tipo de los valores contenidos en el árbol.
 */
interface BinarySearchTree<T : Comparable<T>> {

    /**
     * Devuelve el valor raíz del árbol.
     *
     * @return el valor raíz del árbol.
     */
    fun getRootValue(): T?

    /**
     * Comprueba si el valor recibido (<code>value</code>) está en el árbol. Puede
     * ser el valor raíz o el valor de cualquiera de los subárboles hijos.
     *
     * @param value el valor a buscar en el árbol.
     * @return <code>true</code> si el valor está contenido en el árbol (incluyendo
     *         los árboles hijo). <code>false</code> en caso contrario.
     */
    fun contains(value: T): Boolean

    /**
     * Inserta el valor recibido (<code>value</code>) en el árbol.
     *
     * @param value el valor a insertar en el árbol.
     */
    fun insert(value: T)

    /**
     * Elimina una instancia del valor recibido (<code>value</code>) en el árbol.
     *
     * @param value el valor a elimiinar en el árbol.
     */
    fun remove(value: T)

    /**
     * Comprueba si el árbol tiene un hijo izquierdo.
     *
     * @return <code>true</code> si el árbol tiene un hijo izquierdo.
     *         <code>false</code> en caso contrario.
     */
    fun hasLeftChild(): Boolean

    /**
     * Devuelve el subárbol del hijo izquierdo. En el caso de no tener un hijo
     * izquierdo se devolverá un árbol vacío.
     *
     * @return el subárbol del hijo izquierdo.
     */
    fun getLeftChild(): BinarySearchTreeImpl<T>?

    /**
     * Comprueba si el árbol tiene un hijo derecho.
     *
     * @return <code>true</code> si el árbol tiene un hijo derecho.
     *         <code>false</code> en caso contrario.
     */
    fun hasRightChild(): Boolean

    /**
     * Devuelve el subárbol del hijo derecho. En el caso de no tener un hijo
     * derecho se devolverá un árbol vacío.
     *
     * @return el subárbol del hijo derecho.
     * @throws EmptyTreeException si el árbol es vacío.
     */
    fun getRightChild(): BinarySearchTreeImpl<T>?

    /**
     * Elimina el valor y los árboles hijos del árbol actual, convirtiéndolo en un
     * árbol vacío.
     */
    fun clear()

    /**
     * Comprueba si el árbol es vacío. Es decir, no tiene valor ni árboles hijos.
     *
     * @return <code>true</code> si el árbol es vacío (no tiene valor ni árboles
     *         hijos). <code>false</code> en caso contrario.
     */
    fun isEmpty(): Boolean
}