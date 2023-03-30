package com.example.plugins

import com.example.routes.getCategories
import com.example.routes.getProducts
import com.example.routes.getProductsOfCategory
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*



fun Application.configureRouting() {

    routing {
        getProducts()
        getCategories()
        getProductsOfCategory()
        static() {
            resources("static")
        }
    }
}