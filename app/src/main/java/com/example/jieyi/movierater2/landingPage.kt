package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.android.synthetic.main.movieitem.*
import android.R.id.edit
import android.content.Context
import android.view.*
import kotlinx.android.synthetic.main.activity_movie_rater.*
import android.graphics.drawable.Drawable
import android.widget.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener


class landingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val list = applicationContext as movieList
        var movieArray = list.getMovieList()
        setContentView(R.layout.activity_landing_page)
        registerForContextMenu(movieList)

        if(movieArray.isNotEmpty()){
        val adapter = MovieAdapter(this, movieArray)
        movieList.adapter = adapter
            movieList.onItemClickListener = AdapterView.OnItemClickListener {parent, view, position, id ->
                // This is your listview's selected item
                val item = movieList.getItemAtPosition(position)
                textView8.text = item.toString()
            }
        }

        super.onCreate(savedInstanceState)
    }
    class MovieAdapter(private val context: Context,
                        private val dataSource: ArrayList<MovieDetailsClass>) : BaseAdapter() {
        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int{
            return dataSource.size
        }

        override fun getItem(position: Int):Any{
            return dataSource[position]
        }
        override fun getItemId(position: Int):Long{
            return position.toLong()
        }
        override fun getView(position: Int, convertView: View?, parent:ViewGroup):View{
            val rowView = inflater.inflate(R.layout.movieitem, parent,false)
            val titleView = rowView.findViewById(R.id.movieTitle) as TextView
            val movie = getItem(position) as MovieDetailsClass
            titleView.text = movie.getMovieTitle()
            return rowView
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.addmovie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add){
            val intent = Intent(this, movieRater::class.java)
            intent.putExtra("moviePosition", 0)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        getMenuInflater().inflate(R.menu.editlandingpage, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if(item?.itemId == R.id.edit){
            val intent = Intent(this, editMovie::class.java)
            intent.putExtra("position", info.id.toInt())
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }


}
