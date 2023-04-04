package com.nodeforest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        val btnBSTree: Button = findViewById(R.id.btnBSTree)
        btnBSTree.setOnClickListener{
            startActivity(Intent(this, BinarySearchTreeActivity::class.java))
        }

        val btnHeap: Button = findViewById(R.id.btnHeap)
    }
}