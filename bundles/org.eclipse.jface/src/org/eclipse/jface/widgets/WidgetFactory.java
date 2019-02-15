/*******************************************************************************
* Copyright (c) 2019 vogella GmbH and others.
*
* This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*     Lars Vogel <Lars.Vogel@vogella.com> - initial version
******************************************************************************/
package org.eclipse.jface.widgets;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 *
 * This class provides a convenient shorthand for creating and initializing
 * factories for SWT widgets. This offers several benefits over creating SWT
 * widgets with the low level SWT API
 *
 * <ul>
 * <li>The same factory can be used many times to create several widget
 * instances</li>
 * <li>The setters can be chained</li>
 * <li>Factories accept a lambda whenever applicable</li>
 * </ul>
 *
 * Example usage:
 *
 * <pre>
 * Button button = WidgetFactory.button(SWT.PUSH) //
 * 		.text("Click me!") //
 * 		.onSelect(event -> buttonClicked(event)) //
 * 		.layoutData(gridData) //
 * 		.create(parent);
 * </pre>
 * <p>
 * The above example creates a push button with a text, registers a
 * SelectionListener and finally creates the button in "parent".
 * <p>
 *
 * <pre>
 * ButtonFactory buttonFactory = WidgetFactory.button(SWT.PUSH).onSelect(event -> buttonClicked(event));
 * buttonFactory.text("Button 1").create(parent);
 * buttonFactory.text("Button 2").create(parent);
 * buttonFactory.text("Button 3").create(parent);
 * </pre>
 * <p>
 * The above example creates three buttons using the same instance of
 * ButtonFactory.
 * <p>
 */
public final class WidgetFactory {
	private WidgetFactory() {
	}

	/**
	 * @param style SWT style applicable for Button. Refer to
	 *              {@link Button#Button(Composite, int)} for supported styles.
	 * @return ButtonFactory
	 */
	public static ButtonFactory button(int style) {
		return ButtonFactory.newButton(style);
	}

	/**
	 * @param style SWT style applicable for Text. Refer to
	 *              {@link Text#Text(Composite, int)} for supported styles.
	 * @return TextFactory
	 */
	public static TextFactory text(int style) {
		return TextFactory.newText(style);
	}

	/**
	 * @param style SWT style applicable for Label. Refer to
	 *              {@link Label#Label(Composite, int)} for supported styles.
	 * @return LabelFactory
	 */
	public static LabelFactory label(int style) {
		return LabelFactory.newLabel(style);
	}

}