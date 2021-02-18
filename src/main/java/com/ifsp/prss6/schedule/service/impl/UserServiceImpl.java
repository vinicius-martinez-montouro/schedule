package com.ifsp.prss6.schedule.service.impl;

import com.ifsp.prss6.schedule.exception.BadRequestException;
import com.ifsp.prss6.schedule.exception.PreconditionException;
import com.ifsp.prss6.schedule.model.entity.User;
import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ClientResponse;
import com.ifsp.prss6.schedule.model.response.DoctorResponse;
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
    public ClientResponse findClientById(String id) {
        return userRepository.findById(id).map(ClientResponse::fromClient)
                .orElseThrow(() -> new BadRequestException("Client not found"));
    }

    @Override
    public DoctorResponse findDoctorById(String id) {
        return userRepository.findById(id).map(DoctorResponse::fromDoctor)
                .orElseThrow(() -> new BadRequestException("Client not found"));
    }

    @Override
    public void save(UserRequest userRequest) {
        if(userRepository.findByCpf(userRequest.getCpf()) != null)
            throw new PreconditionException("User ready registred");
        userRequest.setId(null);
        userRepository.save(fromUserRequest(userRequest));
    }

    @Override
    public void saveClient(ClientRequest clientRequest) {
        if(userRepository.findByCpf(clientRequest.getCpf()) != null)
            throw new PreconditionException("Client ready registred");
        clientRequest.setId(null);
        userRepository.save(fromUserRequest(clientRequest));
    }

    @Override
    public void saveDoctor(DoctorRequest doctorRequest) {
        if(userRepository.findByCpf(doctorRequest.getCpf()) != null)
            throw new PreconditionException("Doctor ready registred");
        doctorRequest.setId(null);
        userRepository.save(fromUserRequest(doctorRequest));
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
