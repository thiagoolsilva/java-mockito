package com.in28minutes.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("lopes");
		assertEquals("lopes", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("lopes");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("lopes", list.get(0));
		assertEquals("lopes", list.get(1));
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);

		// given
		given(list.get(Mockito.anyInt())).willReturn("lopes");

		// then
		assertThat("lopes", is(list.get(0)));
		assertThat("lopes", is(list.get(0)));
	}

	@Test
	public void testSizeCollection_withHarcrest() {
		List<String> list = mock(List.class);

		// ----> Given
		BDDMockito.given(list.size()).willReturn(2);

		// ----> When
		int listSize = list.size();

		// ----> Then

		// Check if the method size was called
		BDDMockito.then(list).should().size();

		// and check if the size of list is equals 2
		assertThat(listSize, Matchers.is(2));
	}
}