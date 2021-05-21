package com.example.ageofempire.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.AgeofEmpire.R
import com.example.ageofempire.user.AboutActivity
import com.example.ageofempire.user.Login
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_deconnexion) {
            FirebaseAuth.getInstance().signOut() //déconnexion
            val aboutIntent = Intent(this@MainActivity, Login::class.java)
            Toast.makeText(this@MainActivity, "Déconnexion réussie", Toast.LENGTH_SHORT).show()
            startActivity(aboutIntent)
            return true
        }

        if (id == R.id.action_about) {
            FirebaseAuth.getInstance().signOut() //déconnexion
            val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(aboutIntent)
            return true
        }




        return super.onOptionsItemSelected(item)
    }
}