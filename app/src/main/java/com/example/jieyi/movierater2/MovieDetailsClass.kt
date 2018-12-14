package com.example.jieyi.movierater2

import android.app.Application
import java.util.*

class MovieDetailsClass: Application(){
    var title: String = ""
    var desc: String = ""
    var language: String = ""
    var date: String = ""
    var suitable: String = ""
    var strongLanguage:Boolean = false
    var violence:Boolean = false
    var rating:Float = 0.0f
    var review:String = ""

    fun getMovieTitle():String{
        return title
    }
    fun setMovieTitle(title:String){
        this.title = title
    }
    fun getMovieDesc():String{
        return desc
    }
    fun setMovieDesc(desc:String){
        this.desc = desc
    }
    fun getMovieLanguage():String{
        return language
    }
    fun setMovieLanguage(language:String){
        this.language = language
    }
    fun getMovieDate():String{
        return date
    }
    fun setMovieDate(date:String){
        this.date = date
    }
    fun getMovieSuitable():String{
        return suitable
    }
    fun setMovieSuitable(suitable:String){
        this.suitable = suitable
    }
    fun getMoviestrongLanguage():Boolean{
        return strongLanguage
    }
    fun setMoviestrongLanguage(strongLanguage:Boolean){
        this.strongLanguage = strongLanguage
    }
    fun getMovieviolence():Boolean{
        return violence
    }
    fun setMovieviolence(violence:Boolean){
        this.violence = violence
    }
    fun getMovierating():Float{
        return rating
    }
    fun setMovierating(rating:Float ){
        this.rating = rating
    }
    fun getMovieReview():String{
        return review
    }
    fun setMovieReview(review:String){
        this.review = review
    }
}