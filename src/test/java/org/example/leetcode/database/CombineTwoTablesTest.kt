package org.example.leetcode.database

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.jdbc.Sql
import kotlin.test.assertEquals


@TestPropertySource(locations = ["classpath:tests.properties"])
@Sql(scripts = ["classpath:/sql/CombineTwoTables.sql"])
@JdbcTest
open class CombineTwoTablesTest {

    @Autowired
    private lateinit var db: JdbcTemplate

    private lateinit var combineService: CombineTwoTables

    @Test
    fun combineTest() {

        combineService = CombineTwoTables(db)

        val expectedR: List<ResultCombineTwoTables> = db.query(
            "select * from result"
        ) { response, _ ->
            ResultCombineTwoTables(
                response.getString("first_name"),
                response.getString("last_name"),
                response.getString("city"),
                response.getString("state")
            )
        }

        assertEquals(expectedR, combineService.combine())
    }

}