package com.ifsp.prss6.schedule.service.impl;

import com.ifsp.prss6.schedule.exception.BadRequestException;
import com.ifsp.prss6.schedule.exception.PreconditionException;
import com.ifsp.prss6.schedule.model.entity.User;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.UserResponse;
import com.ifsp.prss6.schedule.repository.UserRepository;
import com.ifsp.prss6.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ifsp.prss6.schedule.model.entity.User.fromUserRequest;
import static com.ifsp.prss6.schedule.model.entity.User.fromUserResponse;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponse::fromUser)
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserResponse> findAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserResponse::fromUser);
    }

    @Override
    public UserResponse findById(String id) {
        return userRepository.findById(id).map(UserResponse::fromUser)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public void save(UserRequest userRequest) {
        userRequest.setId(null);
        userRepository.save(fromUserRequest(userRequest));
    }

    @Override
    public void update(UserRequest userRequest) {
        if(userRequest.getId() == null)
            throw new PreconditionException("Id user invalid");
        UserResponse userSave = findById(userRequest.getId());
        User userUpdate = fromUserRequest(userRequest);
        userUpdate.set_id(userSave.getId());
        userRepository.save(userUpdate);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(fromUserResponse(findById(id)));
    }
}
