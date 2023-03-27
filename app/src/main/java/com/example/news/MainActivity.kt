package com.example.news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView:RecyclerView
    lateinit var myArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        myRecyclerView=findViewById<RecyclerView>(R.id.recyclerView)

        val images= arrayOf(R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6)

        val heading= arrayOf("U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra")

        val content= arrayOf(getString(R.string.newsText),
            getString(R.string.newsText),
            getString(R.string.newsText),
            getString(R.string.newsText),
            getString(R.string.newsText),
            getString(R.string.newsText),
            getString(R.string.newsText)
        )

        // for deciding layout of the recycler view like horizontal or vertical
        myRecyclerView.layoutManager=LinearLayoutManager(this)
        myArrayList=ArrayList<News>()

        for(index in images.indices){
            val news= News(heading[index],images[index],content[index])
            myArrayList.add(news)
        }
        // we have to make relation between data and recycler view so we use adapter concept
        var adapter =MyAdapter(myArrayList,this)
        myRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity,NewsDetials::class.java)
                intent.putExtra("heading",myArrayList[position].newsHeading)
                intent.putExtra("image",myArrayList[position].newsImage)
                intent.putExtra("context",myArrayList[position].newsContent)
                startActivity(intent)
            }

        })

    }
}