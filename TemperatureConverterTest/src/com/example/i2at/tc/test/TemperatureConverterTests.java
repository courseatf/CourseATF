/**
 * 
 */
package com.example.i2at.tc.test;
import com.example.i2at.tc.TemperatureConverter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import junit.framework.TestCase;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author diego
 *
 */

public class TemperatureConverterTests extends TestCase {

	private static final HashMap<Double, Double> sConversionTableDouble =
			new HashMap<Double, Double>();
	
	static {
		sConversionTableDouble.put(0.0, 32.0);
		sConversionTableDouble.put(100.0, 212.0);
		sConversionTableDouble.put(-1.0, 30.20);
		sConversionTableDouble.put(-100.0, -148.0);
		sConversionTableDouble.put(32.0, 89.60);
		sConversionTableDouble.put(-40.0, -40.0);
		sConversionTableDouble.put(-273.0, -459.40);
	}

	TemperatureConverter m_Tc;

	/**
	 * @param name
	 */

	public TemperatureConverterTests(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.example.i2at.tc.TemperatureConverter#fahrenheitToCelsius(double)}.
	 */
	public void testFahrenheitToCelsius() {
		/* TODO 6: 섭씨온도와 화씨온도를 서로 변환할 수 있어야 함. (기대 값의 허용오차는 0.005 로 가정)
		 * 미리 준비 된 변환 테이블을 참조하여 작성(sConversionTableDouble)
		 */
		Iterator itr = sConversionTableDouble.keySet().iterator();
		while(itr.hasNext()){
			double c = (Double)itr.next();
			double f = sConversionTableDouble.get(c);
			double expectCelsius= TemperatureConverter.fahrenheitToCelsius(f);
			//assertEquals(c, expect);
			final double delta = Math.abs(expectCelsius - c);
			assertTrue("delta=" + delta + " expect=" + expectCelsius + " actual=" + f, delta < 0.005);
		}
	}

	/**
	 * Test method for {@link com.example.i2at.tc.TemperatureConverter#fahrenheitToCelsius(double)}.
	 */
	public void testCelsiusToFahrenheit() {
		/* TODO 6: 섭씨온도와 화씨온도를 서로 변환할 수 있어야 함. (기대 값의 허용오차는 0.005 로 가정)
		 * 미리 준비 된 변환 테이블을 참조하여 작성(sConversionTableDouble)
		 */		
		Iterator itr = sConversionTableDouble.keySet().iterator();
		while(itr.hasNext()){
			double c = (Double)itr.next();
			double f = sConversionTableDouble.get(c);
			double expectFahrenheit = TemperatureConverter.celsiusToFahrenheit(c);
			//assertEquals(f, expect);
			
			final double delta = Math.abs(expectFahrenheit - f);
		    assertTrue("delta=" + delta + " expect=" + expectFahrenheit + " actual=" + f, delta < 0.005);
		}
	}
	
	public final void testExceptionForLessThanAbsoluteZeroF() {
		/* TODO 7: 값에 오류가 발생했을 때 동일한 field 에 표현되어야 함 */	
	}
	
	public final void testExceptionForLessThanAbsoluteZeroC() {
		/* TODO 7: 값에 오류가 발생했을 때 동일한 field 에 표현되어야 함 */
	}
	
	public final void testPrivateConstructor() throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Constructor<TemperatureConverter> ctor =
			TemperatureConverter.class.getDeclaredConstructor();
		ctor.setAccessible(true);
		TemperatureConverter tc = ctor.newInstance((Object[])null);
		assertNotNull(tc);
	}
}
