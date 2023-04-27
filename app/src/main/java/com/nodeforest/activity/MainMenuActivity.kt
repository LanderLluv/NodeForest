package com.nodeforest.activity

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nodeforest.R

class MainMenuActivity : AppCompatActivity(), View.OnLongClickListener, View.OnTouchListener {

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

        val btnAVLTree: Button = findViewById(R.id.btnAVLTree)
        btnAVLTree.setOnClickListener{
            startActivity(Intent(this, AVLTreeActivity::class.java))
        }

        val btnInfoBSTree: Button = findViewById(R.id.btnInfoBSTree)
        val btnInfoMaxHeap: Button = findViewById(R.id.btnInfoMaxHeap)
        val btnInfoMinHeap: Button = findViewById(R.id.btnInfoMinHeap)
        val btnInfoAVLTree: Button = findViewById(R.id.btnInfoAVLTree)

        //Detecta pulsacion larga
        btnInfoBSTree.setOnLongClickListener(this)
        btnInfoMaxHeap.setOnLongClickListener(this)
        btnInfoMinHeap.setOnLongClickListener(this)
        btnInfoAVLTree.setOnLongClickListener(this)

        //Detecta fin de pulsacion
        btnInfoBSTree.setOnTouchListener(this)
        btnInfoMaxHeap.setOnTouchListener(this)
        btnInfoMinHeap.setOnTouchListener(this)
        btnInfoAVLTree.setOnTouchListener(this)

    }

    override fun onLongClick(v: View?): Boolean {
        when(v!!.id){
            R.id.btnInfoBSTree -> setInfoText("btnInfoBSTree")
            R.id.btnInfoMaxHeap -> setInfoText("btnInfoMaxHeap")
            R.id.btnInfoMinHeap -> setInfoText("btnInfoMinHeap")
            R.id.btnInfoAVLTree -> setInfoText("btnInfoAVLTree")
        }

        return false
    }

    private fun setInfoText(text: String){
        var tvInfo: TextView = findViewById(R.id.tvInfo)
        tvInfo.text = text
        tvInfo.visibility = VISIBLE
        var btnInfoBSTree: Button = findViewById(R.id.btnInfoBSTree)
        var btnInfoMaxHeap: Button = findViewById(R.id.btnInfoMaxHeap)
        var btnInfoMinHeap: Button = findViewById(R.id.btnInfoMinHeap)
        var btnInfoAVLTree: Button = findViewById(R.id.btnInfoAVLTree)
        btnInfoBSTree.visibility = INVISIBLE
        btnInfoMaxHeap.visibility = INVISIBLE
        btnInfoMinHeap.visibility = INVISIBLE
        btnInfoAVLTree.visibility = INVISIBLE
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(event!!.action == MotionEvent.ACTION_UP){
            var tvInfo: TextView = findViewById(R.id.tvInfo)
            tvInfo.visibility = INVISIBLE
            var btnInfoBSTree: Button = findViewById(R.id.btnInfoBSTree)
            var btnInfoMaxHeap: Button = findViewById(R.id.btnInfoMaxHeap)
            var btnInfoMinHeap: Button = findViewById(R.id.btnInfoMinHeap)
            var btnInfoAVLTree: Button = findViewById(R.id.btnInfoAVLTree)
            btnInfoBSTree.visibility = VISIBLE
            btnInfoMaxHeap.visibility = VISIBLE
            btnInfoMinHeap.visibility = VISIBLE
            btnInfoAVLTree.visibility = VISIBLE
            return true
        }

        return false
    }
}