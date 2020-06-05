package com.example.demo.util;

/**
 * 스트링 객체 관련 공통 함수.
 *
 */
public final class StringUtil {

	/**
	 * 스트링을 LIKE검색 위해 앞 뒤에 %%를 붙인다.
	 * 
	 */
	public static String generateLikeSearchString(String searchString) {

		StringBuffer stringBuffer = new StringBuffer("%");
		stringBuffer.append(searchString);
		stringBuffer.append("%");

		return stringBuffer.toString();
	}
}
