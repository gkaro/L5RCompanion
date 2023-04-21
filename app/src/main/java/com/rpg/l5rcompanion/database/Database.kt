package com.rpg.l5rcompanion.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Clans::class,Families::class,Schools::class, Paths::class,CategoriesRules::class, Rules::class, Skills::class, Spells::class], version = 1, exportSchema = false)

abstract class MyDatabase : RoomDatabase(){
    abstract fun l5rCompanionDao() : L5rCompanionDao
}