package com.example.friends

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val actores = ArrayList<Actor>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridLayout = findViewById<GridView>(R.id.view)

        actores.add(Actor("Keanu Reeves", "Actor canadiense de 52 años nacido el 2 de septiembre de 1964", R.drawable.keanu, ""))
        actores.add(Actor("Morgan Freeman", "Actor estadounidense de 82 años nacido el 1 de Junio de 1937", R.drawable.morgan, ""))
        actores.add(Actor("Emma Watson", "Actriz britanica de 31 años nacida el 15 de Abril de 1990", R.drawable.watson, null))
        actores.add(Actor("Will Smith", "Actor, rapero y productor estadounidense de 52 años nacido el 25 de Septiembre de 1968", R.drawable.smith, ""))
        actores.add(Actor("Chuck Norris", "Actor estadounidense de 81 años nacido el 10 de Marzo de 1940", R.drawable.norris, ""))
        actores.add(Actor("Scarlett Johanson", "Actriz, cantente y modelo estadounidense de 36 años nacida el 22 de Noviembre de 1984", R.drawable.scarlett, ""))

        val myAdapter= ActorAdapter(this, R.layout.item_actor, actores)
        gridLayout.adapter= myAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val gridLayout= findViewById<GridView>(R.id.view)

        if(requestCode == 1){
            if (data != null) {
                val rate= data.getStringExtra("rate")
                val name= data.getStringExtra("name")

                for (n in actores){
                    if(name == n.name){
                        n.rate= rate
                        val myAdapter = ActorAdapter(this, R.layout.item_actor, actores)
                        gridLayout.adapter = myAdapter
                        myAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }


}