package com.imageloadinglib.cache

import android.content.Context
import android.graphics.Bitmap

class CacheRepository (context: Context): ImageCache{

    val diskCache = DiskCache.getInstance(context)

    override fun put(url: String, bitmap: Bitmap) {
        MemoryCache.put(url,bitmap)
        diskCache.put(url,bitmap)
    }

    override fun get(url: String): Bitmap? {
        return MemoryCache.get(url)?:diskCache.get(url)
    }

    override fun clear() {
        MemoryCache.clear()
        diskCache.clear()
    }
}