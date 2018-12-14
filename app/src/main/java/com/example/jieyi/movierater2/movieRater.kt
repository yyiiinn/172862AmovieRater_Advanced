package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_movie_rater.*
import android.widget.Toast
import android.R.attr.key
import android.preference.PreferenceManager
import android.content.SharedPreferences

class movieRater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
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

    }
    fun btnValidate():Boolean{
        var check = true;
        if(namefield.getText().isNullOrEmpty()){
            namefield.setError("Field Empty")
            check = false;
        }
        if(descfield.getText().isNullOrEmpty()){
            descfield.setError("Field Empty")
            check = false;
        }
        if(releasedate.getText().isNullOrEmpty()){
            releasedate.setError("Field Empty")
            check = false;
        }
        return check
    }
    fun radio():String{
        var language = ""
        var id = radioGroup.checkedRadioButtonId
        when (id) {
            R.id.radioButton -> language = "English"
            R.id.radioButton2 -> language = "Chinese"
            R.id.radioButton3 -> language = "Malay"
            R.id.radioButton4 -> language = "Tamil"
        }
        return language
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.movieadd_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.clear){
             namefield.getText().clear()
             descfield.getText().clear()
             releasedate.getText().clear()
            if(suitableage.isChecked()) {
                suitableage.toggle()
            }
            violence.visibility= View.INVISIBLE
            languageUsed.visibility= View.INVISIBLE
             languageUsed.isChecked = false
            if(radio() != "English"){
                radioButton.setChecked(true);
            }
        }
        if(item?.itemId == R.id.addMovie){
            var suitable = ""
            var name = namefield.getText().toString()
            var description = descfield.getText().toString()
            var date = releasedate.getText().toString()
            if(suitableage.isChecked()) {
                if(violence.isChecked == true && languageUsed.isChecked == true)
                    suitable = "No (Violence, Language Used)"
                else if(violence.isChecked == true && languageUsed.isChecked == false)
                    suitable = "No (Violence)"
                else if(violence.isChecked == false && languageUsed.isChecked == true)
                    suitable = "No (Language Used)"
                else
                    suitable = "No"
            }
            else{
                suitable = "Yes"
            }
            if(btnValidate()==true) {
                val movieAL = applicationContext as movieList
                val newMovie = MovieDetailsClass()
                newMovie.setMovieTitle(name)
                newMovie.setMovieDesc(description)
                newMovie.setMovieLanguage(radio())
                newMovie.setMovieDate(date)
                newMovie.setMovieSuitable(suitable)
                if(languageUsed.isChecked == true){
                    newMovie.setMoviestrongLanguage(true)
                }
                else{
                    newMovie.setMoviestrongLanguage(false)
                }
                if(violence.isChecked == true){
                    newMovie.setMovieviolence(true)
                }
                else{
                    newMovie.setMovieviolence(false)
                }
                movieAL.AddMovie(newMovie)
                val intent = Intent(this, movieDetails::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
