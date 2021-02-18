package com.ifsp.prss6.schedule.controller;

import com.ifsp.prss6.schedule.model.request.ClientRequest;
import com.ifsp.prss6.schedule.model.request.DoctorRequest;
import com.ifsp.prss6.schedule.model.request.ScheduleRequest;
import com.ifsp.prss6.schedule.model.request.UserRequest;
import com.ifsp.prss6.schedule.model.response.ScheduleResponse;
import com.ifsp.prss6.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ifsp-prss6/manager-schedule/v1/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<Page<ScheduleResponse>> findPageable(Pageable pageable){
        return ResponseEntity.ok(scheduleService.findAllPageable(pageable));
    }

    @GetMapping(path = "/client")
    public ResponseEntity<List<ScheduleResponse>> findByClient(@Valid @RequestBody ClientRequest clientRequest){
        return ResponseEntity.ok(scheduleService.findByClient(clientRequest));
    }

    @GetMapping(path = "/doctor")
    public ResponseEntity<List<ScheduleResponse>> findByDoctor(@Valid @RequestBody DoctorRequest doctorRequest){
        return ResponseEntity.ok(scheduleService.findByDoctor(doctorRequest));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ScheduleResponse>> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ScheduleResponse> findById(@PathVariable String id){
        return ResponseEntity.ok(scheduleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ScheduleRequest scheduleRequest){
        scheduleService.save(scheduleRequest);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody ScheduleRequest scheduleRequest){
        scheduleService.update(scheduleRequest);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        scheduleService.delete(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
