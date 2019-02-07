package org.hackillinois.android.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import org.hackillinois.android.database.Converters

@Entity(tableName = "roles")
@TypeConverters(Converters::class)
data class Roles(
        @ColumnInfo(name = "id") var id: String,
        @ColumnInfo(name = "roles") var roles: List<String>
): BaseEntity() {

    // makes roles a singleton in the database
    // TODO: make id primary key, maybe hold id of current user in App?
    @PrimaryKey @ColumnInfo(name = "key") var key = 1

    override fun toString() = super.toString() + " " + lastRefreshed
}