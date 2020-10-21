package ipvc.estg.aulas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val PARAM1_NAME= "name"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref:SharedPreferences = getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val soundValue = sharedPref.getBoolean(getString(R.string.sound),false)
        Log.d("****SHAREDPREF", "Read $soundValue")

        if(soundValue){
            findViewById<CheckBox>(R.id.checkbox).isChecked = true
        }

    }

    fun checkboxClicked(view: View){
        if(view is CheckBox) {
            val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean(getString(R.string.sound), view.isChecked)
                commit()
            }
            Log.d("****SHAREDPREF", "Changed to ${view.isChecked}")
        }
    }


    fun button1(view: View){
        var editText = findViewById<EditText>(R.id.editPersonName)
        findViewById<TextView>(R.id.text1).setText(editText.text)
    }

    fun button2(view: View){
        var editText = findViewById<EditText>(R.id.editPersonName)
        Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
    }

    fun button3(view: View){
        //var editText = findViewById<EditText>(R.id.editPersonName)
        val intent= Intent(this, SecondActivity::class.java).apply {
            //putExtra(PARAM1_NAME, editText.text.toString())
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.create_new->{
                Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.open->{
                Toast.makeText(this, "teste2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.opt3->{
                Toast.makeText(this, "teste3", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.opt4->{
                Toast.makeText(this, "teste4", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}