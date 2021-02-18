package com.ifsp.prss6.schedule.service;

import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ClientResponse;
import com.ifsp.prss6.schedule.model.response.DoctorResponse;
import com.ifsp.prss6.schedule.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author vinicius.montouro
 */
public interface UserService {
    /**
     * seach all users
     * @return UserResponse
     */
    List<UserResponse> findAll();

    /**
     * Search all user pageable
     * @param pageable
     * @return Page UserResponse
     */
    Page<UserResponse> findAllPageable(Pageable pageable);

    /**
     * Search User by id
     * @param id
     * @return UserResponse
     */
    UserResponse findById(String id);

    /**
     * Search Client by id
     * @param id
     * @return UserResponse
     */
    ClientResponse findClientById(String id);

    /**
     * Search Doctor by id
     * @param id
     * @return UserResponse
     */
    DoctorResponse findDoctorById(String id);

    /**
     * Save new User
     * @param userRequest
     */
    void save(UserRequest userRequest);

    /**
     * Save new Client
     * @param userRequest
     */
    void saveClient(ClientRequest clientRequest);

    /**
     * Save new Doctor
     * @param userRequest
     */
    void saveDoctor(DoctorRequest doctorRequest);

    /**
     * Update User
     * @param userRequest
     */
    void update(UserRequest userRequest);

    /**
     * Delete user by id
     * @param id
     */
    void delete(String id);
}
