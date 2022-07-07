package com.highright.coroutines

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")