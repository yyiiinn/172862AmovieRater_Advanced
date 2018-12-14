package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.content.Intent
import android.graphics.Movie
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_edit_movie.*
import android.widget.RatingBar



class editMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)
        val movie = applicationContext as MovieDetailsClass
        val movieList = applicationContext as movieList
        //get which position of listview item is clicked
        val position = intent.getIntExtra("position", 0)

        //get same position from movielist
        val movieDet = movieList.getMovieList().elementAt(position.toInt())

        suitableage.setOnClickListener(View.OnClickListener{
            if(suitableage.isChecked == true){
                violence.visibility= View.VISIBLE
                languageUsed.visibility= View.VISIBLE
            }
            if(suitableage.isChecked == false){
                violence.visibility= View.INVISIBLE
                languageUsed.visibility= View.INVISIBLE
            }
        })
        //get details from correct movielist
        namefield.setText(movieDet.getMovieTitle())
        descfield.setText(movieDet.getMovieDesc())
        var language = movieDet.getMovieLanguage()
        if(language == "English"){
            radioButton.isChecked = true
        }
        if(language == "Chinese"){
            radioButton2.isChecked = true
        }
        if(language == "Malay"){
            radioButton3.isChecked = true
        }
        if(language == "Tamil"){
            radioButton4.isChecked = true
        }
        datefield.setText(movieDet.getMovieDate())
        if(movieDet.getMovieSuitable().contains("Yes") == true){
            suitableage.isChecked = false
            languageUsed.visibility = View.INVISIBLE
            violence.visibility = View.INVISIBLE
        }
        else{
            suitableage.isChecked = true
            languageUsed.visibility = View.VISIBLE
            violence.visibility = View.VISIBLE
        }
        if(movieDet.getMoviestrongLanguage() == true){
            languageUsed.isChecked = true
        }
        else{
            languageUsed.isChecked = false
        }
        if(movieDet.getMovieviolence() == true){
            violence.isChecked = true
        }
        else{
            violence.isChecked = false
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.editmovie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.save){
            val intent = Intent(this, movieDetails::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


}
