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
package org.gwtaf.command.server;

import org.gwtaf.command.shared.Action;
import org.gwtaf.command.shared.ActionHandler;
import org.gwtaf.command.shared.Response;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test the {@link ActionHandlerRegistryImpl} class. Since this implementation
 * uses a HashMap back, it doesn't require thorough end case testing, just tests
 * to make sure the hashmap is being used.
 * 
 * @author Arthur Kalmenson
 */
public class ActionHandlerRegistryImplTest {

	/**
	 * Mock of the {@link Action} class.
	 */
	@Mock
	private Action<Response> actionMock;

	/**
	 * Mock of the {@link ActionHandler} class.
	 */
	@Mock
	private ActionHandler<Action<Response>, Response> handlerMock;

	/**
	 * The {@link ActionHandlerRegistry} we're testing.
	 */
	private ActionHandlerRegistryImpl actionHandlerRegistry;

	@BeforeMethod
	public void initBefore() {
		MockitoAnnotations.initMocks(this);

		actionHandlerRegistry = new ActionHandlerRegistryImpl();
	}

	/**
	 * Test adding {@link ActionHandler}s to the registry and finding them.
	 */
	@Test
	public void addAndFindHandler() {

		// add the handler.
		actionHandlerRegistry.addHandler(actionMock, handlerMock);

		// now find it and verify it's correct.
		Assert.assertEquals(handlerMock, actionHandlerRegistry
				.findHandler(actionMock));
	}

	/**
	 * Test to ensure that removing an {@link ActionHandler} for a specific
	 * {@link Action} removes it.
	 */
	@Test
	public void addAndRemoveHandler() {

		// add the handler.
		actionHandlerRegistry.addHandler(actionMock, handlerMock);

		// now remove the handler.
		actionHandlerRegistry.removeHandler(actionMock);

		// now find it and verify it's correct.
		Assert.assertNull(actionHandlerRegistry.findHandler(actionMock));
	}

	/**
	 * Ensure clearing the registry removes the handlers inside.
	 */
	@Test
	public void clearHandler() {

		// add the handler.
		actionHandlerRegistry.addHandler(actionMock, handlerMock);

		// now remove the handler.
		actionHandlerRegistry.clearHandlers();

		// now find it and verify it's correct.
		Assert.assertNull(actionHandlerRegistry.findHandler(actionMock));
	}
}
