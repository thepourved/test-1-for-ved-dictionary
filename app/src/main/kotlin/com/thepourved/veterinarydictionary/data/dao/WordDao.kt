package com.thepourved.veterinarydictionary.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.thepourved.veterinarydictionary.data.entity.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("SELECT * FROM words WHERE id = :id")
    suspend fun getWordById(id: Int): Word?

    @Query("SELECT * FROM words ORDER BY farsiWord ASC")
    fun getAllWords(): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE farsiWord LIKE '%' || :query || '%' OR englishWord LIKE '%' || :query || '%'")
    fun searchWords(query: String): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE category = :category")
    fun getWordsByCategory(category: String): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE isFavorite = 1")
    fun getFavoriteWords(): Flow<List<Word>>

    @Query("SELECT DISTINCT category FROM words")
    fun getAllCategories(): Flow<List<String>>

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()
}