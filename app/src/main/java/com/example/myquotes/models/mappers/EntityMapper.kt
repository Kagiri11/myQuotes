package com.example.myquotes.models.mappers

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntry(entity: Entity): DomainModel

    fun mapToEntity(domainModel: DomainModel):Entity

}

