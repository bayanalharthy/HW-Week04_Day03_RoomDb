package com.shady.room

import androidx.annotation.WorkerThread
import com.example.roomwordsample.Word

class WordRepository {
    fun insert(word: Word) {

    }

    val allWords: Any = TODO()

    // Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
    class WordRepository(private val wordDao: WordDaoo) {

        // Room executes all queries on a separate thread.
        // Observed Flow will notify the observer when the data has changed.
        val allWords: Unit = wordDao.getAlphabetizedWords()

        // By default Room runs suspend queries off the main thread, therefore, we don't need to
        // implement anything else to ensure we're not doing long running database work
        // off the main thread.
        @Suppress("RedundantSuspendModifier")
        @WorkerThread
        suspend fun insert(word: Word) {
            wordDao.insert(word)
        }
    }
}