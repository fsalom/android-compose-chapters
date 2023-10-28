package com.example.learnwithme.data.datasource.character.database.room.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learnwithme.domain.entity.Character
import com.example.learnwithme.manager.database.BaseEntity

@Entity(tableName = "Characters")
data class CharacterEntity(
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val image: String? = null,
    var isFavorite: Boolean = false,
    val page: Int = 0,
    @ColumnInfo(name = "created_at") val creationDate: Long = System.currentTimeMillis(),
    @PrimaryKey override val id: Int
) : BaseEntity() {

    companion object {
        fun create(character: Character, page: Int): CharacterEntity {
            return CharacterEntity(
                id = character.id,
                name = character.name,
                status = character.status,
                species = character.species,
                image = character.image,
                page = page
            )
        }
    }
}

fun CharacterEntity.toDomain(): Character =
    Character(
        id = id ?: 0,
        name = name ?: "",
        status = status ?: "",
        species = species ?: "",
        image = image ?: "",
        isFavorite = isFavorite,
        creationDate = creationDate
    )