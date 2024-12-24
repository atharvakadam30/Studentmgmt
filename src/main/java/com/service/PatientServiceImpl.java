package com.service;

import com.dao.DAO;
import com.pojo.Patient;

public class PatientServiceImpl implements PatientInterface{
	@Override
	public void register(Patient p) {
		
		DAO.insertPatientD(p);
		
	}

	@Override
	public boolean IsRegister (Patient p) {
		boolean b= DAO.checkId(p.getPid());
		return b;
		
	}

	@Override
	public void updateDetails (Patient p) {
		 DAO.updatePatient(p);
	}

	@Override
	public void deleteEntry(int pid) {
		DAO.deletePatient(pid);
		
	}

	@Override
	public void viewData() {
		DAO.viewAllPatients();
		
	}
}
