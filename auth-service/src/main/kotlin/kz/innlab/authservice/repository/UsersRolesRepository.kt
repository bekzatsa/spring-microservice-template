package kz.innlab.authservice.repository

import kz.innlab.authservice.model.UsersRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional
import java.util.*

/**
 * @project microservice-template
 * @author Bekzat Sailaubayev on 13.04.2022
 */
interface UsersRolesRepository: JpaRepository<UsersRoles, UUID> {

    @Transactional
    fun deleteAllByUserId(userId: UUID): Long
}
