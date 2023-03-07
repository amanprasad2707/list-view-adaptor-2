package com.example.listviewadaptor2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya", "Aman", "Ankit", "Rahul", "Mohit")
        val lastMsg = arrayOf("Hey what's up!", "I am fine", "good", "What's going on?", "cool")
        val lastMsgTime = arrayOf("4:50 AM", "9:00 PM", "5:12 PM", "8:45 AM", "7:34 AM")
        val phoneNumber = arrayOf("4545464555", "3456754345" ,"9867584736", "5468792153", "8974563215")
        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic4, R.drawable.pic3, R.drawable.pic0, R.drawable.pic1)

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = user(name[eachIndex], lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imgId[eachIndex])
            userArrayList.add(user)

        }
        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdaptor(this, userArrayList)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            // open a new activity
            val userName = name[i]
            val userPhone = phoneNumber[i]
            val imgId = imgId[i]
            val intent = Intent(this, UserActivity :: class.java)
            intent.putExtra("name",userName)
            intent.putExtra("phone", userPhone)
            intent.putExtra("imageId", imgId)
            startActivity(intent)
        }
    }
}