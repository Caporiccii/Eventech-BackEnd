package com.bandtech.eventech.Repository.V3;

import com.bandtech.eventech.model.V3.UserTicketJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserTicketRepository extends JpaRepository<UserTicketJPA, Integer> {

    @Query(value = "select * from user_ticketjpa where user_ticketjpa.user_id = user_id and user_ticketjpa.status_id = status_id", nativeQuery = true)
    List<UserTicketJPA> getUserTicketByUserIdAndStatus(@Param("user_id") Integer userId, @Param("status_id") Integer statusId);
}
