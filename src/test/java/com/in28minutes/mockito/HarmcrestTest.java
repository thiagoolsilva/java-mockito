package com.in28minutes.mockito;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import com.in28minutes.model.BedRoom;
import com.in28minutes.model.RestRoom;

//playing with collection
public class HarmcrestTest {

	@Test
	public void testCollectionSize() {
		List<String> stubCollection = Arrays.asList("Thiago", "Lopes", "Silva", "Flavio", "Suely");

		// Check if the size of list is equals 5
		MatcherAssert.assertThat(stubCollection, hasSize(5));
	}

	@Test
	public void testContentInCollection() {
		// create a stub restroom object
		List<RestRoom> restRoom = Arrays.asList(new RestRoom("1"), new RestRoom("2"), new RestRoom("3"));
		BedRoom bedRoom = new BedRoom();
		bedRoom.setRestroom(restRoom);

		// checking if exists a content with entry equals 2
		Matcher<Iterable<? super RestRoom>> matcher = hasItem(hasProperty("name", Matchers.is("2")));
		MatcherAssert.assertThat(restRoom, matcher);
	}
}
