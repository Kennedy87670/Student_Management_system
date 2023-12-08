package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.ComplaintDto;
import com.admin_student.spring_studentMs.entity.Complaint;
import com.admin_student.spring_studentMs.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintServiceImp implements ComplaintService {
    @Override
    public Optional<ComplaintDto> getComplaintById(Long complaintId) {
        return Optional.empty();
    }

    @Override
    public Complaint save(Complaint complaint) {
        return null;
    }

    @Override
    public void deleteComplaintById(Long complaintId) {

    }

    @Override
    public List<Complaint> getAllComplaints() {
        return null;
    }

    @Override
    public ComplaintDto updateComplaintById(Long complaintId, ComplaintDto updatedComplaintDto) {
        return null;
    }
}

//
//
//    @Override
//    public void fileComplaint(Long studentId, String complaintText) throws StudentNotFoundException {
//        Optional<Students> optionalStudent = studentsRepository.findById(studentId);
//
//        if (optionalStudent.isPresent()) {
//            Students student = optionalStudent.get();
//
//            Complaint complaint = new Complaint();
//            complaint.setStudent(student);
//            complaint.setComplaintText(complaintText);
//
//            // Save the complaint
//            complaintRepository.save(complaint);
//        } else {
//            throw new StudentNotFoundException("Student not found with id: " + studentId);
//        }
//    }
//
//    @Override
//    public List<String> getAllComplaints() {
//        List<Complaint> complaints = complaintRepository.findAll();
//        List<String> complaintTexts = new ArrayList<>();
//
//        for (Complaint complaint : complaints) {
//            complaintTexts.add(complaint.getComplaintText());
//        }
//
//        return complaintTexts;
//    }
//
//    @Override
//    public void resolveComplaint(Long complaintId) {
//        // Implement logic to mark a complaint as resolved or remove it from the system
//        // You can use complaintRepository.findById(complaintId) and update the status or delete the complaint
//        // based on your requirements.
//    }
//}