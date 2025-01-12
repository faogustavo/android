package org.hackillinois.android.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import org.hackillinois.android.database.entity.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM events")
    fun getAllEvents(): LiveData<List<Event>>

    @Query("SELECT * FROM events")
    fun getAllEventsList(): List<Event>

    @Query("SELECT * FROM events WHERE name LIKE :name LIMIT 1")
    fun getEvent(name: String): LiveData<Event>

    @Query("SELECT * FROM events WHERE startTime <= :time AND endTime >= :time")
    fun getAllEventsHappeningAtTime(time: Long): LiveData<List<Event>>

    @Query("SELECT * FROM events WHERE startTime >= :startTime AND startTime < :endTime ORDER BY startTime")
    fun getEventsHappeningBetweenTimes(startTime: Long, endTime: Long): LiveData<List<Event>>

    @Query("DELETE FROM events")
    fun clearTable()

    @Transaction
    fun clearTableAndInsertEvents(events: List<Event>) {
        clearTable()
        insertAll(events)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: Event)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<Event>)

    @Delete
    fun delete(event: Event)
}
