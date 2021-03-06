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
package org.gwtaf.widgets.generic;

import org.gwtaf.widgets.IsWidget;
import org.gwtaf.widgets.UiBundle;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class is along a similar idea as {@link UiBundle} except instead of just
 * being a data structure, this is an actual GWT {@link Widget}.
 * 
 * @author Arthur Kalmenson
 */
public class UiBundleWidget<L extends Widget, W extends Widget> extends
		Composite implements IsWidget {

	/**
	 * This <code>UiBundleWidget</code>'s label.
	 */
	private L label;

	/**
	 * This <code>UiBundleWidget</code>'s widget.
	 */
	private W widget;

	/**
	 * Create a new <code>UiBundleWidget</code> with the given Panel, L and W
	 * type widgets.
	 * 
	 * @param panel
	 *            the panel to add to.
	 * @param label
	 *            the label widget.
	 * @param widget
	 *            the widget.
	 */
	public UiBundleWidget(Panel panel, L label, W widget) {

		this.label = label;
		this.widget = widget;

		// add to the panel.
		panel.add(label);
		panel.add(widget);

		initWidget(panel);
	}

	/**
	 * Returns this <code>UiBundleWidget</code>'s label.
	 * 
	 * @return this <code>UiBundleWidget</code>'s label.
	 */
	public L getLabel() {
		return label;
	}

	/**
	 * Returns this <code>UiBundleWidget</code>'s widget.
	 * 
	 * @return this <code>UiBundleWidget</code>'s widget.
	 */
	public W getWidget() {
		return widget;
	}

	public Widget getContainingWidget() {
		return this;
	}
}
