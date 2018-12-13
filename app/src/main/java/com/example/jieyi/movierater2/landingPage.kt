package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.content.Intent
import android.view.Menu
import android.widget.ListView
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_landing_page.*
import android.R.id.edit

import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_movie_rater.*


class landingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        PreferenceManager.getDefaultSharedPreferences(this).edit().clear().apply()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        add.text = "You have not added a movie" + "\n" + "Long press me to add a movie"
        registerForContextMenu(add)
//        val preferences = PreferenceManager.getDefaultSharedPreferences(this).getAll()
//        var text3 = ""
//        var itemList = ArrayList<String>()
//        val keys = PreferenceManager.getDefaultSharedPreferences(this).all
//        if(preferences != null){
//            for(i in preferences) {
//                var v = i.value.toString()
//                var items = v.split(",")
//                for (item in items) {
//                    item.replace("]", "")
//                    item.replace("[", "")
//                    itemList.add(item)
//                    text3 += item + "\n"
//                }
//            }
//            textView8.text = text3
//        }
//        private lateinit var listView ListView
//        listView = findViewById<ListView>(R.id.recipe_list_view)
//        val recipeList = Recipe.getRecipeFromFile("recipes.json", this)
//        val listItems = arrayOfNulls<String>(recipeList.size)
//        for (i in 0 until recipeList.size) {
//            val recipe = recipeList[i]
//            listItems[i] = recipe.title
//        }
// 4
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
//        listView.adapter = adapter

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        getMenuInflater().inflate(R.menu.addmovie_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        if(item?.itemId == R.id.add){
//            val intent = Intent(this, movieRater::class.java)
//            startActivity(intent)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        getMenuInflater().inflate(R.menu.addmovie_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add){
            val intent = Intent(this, movieRater::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }


}
