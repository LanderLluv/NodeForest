package com.nodeforest.activity

import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.nodeforest.impl.BinarySearchTreeImpl
import com.nodeforest.R
import com.nodeforest.impl.AVLTreeImpl
import de.blox.treeview.BaseTreeAdapter
import de.blox.treeview.TreeNode
import de.blox.treeview.TreeView
import java.util.*
import kotlin.collections.ArrayList

class AVLTreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avltree)

        val treeView = findViewById<TreeView>(R.id.idTreeViewMain)

        //Adaptador necesario para el treeview
        val adapter: BaseTreeAdapter<ViewHolder?> = object : BaseTreeAdapter<ViewHolder?>(this,
            R.layout.tree_view_node
        ) {
            override fun onCreateViewHolder(view: View?): ViewHolder {
                return ViewHolder(view)
            }

            override fun onBindViewHolder(viewHolder: ViewHolder?, data: Any?, position: Int) {
                viewHolder!!.textView.setText(data.toString())
            }
        }

        //Enlazamos el adaptador con el treeview
        treeView.setAdapter(adapter)

        val avltree = AVLTreeImpl<Int>()

        val btnDelete: Button = findViewById(R.id.btnDelete)
        btnDelete.isEnabled = false
        btnDelete.setOnClickListener{
            deleteValue(avltree, adapter, btnDelete, treeView)
        }

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            addValue(avltree, adapter, btnDelete, treeView)
        }

    }

    /*
        Se llama cuando se pulsa el boton de añadir.
        Muestra un dialogo para poder introducir un valor al arbol, que se añadira en caso de ser
        un valor valido (0-99), o se rechazara en caso de no serlo.
     */
    private fun addValue(avltree: AVLTreeImpl<Int>, adapter: BaseTreeAdapter<ViewHolder?>,
                         btnDelete: Button, treeView: TreeView) {
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
                avltree.insert(inputNumberValue)
                val treeArray = treeToArray(avltree)
                showTree(treeArray, adapter, treeView)
                btnDelete.isEnabled = true
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
    private fun deleteValue(avltree: AVLTreeImpl<Int>, adapter: BaseTreeAdapter<ViewHolder?>,
                            btnDelete: Button, treeView: TreeView) {
        val deleteDialog = AlertDialog.Builder(this)
        deleteDialog.setTitle("Elimina un elemento:")
        deleteDialog.setMessage("Elemento a eliminar:")

        val inputNumber = EditText(this)
        inputNumber.inputType = InputType.TYPE_CLASS_NUMBER
        deleteDialog.setView(inputNumber)

        deleteDialog.setPositiveButton("Ok", DialogInterface.OnClickListener(){
                dialog, i ->
            val inputNumberValue = Integer.parseInt(inputNumber.text.toString())
            if(avltree.contains(inputNumberValue)){
                if(inputNumberValue in 0..99){
                    avltree.delete(inputNumberValue)
                    val treeArray = treeToArray(avltree)
                    if(treeArray != null) {
                        showTree(treeArray, adapter, treeView)
                    }else{
                        showTree(null, adapter, treeView)
                        btnDelete.isEnabled = false
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
    private fun showTree(result: ArrayList<TreeNode?>?, adapter: BaseTreeAdapter<ViewHolder?>,
                         treeView: TreeView){
        if(result != null) {
            treeView.visibility = View.VISIBLE
            adapter.setRootNode(result[0]!!)
            var index = 0
            while (index < result.size / 2) {
                if (result[2 * index + 1] == null && result[2 * index + 2] == null) {
                    index++
                    continue
                }

                //Hijo izquierdo
                if (result[2 * index + 1] != null) {
                    result[index]!!.addChild(result[2 * index + 1])
                } else {
                    //Nulo
                    result[index]!!.addChild(TreeNode("N"))
                }

                //Hijo derecho
                if (result[2 * index + 2] != null) {
                    result[index]!!.addChild(result[2 * index + 2])
                } else {
                    //Nulo
                    result[index]!!.addChild(TreeNode("N"))
                }
                index++
            }
        }else{
            treeView.visibility = View.INVISIBLE
        }
    }

    /*
        Transforma un arbol en un array para poder representarlo graficamente
     */
    private fun treeToArray(root: AVLTreeImpl<Int>?): ArrayList<TreeNode?>? {
        val result = ArrayList<TreeNode?>()
        if (root!!.isEmpty()) {
            return null
        }
        val queue = LinkedList<AVLTreeImpl<Int>>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val node = queue.poll()
            if(node == null || node.getRoot()?.getValue() == null){
                result.add(null)
            }else{
                result.add(TreeNode(node.getRoot()!!.getValue()))
            }

            if (node != null && node.getRoot()?.getValue() != null) {
                queue.offer(node.getLeftChild())
                queue.offer(node.getRightChild())
            } else {
                queue.offer(null)
                queue.offer(null)
            }

            if(queue.all{it == null}){
                break
            }
        }
        return result
    }




}