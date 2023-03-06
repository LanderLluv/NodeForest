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

        // creating a variable for tree view.
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

        // below tree node is a parent node of our
        // tree node which is Geeks for Geeks.
        val root = TreeNode("Root")

        // below node is the first child node of
        // our root node ie Geeks for Geeks.
        val firstChild = TreeNode("FirstChild")

        // below node is the second child of our
        // root node ie Geeks for Geeks.
        val secondChild = TreeNode("SecondChild")

        // below node is the first child of our DSA node.
        val first1Child = TreeNode("first1")

        // below node is the second child of our DSA node.
        val first2Child = TreeNode("first2")

        // below node is the first child of our Algorithm node.
        val second1Child = TreeNode("second1")

        // below lines is used for adding
        // child nodes to our root nodes.
        root.addChild(firstChild)
        root.addChild(secondChild)

        firstChild.addChild(first1Child)
        firstChild.addChild(first2Child)
        secondChild.addChild(second1Child)

        // below line is for setting our root node.
        // Inside our root node we are passing
        // "root" as our root node.
        adapter.setRootNode(root)
    }
}