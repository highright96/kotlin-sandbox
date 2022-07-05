package com.highright.coroutines.coroutine_context_and_dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    // context of the parent, main runBlocking coroutine
    launch {
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }

    // not confined -- will work with main thread
    launch(Dispatchers.Unconfined) {
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }

    // will get dispatched to DefaultDispatcher
    launch(Dispatchers.Default) {
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }

    // will get its own new thread
    launch(newSingleThreadContext("MyOwnThread")) {
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }
}