package com.example.learnwithme.data.datasource.character.database

import com.example.learnwithme.data.datasource.character.CharacterDataSourceInterface
import com.example.learnwithme.domain.entity.Character
import com.example.learnwithme.domain.entity.Pagination

class DatabaseCharacterDataSource(
): CharacterDataSourceInterface {
    override suspend fun getPagination(page: Int): Pagination {
        TODO("Not yet implemented")
    }

    override suspend fun getPaginationFor(text: String, page: Int): Pagination {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterWith(id: Int): Character? {
        TODO("Not yet implemented")
    }

}