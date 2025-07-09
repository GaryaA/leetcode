package org.example.leetcode.database

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CombineTwoTables(private val db: JdbcTemplate) {

    fun combine(): List<ResultCombineTwoTables> = db.query(
        "select p.first_name, p.last_name, a.city, a.state from person p left join address a on p.id = a.person_id"
    ) { response, _ ->
        ResultCombineTwoTables(
            response.getString("first_name"),
            response.getString("last_name"),
            response.getString("city"),
            response.getString("state")
        )
    }

}

data class ResultCombineTwoTables(val firstName: String, val lastName: String, val city: String?, val state: String?)

private data class Person(val id: Int, val firstName: String, val lastName: String)
private data class Address(val id: Int, val personId: Int, val city: String, val state: String)