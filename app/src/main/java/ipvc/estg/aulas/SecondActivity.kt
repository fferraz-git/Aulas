package ipvc.estg.aulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import ipvc.estg.aulas.adapter.LineAdapter
import ipvc.estg.aulas.dataclasses.Place
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private lateinit var myList: ArrayList<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*val message = intent.getStringExtra(PARAM1_NAME)
        val textView = findViewById<TextView>(R.id.textView).apply{
            text = message*/

        myList = ArrayList<Place>()

        for (i in 0 until 50){
            myList.add(Place("Country $i", i*50, "Capital $i"))
        }
        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    fun insert(view: View){
        myList.add(0, Place("Country XXX", 999, "Capital XXX"))
        recycler_view.adapter?.notifyDataSetChanged()
    }
}