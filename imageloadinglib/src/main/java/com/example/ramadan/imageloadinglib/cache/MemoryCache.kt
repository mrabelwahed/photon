package com.example.ramadan.imageloadinglib.cache

import android.graphics.Bitmap
import android.support.v4.util.LruCache

object MemoryCache : ImageCache {

    private val cache : LruCache<String, Bitmap>

    init {
        val maxMemory = Runtime.getRuntime().maxMemory() /1024
        val cacheSize = (maxMemory/4).toInt()
      cache = object : LruCache<String, Bitmap>(cacheSize) {
          override fun sizeOf(key: String, value: Bitmap): Int {
              return (value.rowBytes)*(value.height)/1024
          }
      }
    }

    override fun put(url: String, bitmap: Bitmap) {
        cache.put(url,bitmap)
    }

    override fun get(url: String): Bitmap? {
      return  cache.get(url)
    }

    override fun clear() {
        cache.evictAll()
    }

}