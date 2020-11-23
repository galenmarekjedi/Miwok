package com.example.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class Numbers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemview)

        val wordList: ArrayList<Word> = arrayListOf()
        wordList.add(Word("one", "lutti", R.drawable.number_one, R.raw.number_one))
        wordList.add(Word("two", "otiiko", R.drawable.number_two, R.raw.number_two))
        wordList.add(Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three))
        wordList.add(Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four))
        wordList.add(Word("five", "massokka", R.drawable.number_five, R.raw.number_five))
        wordList.add(Word("six", "temnokka", R.drawable.number_six, R.raw.number_six))
        wordList.add(Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven))
        wordList.add(Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight))
        wordList.add(Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine))
        wordList.add(Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten))

        val myadapter = WordAdapter(this,R.layout.specific_activity_layout, wordList)
        val listView = findViewById<ListView>(R.id.list_item)
        listView.adapter = myadapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
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
