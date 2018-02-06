package com.customerrecords.dublinlunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.closeTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Value("${reference-latitude}")
	private double REFERENCE_LATITUDE;

	@Value("${reference-longitude}")
	private double REFERENCE_LONGITUDE;

	@Value("${given-latitude}")
	private double GIVEN_LATITUDE;

	@Value("${given-longitude}")
	private double GIVEN_LONGITUDE;

	@Value("${known-correct-comparison-value}")
	private double KNOWN_CORRECT_COMPARISON_VALUE;

	@Value("${acceptable-float-arithmetic-deviation}")
	private double ACCEPTABLE_FLOAT_ARITHMETIC_DEVIATION;

	@Autowired
	private DistanceCalculator distanceCalculator;

	@Autowired
	private FreeLunchService freeLunchService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testComparingTheReferenceLatlongAgainstTheGivenLatlongYieldsAKnownCorrectResult() {

		double distance = distanceCalculator.distanceInKm(
				REFERENCE_LATITUDE, REFERENCE_LONGITUDE,
				GIVEN_LATITUDE, GIVEN_LONGITUDE
		);

		Assert.assertThat(distance, closeTo(KNOWN_CORRECT_COMPARISON_VALUE, ACCEPTABLE_FLOAT_ARITHMETIC_DEVIATION));
	}

	@Test
	public void testStaticCustomerRecordsDataSourceWorks() {
		Assert.assertNotNull(freeLunchService.returnListOfCustomers());
	}
}
