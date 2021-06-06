package com.g3.spc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.repository.IFeeInstallmentRepository;
import com.g3.spc.repository.IFeeRepository;

@SpringBootTest
public class FeeInstallmentServiceImplTest {
	
	IFeeInstallmentRepository repo1;
	
	private static IFeeInstallmentServiceImpl feeInsService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit() {
		repo1 = mock(IFeeInstallmentRepository.class);
		
		
		feeInsService = new IFeeInstallmentServiceImpl(repo1);
		
		
		ac = MockitoAnnotations.openMocks(this);
		
	}
	@AfterEach
	public void doEnd() throws Exception{
		ac.close();
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Test-Save FeeInstallment")
	void testretrieveFeeInstallmentById() {
		FeeInstallment input = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);

		when(repo1.findById(101)).thenReturn(Optional.of(input));
		FeeInstallment output = feeInsService.retrieveFeeInstallmentById(101);
		assertEquals(input,output);
		
	}
	
	

}
