package com.rorono.smarthouse.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rorono.smarthouse.models.ElectricalAppliance

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM appliances_table")
    fun getAllNotes(): LiveData<List<ElectricalAppliance>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(electricalAppliance: ElectricalAppliance)

    @Delete
    suspend fun delete(electricalAppliance: ElectricalAppliance)

}