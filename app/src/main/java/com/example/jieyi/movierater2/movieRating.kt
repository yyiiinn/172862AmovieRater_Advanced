package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_rating.*

class movieRating : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)
        val movieInfo = applicationContext as MovieDetailsClass
        val textView = findViewById<TextView>(R.id.textView6).apply {
            text = "Enter your review for the movie: " +  movieInfo.getMovieTitle()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.addrating_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.submit) {
            val rating = review.text.toString()
            val msg = ratingBar.rating.toString()
            val intent = Intent(this, movieDetails::class.java)
            intent.putExtra("rating", rating);
            intent.putExtra("bar", msg)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)

    }
}
