package com.nodeforest

/**
 * TAD Montículo binario.
 *
 * Es un árbol con las siguientes propiedades:
 *  1. Es completo, es decir, es un árbol completamente lleno, con la excepción
 *  del nivel inferior, que debe llenarse de izquierda a derecha.
 *  2. Las hojas están en dos niveles adyacentes.
 *  3. Para cada nodo X con padre P, se cumple que el dato en P es menor o igual
 * que el dato en X
 *
 * No soporta el almacenamiento de valores nulos (<code>null</code>).
 *
 * @param <T> tipo de los valores contenidos en el montículo binario.
 */

interface MinHeap <T : Comparable<T>>  {

    /**
     * Comprueba si el heap está vacío.
     *
     * @return <code>true</code> cuando el heap está vacío y <code>false</code> en
     *         caso contrario.
     */
    fun isEmpty(): Boolean

    /**
     * Recupera el mayor elemento del heap.
     *
     * @return el elemento mayor del heap.
     */
    fun getMinValue(): T?

    /**
     * Elimina y devuelve el elemento mayor del heap.
     *
     * @return el elemento mayor del heap.
     */
    fun removeMinValue(): T?

    /**
     * Añade un valor al heap.
     *
     * @param value el elemento a añadir.
     */
    fun insert(value: T)

    /**
     * Elimina los valores del heap, convirtiéndolo en un heap vacío.
     */
    fun clear()
}