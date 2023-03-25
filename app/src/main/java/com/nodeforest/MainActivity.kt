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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val treeView = findViewById<TreeView>(R.id.idTreeViewMain)

        // creating adapter class for our treeview
        // using basetree adapter. Inside base tree adapter
        // you have to pass viewholder class along with
        // context and your layout file for treeview node.
        val adapter: BaseTreeAdapter<ViewHolder?> = object : BaseTreeAdapter<ViewHolder?>(this, R.layout.tree_view_node) {
            override fun onCreateViewHolder(view: View?): ViewHolder {
                return ViewHolder(view)
            }

            override fun onBindViewHolder(viewHolder: ViewHolder?, data: Any?, position: Int) {
                // inside our on bind view holder method we
                // are setting data from object to text view.
                viewHolder!!.textView.setText(data.toString())
            }
        }

        // below line is setting adapter for our tree.
        treeView.setAdapter(adapter)

        val bstree = BinarySearchTreeImpl<Int>()
        /*bstree.insert(10)
        bstree.insert(3)
        bstree.insert(12)
        bstree.insert(1)
        bstree.insert(8)
        bstree.insert(11)*/

        /*val result = treeToArray(prueba)
        println(result)
        showTree(result, adapter)*/

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
            addValue(bstree, adapter)
        }
        val btnDelete: Button = findViewById(R.id.btnDelete)





    }

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
        addDialog.create()
        addDialog.show()
    }

    private fun showTree(result: ArrayList<TreeNode?>, adapter: BaseTreeAdapter<ViewHolder?>){
        adapter.setRootNode(result[0]!!)
        var index = 0
        //val nullNode = TreeNode("null")
        while(index < result.size/2){
            if(result[2*index+1] == null && result[2*index+2] == null){
                index++
                continue
            }

            //Hijo izquierdo
            if(result[2*index+1] != null){
                result[index]!!.addChild(result[2*index+1])
            }else{
                result[index]!!.addChild(TreeNode("N"))
            }

            //Hijo derecho
            if(result[2*index+2] != null){
                result[index]!!.addChild(result[2*index+2])
            }else{
                result[index]!!.addChild(TreeNode("N"))
            }
            index++
        }
    }

    private fun treeToArray(root: BinarySearchTreeImpl<Int>?): ArrayList<TreeNode?> {
        val result = ArrayList<TreeNode?>()
        /*if (root?.isEmpty() == true){
            return result
        }*/

        val queue = mutableListOf<BinarySearchTreeImpl<Int>>()
        queue.add(root!!)
        var index = 0

        while (index < queue.size) {
            val node = queue[index]
            index++
            if(result.isEmpty()){

                result.add(TreeNode(node.getRootValue()))
            }


            if(node.getRoot() == null && node.getLeftChild()?.getRoot() == null && node.getRightChild().getRoot() == null){
                continue
            }
            if (node.getLeftChild()?.getRoot() != null) {
                queue.add(node.getLeftChild()!!)
                result.add(TreeNode(node.getLeftChild()!!.getRootValue()))
            } else {
                result.add(null)
            }

            if (node.getRightChild().getRoot() != null) {
                queue.add(node.getRightChild())
                result.add(TreeNode(node.getRightChild().getRootValue()))
            } else {
                result.add(null)
            }
        }

        return result
    }
}