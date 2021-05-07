package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;

/**
 * @author Nick Hamnett
 * @author Maryam Moussavi
 * @version 2020-03-24
 *
 */
class LinkedListTests
{
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty()
	{
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}

	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes()
	{
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");

		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}

	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 2);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}

	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.replace("e", 2);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.delete(2);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}

	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */

		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);

		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);

		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}

	
	/**
	 * Tests appending a null value will not be append it to the linked list
	 * Author: Group
	 */
	@Test
	void testNullAppendNode()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append(null);
		this.linkedList.append("d");
		this.linkedList.append(null);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 3
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("d", this.linkedList.retrieve(2));

	}

	/**
	 * Tests prepending a null value will not be prepend to the linked list Tests adding a
	 * different types of values is viable
	 * Author: Group
	 */
	@Test
	void testNullPrependNode()
	{
		this.linkedList.prepend(null);
		this.linkedList.prepend("a");
		this.linkedList.prepend(1);
		this.linkedList.prepend(null);
		this.linkedList.prepend('d');

		/**
		 * Linked list should now be:
		 * 
		 * d -> 1 -> a
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 3
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals('d', this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals(1, this.linkedList.retrieve(1));

		// Test the third node value is c
		assertEquals("a", this.linkedList.retrieve(2));

	}

	/**
	 * Tests clearing a linked list
	 * Author: Group
	 */
	@Test
	void testClearList()
	{
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend(null);
		this.linkedList.prepend("d");

		this.linkedList.clear();

		/**
		 * Linked list should now be cleared.
		 * 
		 */

		// Test the linked list is empty
		assertTrue(this.linkedList.isEmpty());

		// Test the size is 0
		assertEquals(0, this.linkedList.size());

	}

	/**
	 * Tests inserting a node at a index greater than the list size adds it to the end of the
	 * list
	 * Author: Group
	 */
	@Test
	void testInsertNodeInvalidIndex()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", 10);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d -> e
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 5
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("d", this.linkedList.retrieve(3));

		// Test the fourth node value is d
		assertEquals("e", this.linkedList.retrieve(4));
	}

	/**
	 * Tests inserting a node at a negative index does not work
	 * Author: Group
	 */
	@Test
	void testInsertNodeNegativeIndex()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");

		this.linkedList.insert("e", -2);

		/**
		 * Linked list should be:
		 * 
		 * a -> b -> c -> d
		 */

		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());

		// Test the size is 5
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));

		// Test the third node value is e
		assertEquals("c", this.linkedList.retrieve(2));

		// Test the third node value is c
		assertEquals("d", this.linkedList.retrieve(3));

	}

	/**
	 * Tests finding index of data that does not match returns -1 Tests the linked list
	 * returns the first matching index of 2 identical values
	 * Author: Group
	 */
	@Test
	void testIndexOfMethod()
	{
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		this.linkedList.append("b");

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d -> b
		 */

		int index = this.linkedList.indexOf("f");
		assertEquals(-1, index);

		int index2 = this.linkedList.indexOf("b");
		assertEquals(1, index2);

	}
	
	/**
	 * Tests a false return if you search for something the list does not contain
	 * Tests a true return if you search for something the list does not contain
	 * Author: Group
	 */
	@Test
	void testContainsMethod()
	{
		this.linkedList.append(1);
		this.linkedList.append(2);
		this.linkedList.append(3);
		this.linkedList.append(4);
		this.linkedList.append(5);

		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d -> b
		 */

		boolean contains = this.linkedList.contains(6);
		assertFalse(contains);

		boolean contains2 = this.linkedList.contains(3);
		assertTrue(contains2);

	}
	
}
