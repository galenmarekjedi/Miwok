package com.example.miwok

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class Family_Members : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemview)

        val wordList: ArrayList<Word> = arrayListOf()
        wordList.add(Word("father", "әpә", R.drawable.family_father, R.raw.family_father))
        wordList.add(Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother))
        wordList.add(Word("son", "angsi", R.drawable.family_son, R.raw.family_son))
        wordList.add(Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter))
        wordList.add(Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother))
        wordList.add(Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother))
        wordList.add(Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister))
        wordList.add(Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister))
        wordList.add(Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother))
        wordList.add(Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather))

        val myadapter = WordAdapter(this,R.layout.specific_activity_layout, wordList)
        val listView = findViewById<ListView>(R.id.list_item)
        listView.adapter = myadapter

        listView.onItemClickListener = AdapterView.OnItemClickListener {parent, view, position, id ->
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
