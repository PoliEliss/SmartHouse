package com.rorono.smarthouse.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "appliances_table")
data class ElectricalAppliance(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val title: String ="",
    @ColumnInfo val numberSocket: String=""
)


