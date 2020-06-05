package com.example.demo.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * 페이징 처리. 
 * 페이지 사이즈:10
 */
public final class PagingUtil {

	private static final int PAGE_SIZE = 10;

	public static int getPageSize() {
		return PAGE_SIZE;
	}

	public static int getOffset(int totalCount, int currentPage) {

		int offset = PAGE_SIZE * (currentPage - 1);

		if (offset > totalCount) {
			offset = totalCount;
		}

		return offset;
	}

	public static Map<String, String> generatePageUrl(int totalCount, Map<String, String> queryStringMap) {

		Map<String, String> pageUrlMap = new LinkedHashMap<String, String>();

		int currentPage = Integer.parseInt(queryStringMap.get("page"));
		int endPage = (totalCount / PAGE_SIZE) + (totalCount % PAGE_SIZE != 0 ? 1 : 0);

		int first = currentPage == 1 ? 0 : 1;
		int prev = currentPage <= 1 ? 0 : currentPage - 1;
		int next = currentPage == endPage ? 0 : currentPage + 1;
		int last = currentPage == endPage ? 0 : endPage;

		ServletUriComponentsBuilder servletUriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequestUri();

		Set<String> keySet = queryStringMap.keySet();
		for (String key : keySet) {
			servletUriComponentsBuilder.queryParam(key, queryStringMap.get(key));
		}

		if (first != 0)
			pageUrlMap.put("first", servletUriComponentsBuilder.replaceQueryParam("page", String.valueOf(first)).build().toString());
		if (prev != 0)
			pageUrlMap.put("prev", servletUriComponentsBuilder.replaceQueryParam("page", String.valueOf(prev)).build().toString());
		if (next != 0)
			pageUrlMap.put("next", servletUriComponentsBuilder.replaceQueryParam("page", String.valueOf(next)).build().toString());
		if (last != 0)
			pageUrlMap.put("last", servletUriComponentsBuilder.replaceQueryParam("page", String.valueOf(last)).build().toString());

		return pageUrlMap;
	}

}
