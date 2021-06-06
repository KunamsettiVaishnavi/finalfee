package com.g3.spc.service;

import java.util.List;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.FeePaymentNotDoneException;

public interface IFeeInstallmentService {
	public FeeInstallment makePayment(FeeInstallment feeInstallment) throws FeePaymentNotDoneException;
	
	//in student
	public List<FeeInstallment> pendingInstallments(Student student);
	
	public FeeInstallment retrieveFeeInstallmentById(int id);
	// to be written in fee
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(Fee fee);
	
}
