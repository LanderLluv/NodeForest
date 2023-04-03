package com.nodeforest

import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import de.blox.treeview.BaseTreeAdapter
import de.blox.treeview.TreeNode
import de.blox.treeview.TreeView

class BinarySearchTreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bstree)

        val treeView = findViewById<TreeView>(R.id.idTreeViewMain)

        //Adaptador necesario para el treeview
        val adapter: BaseTreeAdapter<ViewHolder?> = object : BaseTreeAdapter<ViewHolder?>(this, R.layout.tree_view_node) {
            override fun onCreateViewHolder(view: View?): ViewHolder {
                return ViewHolder(view)
            }

            override fun onBindViewHolder(viewHolder: ViewHolder?, data: Any?, position: Int) {
                viewHolder!!.textView.setText(data.toString())
            }
        }

        //Enlazamos el adaptador con el treeview
        treeView.setAdapter(adapter)

        val bstree = BinarySearchTreeImpl<Int>()

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            addValue(bstree, adapter)
        }

        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.setOnClickListener{
            deleteValue(bstree, adapter)
        }
    }

    /*
        Se llama cuando se pulsa el boton de añadir.
        Muestra un dialogo para poder introducir un valor al arbol, que se añadira en caso de ser
        un valor valido (0-99), o se rechazara en caso de no serlo.
     */
    private fun addValue(bstree: BinarySearchTreeImpl<Int>, adapter: BaseTreeAdapter<ViewHolder?>) {
        val addDialog = AlertDialog.Builder(this)
        addDialog.setTitle("Añade un elemento:")
        addDialog.setMessage("Elemento a añadir:")

        val inputNumber = EditText(this)
        inputNumber.inputType = InputType.TYPE_CLASS_NUMBER
        addDialog.setView(inputNumber)

        addDialog.setPositiveButton("Ok", DialogInterface.OnClickListener(){
                dialog, i ->
                    val inputNumberValue = Integer.parseInt(inputNumber.text.toString())
                    if(inputNumberValue in 0..99){
                        bstree.insert(inputNumberValue)
                        val treeArray = treeToArray(bstree)
                        showTree(treeArray,adapter)
                    }else{
                        Toast.makeText(this, "El valor debe estar entre 0 y 99", Toast.LENGTH_SHORT).show()
                    }

        })
        addDialog.setNegativeButton("Cancelar", DialogInterface.OnClickListener(){
            dialog, i ->
        })
        addDialog.create()
        addDialog.show()
    }

    /*
        Se llama cuando se pulsa el boton de eliminar.
        Muestra un dialogo para poder introducir un valor al arbol, que se borrara en caso de ser
        un valor valido (0-99) y estar presente en el arbol, o se rechazara en caso de no serlo.
     */
    private fun deleteValue(bstree: BinarySearchTreeImpl<Int>, adapter: BaseTreeAdapter<ViewHolder?>) {
        val deleteDialog = AlertDialog.Builder(this)
        deleteDialog.setTitle("Elimina un elemento:")
        deleteDialog.setMessage("Elemento a eliminar:")

        val inputNumber = EditText(this)
        inputNumber.inputType = InputType.TYPE_CLASS_NUMBER
        deleteDialog.setView(inputNumber)

        deleteDialog.setPositiveButton("Ok", DialogInterface.OnClickListener(){
                dialog, i ->
            val inputNumberValue = Integer.parseInt(inputNumber.text.toString())
            if(bstree.contains(inputNumberValue)){
                if(inputNumberValue in 0..99){
                    bstree.remove(inputNumberValue)
                    val treeArray = treeToArray(bstree)
                    if(treeArray.size > 0) {
                        showTree(treeArray, adapter)
                    }
                }else{
                    Toast.makeText(this, "El valor debe estar entre 0 y 99", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "El valor no se encuentra en el arbol", Toast.LENGTH_SHORT).show()
            }
        })
        deleteDialog.setNegativeButton("Cancelar", DialogInterface.OnClickListener(){
                dialog, i ->
        })

        deleteDialog.create()
        deleteDialog.show()
    }

    /*
        Representa el arbol correspondiente dado un array
     */
    private fun showTree(result: ArrayList<TreeNode?>, adapter: BaseTreeAdapter<ViewHolder?>){
        adapter.setRootNode(result[0]!!)
        var index = 0
        while(index < result.size/2){
            if(result[2*index+1] == null && result[2*index+2] == null){
                index++
                continue
            }

            //Hijo izquierdo
            if(result[2*index+1] != null){
                result[index]!!.addChild(result[2*index+1])
            }else{
                //Nulo
                result[index]!!.addChild(TreeNode("N"))
            }

            //Hijo derecho
            if(result[2*index+2] != null){
                result[index]!!.addChild(result[2*index+2])
            }else{
                //Nulo
                result[index]!!.addChild(TreeNode("N"))
            }
            index++
        }
    }

    /*
        Transforma un arbol en un array para poder representarlo graficamente
     */
    private fun treeToArray(root: BinarySearchTreeImpl<Int>?): ArrayList<TreeNode?> {
        val result = ArrayList<TreeNode?>()

        val queue = mutableListOf<BinarySearchTreeImpl<Int>>()
        queue.add(root!!)
        var index = 0

        while (index < queue.size) {
            val node = queue[index]
            index++
            //Primer elemento(raiz)
            if(result.isEmpty()){
                result.add(TreeNode(node.getRootValue()))
            }

            //Nodo completamente nulo
            if(node.getRoot() == null && node.getLeftChild()?.getRoot() == null && node.getRightChild().getRoot() == null){
                continue
            }

            if (node.getLeftChild()?.getRoot() != null) {
                //Hijo izquierdo
                queue.add(node.getLeftChild()!!)
                result.add(TreeNode(node.getLeftChild()!!.getRootValue()))
            } else {
                result.add(null)
            }

            if (node.getRightChild().getRoot() != null) {
                //Hijo derecho
                queue.add(node.getRightChild())
                result.add(TreeNode(node.getRightChild().getRootValue()))
            } else {
                result.add(null)
            }
        }

        return result
    }
}