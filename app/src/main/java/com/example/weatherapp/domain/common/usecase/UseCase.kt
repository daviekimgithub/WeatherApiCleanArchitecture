package com.example.weatherapp.domain.common.usecase

import com.example.weatherapp.domain.common.Response
import kotlinx.coroutines.flow.Flow

interface UseCase<in Input, Output> {
    suspend fun execute(input: Input): Response<Output>
}

interface UseCaseWithoutResponse<in Input, Output> {
    suspend fun execute(input: Input): Output
}

interface UseCaseNoInput<Output> {
    suspend fun execute(): Response<Output>
}

interface UseCaseFlow<in Input, Output> {
    fun execute(input: Input): Flow<Response<Output>>
}

interface UseCaseNoInputFlow<Output> {
    fun execute(): Flow<Response<Output>>
}
