package com.demo.course_management.serviceImpl;

import com.demo.course_management.dao.AdmissionDao;
import com.demo.course_management.daoImpl.AdmissionDaoImpl; // Import the implementation
import com.demo.course_management.entities.Admission;
import com.demo.course_management.service.AdmissionService;

import java.util.List;

public class AdmissionServiceImpl implements AdmissionService {

    private AdmissionDao admissionDao;

    // Constructor to initialize the AdmissionDao
    public AdmissionServiceImpl() {
        this.admissionDao = new AdmissionDaoImpl(); // Instantiate directly
    }

    @Override
    public void saveAdmission(Admission admission) {
        admissionDao.saveAdmission(admission);
    }

    @Override
    public void updateAdmission(Admission admission) {
        admissionDao.updateAdmission(admission);
    }

    @Override
    public void deleteAdmission(Long admissionId) {
        admissionDao.deleteAdmission(admissionId);
    }

    @Override
    public Admission findAdmissionById(Long admissionId) {
        return admissionDao.findAdmissionById(admissionId);
    }

    @Override
    public List<Admission> findAllAdmissions() {
        return admissionDao.findAllAdmissions();
    }
}
