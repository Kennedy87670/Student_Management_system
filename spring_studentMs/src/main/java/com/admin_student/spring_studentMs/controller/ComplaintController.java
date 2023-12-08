package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.ComplaintDto;
import com.admin_student.spring_studentMs.entity.Complaint;
import com.admin_student.spring_studentMs.errorAndException.ComplaintNotFoundException;
import com.admin_student.spring_studentMs.mapper.ComplaintMapper;
import com.admin_student.spring_studentMs.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private final ComplaintService complaintService;


    @GetMapping("/{id}")
    public ResponseEntity<ComplaintDto> getComplaintById(@PathVariable("id") Long complaintId) throws ComplaintNotFoundException {
        Optional<ComplaintDto> complaint = complaintService.getComplaintById(complaintId);
        if (complaint.isPresent()) {
            return new ResponseEntity<>(complaint.get(), HttpStatus.OK);
        } else {
            throw new ComplaintNotFoundException("Complaint not found with id" + complaintId);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ComplaintDto> saveComplaint(@RequestBody ComplaintDto complaintDto) {
        Complaint savedComplaint = complaintService.save(ComplaintMapper.mapToComplaint(complaintDto));
        return new ResponseEntity<>(ComplaintMapper.mapToComplaintDto(savedComplaint), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComplaintById(@PathVariable("id") Long complaintId) {
        complaintService.deleteComplaintById(complaintId);
        return new ResponseEntity<>("Complaint successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Complaint>> getComplaintsList() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplaintDto> updateComplaintById(@PathVariable("id") Long complaintId,
                                                            @RequestBody ComplaintDto updatedComplaintDto) throws ComplaintNotFoundException {
        ComplaintDto updatedComplaint = complaintService.updateComplaintById(complaintId, updatedComplaintDto);
        return ResponseEntity.ok(updatedComplaint);
    }
}
