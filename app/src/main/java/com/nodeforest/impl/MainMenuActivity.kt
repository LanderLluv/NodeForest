package com.nodeforest.impl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nodeforest.R

//ToDo: añadir boton con ? para dar info mientras se mantenga pulsado
class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainmenu)

        val btnBSTree: Button = findViewById(R.id.btnBSTree)
        btnBSTree.setOnClickListener{
            startActivity(Intent(this, BinarySearchTreeActivity::class.java))
        }

        val btnMaxHeap: Button = findViewById(R.id.btnMaxHeap)
        btnMaxHeap.setOnClickListener{
            startActivity(Intent(this, MaxHeapActivity::class.java))
        }

        val btnMinHeap: Button = findViewById(R.id.btnMinHeap)
        btnMinHeap.setOnClickListener{
            startActivity(Intent(this, MinHeapActivity::class.java))
        }
    }
}