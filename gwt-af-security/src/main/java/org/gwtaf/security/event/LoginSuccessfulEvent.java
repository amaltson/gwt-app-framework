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
package org.gwtaf.security.event;

import org.gwtaf.eventbus.event.GenericPayloadEvent;
import org.gwtaf.security.domain.User;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;

/**
 * A {@link GwtEvent} indicating that the login was successful.
 * 
 * @author Arthur Kalmenson
 */
public class LoginSuccessfulEvent extends
		GenericPayloadEvent<User, LoginSuccessfulEventHandler> {

	/**
	 * Create a new <code>LoginSuccessfulEvent</code> with the injected type.
	 * 
	 * @param type
	 *            the type for this event.
	 */
	@Inject
	public LoginSuccessfulEvent(Type<LoginSuccessfulEventHandler> type) {
		super(type);
	}

	@Override
	protected void dispatch(LoginSuccessfulEventHandler handler) {
		handler.onLoginSuccessful(this);
	}
}
