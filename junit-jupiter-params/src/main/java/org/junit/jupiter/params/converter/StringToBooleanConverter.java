/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.params.converter;

import org.junit.platform.commons.util.Preconditions;

class StringToBooleanConverter implements StringToObjectConverter {

	@Override
	public boolean canConvert(Class<?> targetType) {
		return targetType == Boolean.class;
	}

	@Override
	public Object convert(String source, Class<?> targetType) {
		boolean isTrue = "true".equalsIgnoreCase(source);
		boolean isNull = "null".equalsIgnoreCase(source);
		Preconditions.condition(isTrue || "false".equalsIgnoreCase(source) || isNull,
				() -> "String must be 'true', 'false', or 'null' (ignoring case): " + source);
		return isNull ? null : isTrue;
	}

}
