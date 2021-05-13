package com.example.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class ActorDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_details)

        val actorNombre = getIntent().getSerializableExtra("nombre")
        val actorImagen = getIntent().getSerializableExtra("imagen") as Int
        val actorDescripcion = getIntent().getSerializableExtra("descripcion")

        val nombre = findViewById<TextView>(R.id.nombreDetails)
        val imagen = findViewById<ImageView>(R.id.fotoDetails)
        val descripcion = findViewById<TextView>(R.id.descriptionDetails)

        nombre.text = actorNombre.toString()
        imagen.setImageResource(actorImagen)
        descripcion.text = actorDescripcion.toString()

        val backButton =  findViewById<Button>(R.id.atras)
        backButton.setOnClickListener {
            val rating = findViewById<RatingBar>(R.id.ratingBar)
            val rate = rating.rating.toString()
            val intent = Intent()
            intent.putExtra("rate",rate)
            intent.putExtra("name",actorNombre.toString())
            setResult(1,intent)
            finish()
        }
    }
}