package io.sh4.models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

data class Product(
    val id : Int? = null,
    val name : String,
    val qty : Int,
    val price : Double,
    val bio : String
    )

fun Product.isValid(): Boolean {
    return !this.name.isEmpty() &&
        !this.bio.isEmpty()
}

object Products : Table() {
    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val qty: Column<Int> = integer("qty")
    val price: Column<Double> = double("price")
    val bio: Column<String> = text("bio")

    override val primaryKey = PrimaryKey(id, name="PK_Product_ID")

    fun toProduct(row : ResultRow): Product =
        Product (
            id = row[Products.id],
            name = row[Products.name],
            qty = row[Products.qty],
            price = row[Products.price],
            bio = row[Products.bio]
                )

}
