package com.subrat.unittesting.demo.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	String actualResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void testJsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {

		String expectedResponse1 = "{\"id\": 1, \"name\":\"Ball\",   \"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse1, actualResponse, true);

	}

	@Test
	public void testJsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {

		String expectedResponse1 = "{\"id\": 1, \"name\":\"Ball\",   \"price\":10}";
		JSONAssert.assertEquals(expectedResponse1, actualResponse, false);

	}

	@Test
	public void testJsonAssert_WithoutEscapeCharacters() throws JSONException {

		String expectedResponse1 = "{id: 1, name:Ball, price:10}";
		JSONAssert.assertEquals(expectedResponse1, actualResponse, false);

	}

}
