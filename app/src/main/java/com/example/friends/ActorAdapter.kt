package com.example.friends

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ActorAdapter(var ctx: Context, val res: Int, val objs: ArrayList<Actor>):ArrayAdapter<Actor>(
    ctx, res, objs){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val datos =objs.get(position)

        val inflater =ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(res, parent, false)

        val nombre = view.findViewById<TextView>(R.id.nombre_actor)
        nombre.text=datos.name

        val rate = view.findViewById<TextView>(R.id.rate)
        rate.text= datos.rate

        val image = view.findViewById<ImageView>(R.id.foto)
        image.setImageResource(datos.img!!)
        image.setOnClickListener{
            val intent = Intent(ctx, ActorDetails::class.java)
            intent.putExtra("nombre", datos.name)
            intent.putExtra("imagen", datos.img)
            intent.putExtra("descripcion", datos.desc)
            (ctx as Activity).startActivityForResult(intent, 1)
        }
        this.notifyDataSetChanged()
        return view
    }
}