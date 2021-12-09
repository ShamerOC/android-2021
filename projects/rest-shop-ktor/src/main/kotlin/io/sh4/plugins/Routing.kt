package io.sh4.plugins

import com.google.gson.Gson
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import io.sh4.models.Product
import product

fun Application.configureRouting() {

    routing {
        product()
        get("/") {
            val x : List<Product> = listOf(
                Product(1, "Product 1", 5, 12.45, "test"),
                Product(2, "Product 2", 10, 32.56, "test 2")
            )
            var gson = Gson()
            call.respondText(gson.toJson(x))
        }
    }
}
