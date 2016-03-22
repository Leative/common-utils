/*
 * Copyright (c) 2014- MHISoft LLC and/or its affiliates. All rights reserved.
 * Licensed to MHISoft LLC under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. MHISoft LLC licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.mhisoft.common.util;

import java.util.UUID;
import java.io.UnsupportedEncodingException;
import java.nio.charset.IllegalCharsetNameException;

/**
 * Description:  Utils for simple string manipulations.
 *
 * @author Tony Xue
 * @since Mar, 2016
 */
public class StringUtils {
	public static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * String to Byte array
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(final String str) {
		byte[] result;
		if (str == null) {
			result = new byte[0];
		} else {
			try {
				result = str.getBytes(DEFAULT_ENCODING);
			} catch (final UnsupportedEncodingException e) {
				throw new IllegalCharsetNameException(DEFAULT_ENCODING);
			}
		}
		return result;
	}

	/**
	 * Convert byte array into hex string that is displable.
	 * @param b
	 * @return
	 */
	public  static String toHexString(final byte[] b) {
		final StringBuffer result = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			result.append(Integer.toHexString(b[i] >> 4 & 0xF));
			result.append(Integer.toHexString(b[i] & 0xF));
		}
		return result.toString();
	}

	/**
	 * Get string from bytes.
	 *
	 * @param bytes
	 * @return String
	 */
	public static String bytesToString(final byte[] bytes) {
		String result;
		if (bytes == null) {
			result = "";
		} else {
			try {
				result = new String(bytes, DEFAULT_ENCODING);
			} catch (final UnsupportedEncodingException e) {
				throw new IllegalCharsetNameException(DEFAULT_ENCODING);
			}
		}
		return result;
	}

	/**
	 * Generate a GUID
	 * @return
	 */
	public static String getGUID() {
		UUID uuid = UUID.randomUUID();
		return  uuid.toString();
	}
}
