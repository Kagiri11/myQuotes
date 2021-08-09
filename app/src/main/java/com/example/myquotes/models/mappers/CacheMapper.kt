package com.example.myquotes.models.mappers

import com.example.myquotes.models.CachedQuoteEntity
import com.example.myquotes.models.Quote
import javax.inject.Inject

class CacheMapper
    @Inject
    constructor() : EntityMapper<CachedQuoteEntity,Quote> {

    override fun mapFromEntry(entity: CachedQuoteEntity): Quote {
        return Quote(
            id = entity.id,
            message = entity.message,
            author = entity.author
        )
    }

    override fun mapToEntity(domainModel: Quote): CachedQuoteEntity {
        return CachedQuoteEntity(
            id = domainModel.id,
            message = domainModel.message,
            author = domainModel.author
        )
    }
}