package com.myogardener.recyclerview3.abdater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myogardener.recyclerview3.R
import com.myogardener.recyclerview3.person.Person
import kotlinx.android.synthetic.main.activity_main.view.*

class PersonAdapter(var weightArrayList: ArrayList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    var clickListerner: ClickListerner? = null

    fun setOnClickListener(clickListerner: ClickListerner) {
        this.clickListerner = clickListerner
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        lateinit var person: Person
        init {
            itemView.setOnClickListener(this)
        }

        fun bindPerson(person: Person) {
            this.person = person
            itemView.iv1.setImageResource(person.image)
            itemView.tv_label.text = person.label
        }

        override fun onClick(view: View) {
            clickListerner?.onClick(person)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)

        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weightArrayList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindPerson(weightArrayList[position])
    }

    interface ClickListerner {
        fun onClick(person: Person)
    }
}
