package com.demo.course_management.dao;

import com.demo.course_management.entities.Admission;
import java.util.List;

public interface AdmissionDao {
    void saveAdmission(Admission admission);
    void updateAdmission(Admission admission);
    void deleteAdmission(Long admissionId);
    Admission findAdmissionById(Long admissionId);
    List<Admission> findAllAdmissions();
}
