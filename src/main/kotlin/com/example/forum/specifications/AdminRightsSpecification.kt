package com.example.forum.specifications

import com.example.forum.models.user.Users
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


class AdminRightsSpecification(
    private val role: String? = null
): Specification<Users?>{
    override fun toPredicate(
        root: Root<Users?>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        query.orderBy(criteriaBuilder.asc(root.get<Long>("id")))
        query.distinct(true)

        val predicates = mutableListOf<Predicate>()
        if(role != null){
            predicates.add(criteriaBuilder.equal(root.get<String>("role"), role))
        }

        return criteriaBuilder.and(*predicates.toTypedArray())
    }

}