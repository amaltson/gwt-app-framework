/*
 * Copyright 2009. Mount Sinai Hospital, Toronto, Canada.
 * 
 * IN NO EVENT SHALL MOUNT SINAI HOSPITAL BE LIABLE TO ANY PARTY FOR DIRECT, 
 * INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST 
 * PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, 
 * EVEN IF MOUNT SINAI HOSPITAL HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGE.
 * 
 * MOUNT SINAI HOSPITAL SPECIFICALLY DISCLAIMS ANY IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
 * ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". 
 * MOUNT SINAI HOSPITAL HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, 
 * UPDATES, ENHANCEMENTS, OR MODIFICATIONS. 
 */
package org.gwtaf.widgets.search.model;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test for the {@link SearchResult} domain object.
 * 
 * @author Jason Kong
 * 
 */
public class SearchResultTest {

	/**
	 * The searchResult to test.
	 */
	private SearchResult searchResult;

	@BeforeMethod
	public void initBefore() {

		searchResult = new SearchResult(3);

		searchResult.setData(0, "A");
		searchResult.setData(1, "B");
		searchResult.setData(2, "C");
	}

	/**
	 * Tries to construct a {@code SearchResult} using a incorrect amount of
	 * data values (Too few)
	 */
	@Test(expectedExceptions = AssertionError.class)
	public void testIncorrectNumDataValuesTooFew() {
		// too few
		new SearchResult(4, new String[] { "a" });
	}

	/**
	 * Tries to construct a {@code SearchResult} using a incorrect amount of
	 * data values (Too many)
	 */
	@Test(expectedExceptions = AssertionError.class)
	public void testIncorrectNumDataValuesTooMany() {
		// too little
		new SearchResult(1, new String[] { "b", "f", "e", "d" });
	}

	/**
	 * A data provider that returns pairs of objects for testing the equals and
	 * hashCode methods.
	 * 
	 * @return an array containing two objects to compare with equals() and
	 *         hashCode(), and a boolean with the expected result of the equals
	 *         comparison.
	 */
	@DataProvider(name = "testProvider")
	public Object[][] dataProviderTestEquals() {
		initBefore();

		SearchResult differentData = new SearchResult(3);

		differentData.setData(0, "Alpha");
		differentData.setData(1, "Beta");
		differentData.setData(2, "Gamma");

		SearchResult differentHeadings = new SearchResult(3);
		differentHeadings.setData(0, "Uno");
		differentHeadings.setData(1, "Dos");
		differentHeadings.setData(2, "Tres");

		SearchResult sameData = new SearchResult(3);
		sameData.setData(0, "Alpha");
		sameData.setData(1, "Beta");
		sameData.setData(2, "Gamma");

		return new Object[][] { { searchResult, differentData, false },
				{ searchResult, differentHeadings, false },
				{ searchResult, sameData, false },
				{ searchResult, searchResult, true },
				{ differentData, null, false } };
	}

	/**
	 * Tests the equals and hashCode of the {@link SearchResult} object.
	 * 
	 * @param SearchResult
	 *            the original SearchResult object
	 * @param SearchResultToCompare
	 *            the other SearchResult object against which the comparison is
	 *            done.
	 * @param expected
	 *            the expected outcome of the comparison
	 */
	@Test(dataProvider = "testProvider")
	public void testEqualsAndHash(SearchResult SearchResult,
			SearchResult SearchResultToCompare, boolean expected) {

		// check the equals
		Assert.assertEquals(SearchResult.equals(SearchResultToCompare),
				expected);

		// check the hash
		if (SearchResult != null && SearchResultToCompare != null) {
			Assert
					.assertEquals(
							SearchResult.hashCode() == SearchResultToCompare
									.hashCode(), expected);
		}
	}

}
