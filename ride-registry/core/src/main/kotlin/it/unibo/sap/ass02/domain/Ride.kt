package it.unibo.sap.ass02.domain

import it.unibo.sap.ass02.domain.ddd.Entity
import it.unibo.sap.ass02.domain.model.EBike
import it.unibo.sap.ass02.domain.model.User
import it.unibo.sap.ass02.utils.RideSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable(with = RideSerializer::class)
sealed interface Ride : Entity<Int> {
    val ebike: EBike
    val user: User
    var endDate: LocalDate?
    var startedDate: LocalDate?

    fun start()

    fun end()
}
