package com.sanyam.coroutinesdemo1

import kotlinx.coroutines.*

class UserDataManager {

    suspend fun getTotalUserCount():Int {
        var count = 10
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 700
        }

        return count + deferred.await()
    }

}