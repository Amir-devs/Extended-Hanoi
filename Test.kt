package com.example

fun a(lii : MutableList<String>)
{
    lii[1] = "hi"
    lii.removeAt(2)
}


fun main() {

    var l = mutableListOf<String>("a","b" , "d")
    l.add("c")
    println(l)

    a(l)
    print(l)

}