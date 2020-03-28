package com.sebastian.testing;

import java.util.List;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * org.hamcrest.Matchers
 *
 * <p>- anything
 *
 * <p>Matches absolutely anything; useful when we want to make the assert statement more readable
 *
 * <p>- is
 *
 * <p>Used only to improve the readability of statements
 *
 * <p>- allOf
 *
 * <p>Checks whether all contained matchers match (like the && operator)
 *
 * <p>- anyOf
 *
 * <p>Checks whether any of the contained matchers match (like the || operator)
 *
 * <p>- not
 *
 * <p>Inverts the meaning of the contained matchers (like the ! operator in Java)
 *
 * <p>- instanceOf
 *
 * <p>Check whether objects are instances of one another
 *
 * <p>- sameInstance
 *
 * <p>Tests object identity
 *
 * <p>- nullValue, notNullValue
 *
 * <p>Tests for null or non-null values
 *
 * <p>- hasProperty
 *
 * <p>Tests whether a Java Bean has a certain property
 *
 * <p>- hasEntry, hasKey, hasValue
 *
 * <p>Tests whether a given Map has a given entry, key, or value
 *
 * <p>- hasItem, hasItems
 *
 * <p>Tests a given collection for the presence of an item or items
 *
 * <p>- closeTo, greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo
 *
 * <p>Tests whether given numbers are close to, greater than, greater than or equal, less than, or
 * less than or equal to a given value
 *
 * <p>- equalToIgnoringCase
 *
 * <p>Tests whether a given string equals another one, ignoring the case
 *
 * <p>- equalToIgnoringWhiteSpace
 *
 * <p>Tests whether a given string equals another one, ignoring the white space
 *
 * <p>- containsString, endsWith, startsWith
 *
 * <p>Tests whether a given string contains, starts with, or ends with a certain string
 *
 * @author Sebastián Ávila A.
 */
public class HamcrestTesting {
  @Test
	@Tag("hamcrest")
  @DisplayName("List with Hamcrest")
  public void testListWithHamcrest() {
    final var values = List.of("Oliver", "2", "3");
    final var persona = new Persona("sebastian", 1);
    assertThat(values, hasSize(3));
    assertThat(values, hasItem(anyOf(equalTo("Oliver"), equalTo("Jack"), equalTo("Harry"))));
    assertThat(values, instanceOf(List.class));
    assertThat(null, nullValue());
    assertThat(persona, notNullValue());
		assertThat(1, anyOf(is(2), is(3), is(1)));
  }
}
