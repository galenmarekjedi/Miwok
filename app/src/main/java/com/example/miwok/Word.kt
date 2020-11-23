package com.example.miwok

class Word {
    private var miwokWord: String
    private var englishWord: String
    private var pictureId = 0
    private var audioId = 0

    constructor(eng: String, miwok: String, picId: Int, audId: Int){
        miwokWord = miwok
        englishWord = eng
        pictureId = picId
        audioId = audId
    }

    constructor(eng: String, miwok: String, audio: Int){
        miwokWord = miwok
        englishWord = eng
        audioId = audio
    }


    fun getMiwokWord() = miwokWord
    fun getEnglishWord() = englishWord
    fun getPictureId() = pictureId
    fun getAudioId() = audioId
}