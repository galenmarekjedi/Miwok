package com.example.miwok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class WordAdapter : ArrayAdapter<Word>
{

    constructor(context: Context, resource: Int, objects: ArrayList<Word>) : super(
        context,
        resource,
        objects
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView

        // Check if the existing view is being reused, otherwise inflate the view
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.specific_activity_layout
            , parent, false)
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        val currendWord = getItem(position)


        val miwokWordTextView = view!!.findViewById<TextView>(R.id.miwok)
        miwokWordTextView.text = currendWord!!.getMiwokWord()


        val englishWordTextView = view.findViewById<TextView>(R.id.eng)
        englishWordTextView.text = currendWord.getEnglishWord()


        val image = view.findViewById<ImageView>(R.id.image)
        if(currendWord.getPictureId() == 0) {
            image.visibility = View.GONE
        } else image.setImageResource(currendWord.getPictureId())


        return view
    }

}