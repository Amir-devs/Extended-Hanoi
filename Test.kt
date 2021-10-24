package com.example

fun main() {

    var l = mutableListOf<String>("a","b")
    l.add("c")
    print(l[l.size-1])

}