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

        val root = TreeNode("Root")

        val firstChild = TreeNode("FirstChild")
        val secondChild = TreeNode("SecondChild")

        val first1Child = TreeNode("first1")
        val first2Child = TreeNode("first2")

        val second1Child = TreeNode("second1")

        root.addChild(firstChild)
        root.addChild(secondChild)

        firstChild.addChild(first1Child)
        firstChild.addChild(first2Child)
        secondChild.addChild(second1Child)

        adapter.setRootNode(root)
    }
}