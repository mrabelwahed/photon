package com.imageloadinglib.cache

import android.content.Context
import android.graphics.Bitmap
class CacheRepository (context: Context , newMaxSize: Int ): ImageCache{

    val diskCache = DiskCache.getInstance(context)
    val memoryCache = MemoryCache(newMaxSize)

    override fun put(url: String, bitmap: Bitmap) {
        memoryCache.put(url,bitmap)
        diskCache.put(url,bitmap)
    }

    override fun get(url: String): Bitmap? {
        return memoryCache.get(url)?:diskCache.get(url)
    }

    override fun clear() {
        memoryCache.clear()
        diskCache.clear()
    }
}