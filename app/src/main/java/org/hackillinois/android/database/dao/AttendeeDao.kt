package org.hackillinois.android.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import org.hackillinois.android.database.entity.Attendee

@Dao
interface AttendeeDao {
    @Query("SELECT * FROM attendees LIMIT 1")
    fun getAttendee(): LiveData<Attendee>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(attendee: Attendee)

    @Delete
    fun delete(attendee: Attendee)
}
