package com.nodeforest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import de.blox.treeview.BaseTreeAdapter
import de.blox.treeview.TreeNode
import de.blox.treeview.TreeView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val treeView = findViewById<TreeView>(R.id.idTreeView)

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

        /*val root = TreeNode(10)
        adapter.setRootNode(root)

        val firstChild = TreeNode(3)
        val secondChild = TreeNode(12)

        root.addChild(firstChild)
        root.addChild(secondChild)

        val first1Child = TreeNode(1)
        val first2Child = TreeNode(8)
        firstChild.addChild(first1Child)
        firstChild.addChild(first2Child)

        val second1Child = TreeNode(11)
        val secondNull = TreeNode("null")
        secondChild.addChild(second1Child)
        secondChild.addChild(secondNull)*/

        val prueba = BinarySearchTreeImpl<Int>()
        prueba.insert(10)
        prueba.insert(3)
        prueba.insert(12)
        prueba.insert(1)
        prueba.insert(8)
        prueba.insert(11)
        //prueba.insert(0)
        prueba.insert(2)
        prueba.insert(7)

        val result = treeToArray(prueba)
        println(result)
        showTree(result, adapter)

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