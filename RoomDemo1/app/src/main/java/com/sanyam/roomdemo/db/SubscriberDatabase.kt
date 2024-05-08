package com.sanyam.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class],version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDAO : SubscriberDAO

    companion object{
      @Volatile
      private var INSTANCE : SubscriberDatabase? = null
      fun getInstance(context: Context):SubscriberDatabase {
          if (INSTANCE == null) {
              synchronized(this) {
                  if (INSTANCE == null) {
                      INSTANCE = Room.databaseBuilder(
                          context.applicationContext,
                          SubscriberDatabase::class.java,
                          "subscriber_data_database"
                      ).build()
                  }
              }
          }
          return INSTANCE as SubscriberDatabase
      }
    }
}

