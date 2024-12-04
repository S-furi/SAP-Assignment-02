package it.unibo.sap.ass02.domain

import it.unibo.sap.ass02.infrastructure.utils.JsonUtils
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Ride(
    val id: Int,
    val bike: EBike,
    val user: User,
    @Serializable(with = JsonUtils.LocalDateSerializer::class)
    val startedDate: LocalDate?,
    @Serializable(with = JsonUtils.LocalDateSerializer::class)
    val endDate: LocalDate?,
)