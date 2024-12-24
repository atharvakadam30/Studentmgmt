package com.service;

import com.pojo.Patient;

public interface PatientInterface {
	public void register(Patient p);
	public boolean IsRegister(Patient p);
	void updateDetails(Patient p);
	public void deleteEntry(int pid);
	public void viewData();



}
