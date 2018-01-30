package com.customerrecords.dublinlunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.customerrecords.dublinlunch.ServiceConstants.SOURCE_LATITUDE;
import static com.customerrecords.dublinlunch.ServiceConstants.SOURCE_LONGITUDE;
import static org.hamcrest.Matchers.closeTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDistanceCalculation() {
		double testLatitude = 52.986375;
		double testLongitude = -6.043701;

		double distance = DistanceCalculator.distanceInKm(SOURCE_LATITUDE, SOURCE_LONGITUDE, testLatitude, testLongitude);

		Assert.assertThat(distance, closeTo(41.7, 0.1));
	}
}
