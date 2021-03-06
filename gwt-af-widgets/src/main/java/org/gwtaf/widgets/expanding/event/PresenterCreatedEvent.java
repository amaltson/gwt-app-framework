/*
 * Copyright 2008. Mount Sinai Hospital, Toronto, Canada.
 * 
 * Licensed under the Apache License, Version 2.0. You
 * can find a copy of the license at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
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
package org.gwtaf.widgets.expanding.event;

import org.gwtaf.widgets.Presenter;
import org.gwtaf.widgets.expanding.ExpandableTable;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;

/**
 * A {@link GwtEvent} indicating the creation of a new Presenter that's thrown
 * when a new Presenter is added to an {@link ExpandableTable}.
 * 
 * @author Arthur Kalmenson
 * 
 * @param <P>
 *            the type of Presenter created.
 */
public class PresenterCreatedEvent<P extends Presenter<?, ?>> extends
		GwtEvent<PresenterCreatedHandler<P>> {

	/**
	 * Handler type.
	 */
	private Type<PresenterCreatedHandler<P>> type;

	/**
	 * The presenter we're using.
	 */
	private P presenter;

	/**
	 * Create a new <code>PresenterCreatedEvent</code> with the given
	 * {@link Type}.
	 * 
	 * @param type
	 *            the Type to use as the associated type.
	 */
	@Inject
	public PresenterCreatedEvent(Type<PresenterCreatedHandler<P>> type) {
		this.type = type;
	}

	public P getPresenter() {
		return presenter;
	}

	public void setPresenter(P presenter) {
		this.presenter = presenter;
	}

	@Override
	protected void dispatch(PresenterCreatedHandler<P> handler) {
		handler.onPresenterCreated(this);
	}

	@Override
	public final Type<PresenterCreatedHandler<P>> getAssociatedType() {
		return type;
	}

}
