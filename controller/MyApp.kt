package com.example.controller

import com.example.style.Styles
import com.example.view.WelcomeView
import tornadofx.App

class MyApp: App(WelcomeView::class, Styles::class)