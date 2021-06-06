package com.g3.spc.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Fee Bean")
public class Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FeeId;
	
	@ApiModelProperty(name = "totalFeesDue",value = "Holds total fee due")
	private double totalFeesDue;
	
	@Min(value = 0, message = "Fee cannot be less than 0")
	@ApiModelProperty(name = "totalFeesReceived",value = "Holds total Fees Received ")
	private double totalFeesReceived;
	
	@Min(value = 0, message = "Fee cannot be less than 0")
	@ApiModelProperty(name = "totalFees",value = "Holds total Fees")
	private double totalFees;
	
	
	@ApiModelProperty(name = "feeinstallment",value = "Holds feeinstallment amount")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="FeeId")	
	private List<FeeInstallment> feeinstallment;
	
	public Fee() {
		super();

	}

	public Fee(int feeId,  double totalFeesDue,
			double totalFeesReceived,
			 double totalFees,
			List<FeeInstallment> feeinstallment) {
		super();
		FeeId = feeId;
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.totalFees = totalFees;
		this.feeinstallment = feeinstallment;
	}

	public double getTotalFeesDue() {
		return totalFeesDue;
	}
	public void setTotalFeesDue(double totalFeesDue) {
		this.totalFeesDue = totalFeesDue;
	}
	public double getTotalFeesReceived() {
		return totalFeesReceived;
	}
	public void setTotalFeesReceived(double totalFeesReceived) {
		this.totalFeesReceived = totalFeesReceived;
	}

	public int getFeeId() {
		return FeeId;
	}
	public void setFeeId(int feeId) {
		FeeId = feeId;
	
	}
	
	
	public List<FeeInstallment> getFeeinstallment() {
		return feeinstallment;
	}

	public void setFeeinstallment(List<FeeInstallment> feeinstallment) {
		this.feeinstallment = feeinstallment;
	}
	public double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FeeId;
		result = prime * result + ((feeinstallment == null) ? 0 : feeinstallment.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalFees);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFeesDue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFeesReceived);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fee other = (Fee) obj;
		if (FeeId != other.FeeId)
			return false;
		if (feeinstallment == null) {
			if (other.feeinstallment != null)
				return false;
		} else if (!feeinstallment.equals(other.feeinstallment))
			return false;
		if (Double.doubleToLongBits(totalFees) != Double.doubleToLongBits(other.totalFees))
			return false;
		if (Double.doubleToLongBits(totalFeesDue) != Double.doubleToLongBits(other.totalFeesDue))
			return false;
		if (Double.doubleToLongBits(totalFeesReceived) != Double.doubleToLongBits(other.totalFeesReceived))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fee [FeeId=" + FeeId + ", totalFeesDue=" + totalFeesDue + ", totalFeesReceived=" + totalFeesReceived
				+ ", totalFees=" + totalFees + ", feeinstallment=" + feeinstallment + "]";
	}

}