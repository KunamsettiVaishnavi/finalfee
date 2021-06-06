package com.g3.spc.entities;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class FeeInstallment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feeInstallmentId;
	
	@Min(value = 0, message = "feeInstallment cannot be less than 0")
	@ApiModelProperty(name = "feeInstallment",value = "Holds feeInstallment amount ")
	private double feeInstallmentamt;
	
	@ApiModelProperty(required = true,example = "2021-01-02")
	private LocalDate dueDate;
	
	@ApiModelProperty(required = true,example = "2021-01-01")
	private LocalDate feePaymentDate;
	

	@ApiModelProperty(name = "fee",value = "Holds feeid")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="FeeId")
	private Fee fee;
	
	private int feeIdwtoPayment;
	
	public FeeInstallment() {
		super();
	// TODO Auto-generated constructor stub
	}
	



	public FeeInstallment(int feeInstallmentId,
			@Min(value = 0, message = "feeInstallment cannot be less than 1000") double feeInstallmentamt,
			LocalDate dueDate, LocalDate feePaymentDate, int feeIdwtoPayment) {
		super();
		this.feeInstallmentId = feeInstallmentId;
		this.feeInstallmentamt = feeInstallmentamt;
		this.dueDate = dueDate;
		this.feePaymentDate = feePaymentDate;
		this.feeIdwtoPayment = feeIdwtoPayment;
	}

	public int getFeeInstallmentId() {
		return feeInstallmentId;
	}
	public void setFeeInstallmentId(int feeInstallmentId) {
		this.feeInstallmentId = feeInstallmentId;
	}
	
	public double getFeeInstallmentamt() {
		return feeInstallmentamt;
	}



	public void setFeeInstallmentamt(double feeInstallmentamt) {
		this.feeInstallmentamt = feeInstallmentamt;
	}



	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getFeePaymentDate() {
		return feePaymentDate;
	}
	public void setFeePaymentDate(LocalDate feePaymentDate) {
		this.feePaymentDate = feePaymentDate;
	}
	
	public Fee getFee() {
		return fee;
	}



	public void setFee(Fee fee) {
		this.fee = fee;
	}



	











	@Override
	public String toString() {
		return "FeeInstallment [feeInstallmentId=" + feeInstallmentId + ", feeInstallmentamt=" + feeInstallmentamt
				+ ", dueDate=" + dueDate + ", feePaymentDate=" + feePaymentDate + ", fee=" + fee + ", feeIdwtoPayment="
				+ feeIdwtoPayment + "]";
	}




	public int getFeeIdwtoPayment() {
		return feeIdwtoPayment;
	}




	public void setFeeIdwtoPayment(int feeIdwtoPayment) {
		this.feeIdwtoPayment = feeIdwtoPayment;
	}


	

}



