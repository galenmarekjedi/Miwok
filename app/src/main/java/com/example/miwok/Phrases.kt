package com.example.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class Phrases : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemview)

        val wordList: ArrayList<Word> = arrayListOf()
        wordList.add(Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going))
        wordList.add(Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name))
        wordList.add(Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is))
        wordList.add(Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling))
        wordList.add(Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good))
        wordList.add(Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming))
        wordList.add(Word("Yes, I’m coming", "hәә’ әәnәm", R.raw.phrase_yes_im_coming))
        wordList.add(Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming))
        wordList.add(Word("Let’s go", "yoowutis", R.raw.phrase_lets_go))
        wordList.add(Word("Come here", "әnni'nem", R.raw.phrase_come_here))

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
