package com.example.routes

import com.example.data.Store
import com.example.data.model.Categories
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getProducts(){
    get("/products") {
        call.respond(
            HttpStatusCode.OK,
            Store.products
        )
    }
}

fun Route.getCategories(){
    get("/products/categories") {
        call.respond(
            HttpStatusCode.OK,
            Store.categories
        )
    }
}

fun Route.getProductsOfCategory() {
    get("/products/category/{category}"){
        val categorizedProducts = when(call.parameters["category"]){
            Categories.ALL -> Store.products
            Categories.WOMENS -> Store.products.filter { it.category == Categories.WOMENS }
            Categories.MENS -> Store.products.filter { it.category == Categories.MENS }
            Categories.KIDS -> Store.products.filter { it.category == Categories.KIDS }
            Categories.TECH -> Store.products.filter { it.category == Categories.TECH }
            Categories.JEWELRY -> Store.products.filter { it.category == Categories.JEWELRY }
            else -> emptyList()
        }
        call.respond(
            HttpStatusCode.OK,
            categorizedProducts
        )

    }
}