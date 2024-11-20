package it.unibo.sap.ass02.domain

import it.unibo.sap.ass02.domain.model.EBike
import it.unibo.sap.ass02.domain.model.User
import java.time.LocalDate

class RideImpl(
    override val ebike: EBike,
    override val user: User,
    override var startedDate: LocalDate? = null,
    override var endDate: LocalDate? = null,
    override val id: Int,
) : Ride {
    override fun start() {
        this.startedDate = LocalDate.now()
    }

    override fun end() {
        this.endDate = LocalDate.now()
    }
}