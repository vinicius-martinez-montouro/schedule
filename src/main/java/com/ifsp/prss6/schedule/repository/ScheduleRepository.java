package com.ifsp.prss6.schedule.repository;

import com.ifsp.prss6.schedule.model.entity.Schedule;
import com.ifsp.prss6.schedule.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author vinicius.montouro
 * Class repository of Schedule
 */
public interface ScheduleRepository extends MongoRepository<Schedule,String> {

    /**
     * Search Schedule by User Id
     * @param userId
     * @return Schedule
     */
    List<Schedule> findByUserId(String userId);

    /**
     * Search Schedule by User
     * @param user
     * @return Schedule
     */
    List<Schedule> findByUser(User user);
}
