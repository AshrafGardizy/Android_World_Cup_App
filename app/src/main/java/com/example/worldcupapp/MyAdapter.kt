package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter (private var activity:Activity,var items:ArrayList<CountryModel>) :BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return  items[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        val viewHolder:ViewHolder
        if(convertView == null)
        {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.my_custom_list,null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var countries = items[position]
        viewHolder.txtName?.text = countries.countryName
        viewHolder.txtCupWin?.text = countries.cupsWon
        viewHolder.flag_img?.setImageResource(countries.flag_img)

        view.setOnClickListener{
            Toast.makeText(activity,"You choose: ${countries.countryName}",Toast.LENGTH_LONG).show()
        }

        return view as View
    }

    private class ViewHolder(row:View){

        var txtName:TextView? = null
        var txtCupWin:TextView? = null
        var flag_img:ImageView? = null
        init {
            this.txtName = row.findViewById(R.id.textViewTitle)
            this.txtCupWin = row.findViewById(R.id.textViewTotleWinze)
            this.flag_img = row.findViewById(R.id.imageView)
        }

    }

}