package com.g3.spc.service;

import java.util.List;
import java.util.Optional;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.entities.Student;

public interface IFeeService {
		public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
		
		public Fee addFee(Fee fee);
		public Fee deleteFee(Fee fee);
		public Fee updateFee(Fee fee);
		public Fee retrieveFee(int id);
		
		public Fee retrieveFeeByStudent(Student student);
		public List<Fee> retrieveAllFeeByMonth(int month);
		
		
		

}
