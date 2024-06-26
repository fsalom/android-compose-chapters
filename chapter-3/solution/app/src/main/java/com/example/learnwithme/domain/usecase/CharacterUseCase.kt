package com.example.learnwithme.domain.usecase

import com.example.learnwithme.domain.CharacterRepositoryInterface
import com.example.learnwithme.domain.entity.Character

class CharacterUseCase(val repository: CharacterRepositoryInterface): CharacterUseCaseInterface {
    override suspend fun getNextPageAndCharacters(
        page: Int
    ): Pair<Boolean, List<Character>> {
        var pagination = repository.getPagination(page)
        return Pair(pagination.hasNextPage, pagination.characters)
    }

    override suspend fun getNextPageAndCharactersWith(
        text: String,
        page: Int
    ): Pair<Boolean, List<Character>> {
        var pagination = repository.getPaginationFor(text, page)
        return Pair(pagination.hasNextPage, pagination.characters)
    }

    override suspend fun getCharacterWith(id: Int): Character? {
        return repository.getCharacterWith(id)
    }
}