package com.mkdp.controller;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BusinessController {
	private static final String BASE_URL = "https://opendart.fss.or.kr/api/company.json";
	private static final String CERTIFICATION_KEY = "7d0f1dcd2423d0a924566799752d81b114b9debe";

	/** http 요청을 받아서 API Dart 기업개황 을 Map데이터로 돌려준다  */
	@ResponseBody
	@RequestMapping(value = "/companyOverview", method = RequestMethod.GET)
	public Map<Object,Object> getCompanyOverview(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {

		Map<Object, Object> result = new HashMap<>();
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		String url = BASE_URL;
		String crtfc_key = CERTIFICATION_KEY;
		String corp_code = "00126380";

		URIBuilder builder = new URIBuilder(url);
		builder.setParameter("crtfc_key", crtfc_key);
		builder.setParameter("corp_code", corp_code);

		// 프록시 서버를 통해 요청을 보냄
		HttpGet request1 = new HttpGet(builder.build());
		request1.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		CloseableHttpResponse apiResponse = httpClient.execute(request1);

		try {
			HttpEntity entity = (HttpEntity) apiResponse.getEntity();
			String responseBody = EntityUtils.toString((org.apache.http.HttpEntity) entity, StandardCharsets.UTF_8);
			result.put("result", responseBody);
		} finally {
			apiResponse.close();
		}
		
		
		return result;


	}
	
	/** http 요청을 받아서 API Dart 고유번호 을 Map데이터로 돌려준다  */
	@ResponseBody
	@RequestMapping(value = "/companyCropCode", method = RequestMethod.GET)
	public Map<Object,Object> companyCropCodeController(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {	
		
		Map<Object, Object> result = new HashMap<>();
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		String url = "https://opendart.fss.or.kr/api/corpCode.xml";
		String crtfc_key = "7d0f1dcd2423d0a924566799752d81b114b9debe";
		
		URIBuilder builder = new URIBuilder(url);
		builder.setParameter("crtfc_key", crtfc_key);

		
		// 프록시 서버를 통해 요청을 보냄
		HttpGet request1 = new HttpGet(builder.build());
		request1.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		CloseableHttpResponse apiResponse = httpClient.execute(request1);
		
		try {
			HttpEntity entity = (HttpEntity) apiResponse.getEntity();
			String responseBody = EntityUtils.toString((org.apache.http.HttpEntity) entity, StandardCharsets.UTF_8);

			result.put("result", responseBody);
		} finally {
			apiResponse.close();
		}


		return result;

	}
		
	}
