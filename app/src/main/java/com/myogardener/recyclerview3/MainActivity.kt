package com.myogardener.recyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myogardener.recyclerview3.abdater.PersonAdapter
import com.myogardener.recyclerview3.person.Person
import kotlinx.android.synthetic.main.recycleview.*

class MainActivity : AppCompatActivity(), PersonAdapter.ClickListerner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycleview)
        var personlist = ArrayList<Person>()

        personlist.add(Person(R.drawable.ic_wishlist, "My Wishlist"))
        personlist.add(Person(R.drawable.ic_box, "followed seller"))
        personlist.add(Person(R.drawable.ic_purchse_box, "purchased items"))
        personlist.add(Person(R.drawable.ic_coupons, "coupons"))
        personlist.add(Person(R.drawable.ic_wallet, "cards wallet"))
        personlist.add(Person(R.drawable.ic_star, "Exp point"))
        personlist.add(Person(R.drawable.ic_feedback, "given feedbacks"))
        personlist.add(Person(R.drawable.ic_history, "searched History"))
        personlist.add(Person(R.drawable.ic_calendar, "Calander"))

        var personAdapter = PersonAdapter(personlist)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = personAdapter
        personAdapter.setOnClickListener(this)

    }

    override fun onClick(person: Person) {
        Toast.makeText(this, person.label, Toast.LENGTH_SHORT).show()
    }
}

