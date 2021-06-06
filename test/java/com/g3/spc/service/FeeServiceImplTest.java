package com.g3.spc.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.DiaryNotes;
import com.g3.spc.entities.Fee;
import com.g3.spc.entities.FeeInstallment;
import com.g3.spc.repository.IFeeRepository;
import com.g3.spc.service.IFeeServiceImpl;

@SpringBootTest
public class FeeServiceImplTest {
	
	IFeeRepository feerepo;
	
	private static IFeeServiceImpl feeService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit() {
		feerepo = mock(IFeeRepository.class);
		
		
		feeService = new IFeeServiceImpl(feerepo);
		
		
		ac = MockitoAnnotations.openMocks(this);
		
	}
	@AfterEach
	public void doEnd() throws Exception{
		ac.close();
	}
	
	
	//@Disabled
	
	@Test
	//@Disabled
	@DisplayName("Test-Save Fee")
	void testSaveFee() {
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = new ArrayList<>();
		flist.add(f);
		Fee input = new Fee(11,40000,10000, 50000,flist);
		Fee expected = new Fee(11,40000,10000, 50000,flist);
	
		when(feerepo.save(input)).thenReturn(expected);
		Fee output = feeService.addFee(input);
		verify(feerepo).save(input);
		assertEquals(expected,output);
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Testing Delete Fee")
	void testingdeleteFee() {
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = new ArrayList<>();
		flist.add(f);
		Fee input1 = new Fee(11,40000,10000, 50000,flist);
		Fee expected = new Fee(11,40000,10000, 50000,flist);
		
		doNothing().when(feerepo).delete(expected);
			Fee output = feeService.deleteFee(input1);

			verify(feerepo).delete(input1);
			assertEquals(expected,output);
	}
	
	@Test
	//@Disabled
	@DisplayName("Testing Update Fee")
	void testingupdateFee() {
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = Arrays.asList(f);
		Fee input = new Fee(0,10000,10000, 60000,flist);
		input.setFeeId(11);
		
		when(feerepo.findById(11)).thenReturn(Optional.of(input));
		Fee output = feeService.updateFee(input);
		
		assertEquals(input,output);
		
	}


	@Test
	//@Disabled
	@DisplayName("Testing Retrieve Fee")
	void testingretrieveFee() {
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = Arrays.asList(f);
		Fee input = new Fee(10000,10000, 60000,0, flist);
		input.setFeeId(11);
		
		when(feerepo.findById(11)).thenReturn(Optional.of(input));
		Fee output = feeService.retrieveFee(11);
		assertEquals(input,output);
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Test Invalid Save Fee")
	void testingInvalidSaveFee() {
		FeeInstallment f = new FeeInstallment(101,10000,LocalDate.of(2021, 04, 9),LocalDate.of(2020, 03, 01),1);
		List<FeeInstallment> flist = new ArrayList<>();
		flist.add(f);
		Fee input = new Fee(11,40000,10000, 50000,flist);
		Fee expected = new Fee(11,40000,10000, 50000,flist);
	
		when(feerepo.save(input)).thenReturn(expected);
		Fee output = feeService.addFee(input);
		verify(feerepo).save(input);
		assertEquals(expected,output);
	}
	
	
}