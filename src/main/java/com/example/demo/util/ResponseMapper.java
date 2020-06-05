package com.example.demo.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 리스폰스 데이터 맵핑. 
 * SUCESS ERROR 리스폰스를 모두 처리한다. 
 */
public final class ResponseMapper {


	/**
	 * SUCCESS Response Data Mapping
	 */
	public static ResponseEntity<Object> sucessResponse(Map<String, Object> responseMap) {

		return new ResponseEntity<Object>(responseMap, generateHeader(), HttpStatus.OK);
	}

	/**
	 * ERROR Response Data Mapping
	 */
	public static ResponseEntity<Object> errorResponse(int code) {

		String message = "";
		HttpStatus status;

		switch (code) {
		case 404:
			message = "페이지를 찾을 수 없습니다.";
			status = HttpStatus.NOT_FOUND;
			break;
		case 400:
			message = "필수 파라미터가 올바르지 않습니다.";
			status = HttpStatus.BAD_REQUEST;
			break;
		case 401:
			message = "권한이 없습니다.";
			status = HttpStatus.UNAUTHORIZED;
			break;
		case 405:
			message = "요청 메소드가 올바르지 않습니다.";
			status = HttpStatus.METHOD_NOT_ALLOWED;
			break;
		default:
			message = "서버 내부 에러가 발생했습니다.";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		}

		Map<String, Object> responseMap = new LinkedHashMap<String, Object>();
		responseMap.put("statusCode", code);
		responseMap.put("message", message);

		return new ResponseEntity<Object>(responseMap, generateHeader(), status);
	}
	
	/**
	 * 공통 HEADER
	 */
	public static MultiValueMap<String, String> generateHeader() {

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Origin", "*");

		return headers;
	}

}
