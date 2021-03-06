package kz.innlab.userservice.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import java.util.ArrayList
import javax.persistence.*
import kotlin.jvm.Transient

/**
 * @project microservice-template
 * @author Bekzat Sailaubayev on 09.03.2022
 */
@Entity(name = "USER_DETAILS")
@Table(name = "USER_DETAILS")
@JsonIgnoreProperties(value = ["password", "path", "rolesCollection"], allowGetters = false)
class Account: Auditable<String?>() {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    var id: UUID? = null

    @Column(name = "USER_ID", columnDefinition = "UUID", nullable = false)
    var userId: UUID? = null

    @Column(name = "FIRST_NAME", columnDefinition = "character varying")
    var firstName: String? = null

    @Column(name = "LAST_NAME", columnDefinition = "character varying")
    var lastName: String? = null

    @Column(name = "MIDDLE_NAME", columnDefinition = "character varying")
    var middleName: String? = null

    var avatar: UUID? = null

    @Transient
    var fio: String? = null
        get() {
            val result: ArrayList<String> = arrayListOf(firstName!!, lastName!!)
            if (middleName != null && middleName!!.isNotEmpty()) {
                result.add(middleName!!)
            }
            return result.joinToString(" ").trim()
        }

    @Transient
    var roles: List<String> = arrayListOf()

    @Transient
    var email: String? = null
}
