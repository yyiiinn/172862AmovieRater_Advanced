package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.RatingBar
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_rater.*
import kotlinx.android.synthetic.main.activity_movie_rating.*
import android.content.SharedPreferences



class movieDetails : AppCompatActivity() {
//    class Details(title:String, overview:String, language:String, date:String, suitable:String){
//        var title: String
//        var overview: String
//        var language: String
//        var date: String
//        var suitable: String
//        init{
//            this.title = title
//            this.overview = overview
//            this.language = language
//            this.date = date
//            this.suitable = suitable
//        }
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        nameView.text =  "fgdf"
        descView.text =  "fdsf"
        languageView.text = "fd"
        dateView.text = "gfd"
        suitableView.text = "gfdgvd"
        registerForContextMenu(linear)
        var review = intent.getStringExtra("rating")
        var starrating = intent.getStringExtra("bar")
        val linearLayout = findViewById<LinearLayout>(R.id.linear)
        val movieInfo = applicationContext as MovieDetailsClass
        nameView.text =  movieInfo.getMovieTitle()
        descView.text =  movieInfo.getMovieDesc()
        languageView.text = movieInfo.getMovieLanguage()
        dateView.text = movieInfo.getMovieDate()
        suitableView.text = movieInfo.getMovieSuitable()
        if(review == null && starrating == null){
        var addreview = TextView(this)
        addreview.text = "add review"
        linearLayout.addView(addreview)
//        val textView = findViewById<TextView>(R.id.addReview).apply {
//            text = "add a review"
//        }
        }
        else {
            movieInfo.setMovierating(starrating.toFloat())
            movieInfo.setMovieReview(review)
            val ratingBar = RatingBar(this)
            ratingBar.numStars = 5
            ratingBar.setRating(starrating.toFloat())
            val showReview = TextView(this)
            showReview.textSize = 20f
            showReview.text = review
            linearLayout.addView(ratingBar)
            linearLayout.addView(showReview)

        }
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        getMenuInflater().inflate(R.menu.addreview_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.review){
            val intent = Intent(this, movieRating::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
