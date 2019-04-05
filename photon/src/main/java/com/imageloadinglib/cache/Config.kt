package com.imageloadinglib.cache

class Config {
    companion object {
        val maxMemory = Runtime.getRuntime().maxMemory() /1024
        val defaultCacheSize = (maxMemory/4).toInt()
    }
}