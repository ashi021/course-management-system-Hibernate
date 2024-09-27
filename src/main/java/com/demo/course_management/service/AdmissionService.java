package com.demo.course_management.service;

import com.demo.course_management.entities.Admission;
import java.util.List;

public interface AdmissionService {
    void saveAdmission(Admission admission);
    void updateAdmission(Admission admission);
    void deleteAdmission(Long admissionId);
    Admission findAdmissionById(Long admissionId);
    List<Admission> findAllAdmissions();
}
