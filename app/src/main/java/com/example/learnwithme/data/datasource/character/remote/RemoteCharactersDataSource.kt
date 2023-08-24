package com.example.learnwithme.data.datasource.character.remote

import com.example.learnwithme.data.datasource.CharacterDataSourceInterface
import com.example.learnwithme.data.datasource.character.remote.api.CharacterApiInterface
import com.example.learnwithme.data.datasource.character.remote.dto.toDomain
import com.example.learnwithme.domain.entity.Pagination
import com.example.learnwithme.manager.NetworkManager

class RemoteCharactersDataSource(
    private val characterApi: CharacterApiInterface,
    private val network: NetworkManager
): CharacterDataSourceInterface {

    override suspend fun getPagination(page: Int): Pagination {
        val response = network.load { characterApi.getCharacters(page) }
        return response.toDomain()
    }
}