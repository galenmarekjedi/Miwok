package com.example.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class Colors : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemview)

        //creating data

        val wordList: ArrayList<Word> = arrayListOf()
        wordList.add(Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red))
        wordList.add(Word("green", "chokokki", R.drawable.color_green, R.raw.color_green))
        wordList.add(Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown))
        wordList.add(Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray))
        wordList.add(Word("black", "kululli", R.drawable.color_black, R.raw.color_black))
        wordList.add(Word("white", "kelelli", R.drawable.color_white, R.raw.color_white))
        wordList.add(Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow))
        wordList.add(Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow))

        val myadapter = WordAdapter(this,R.layout.specific_activity_layout, wordList)
        val listView = findViewById<ListView>(R.id.list_item)
        listView.adapter = myadapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val word = wordList.get(position)
                val mMediaPlayer = MediaPlayer.create(this, word.getAudioId())
                mMediaPlayer.start()

                mMediaPlayer.setOnCompletionListener( object: MediaPlayer.OnCompletionListener{
                    override fun onCompletion(mp: MediaPlayer?) {
                        mMediaPlayer.release()
                    }
                })

    }
}
}
