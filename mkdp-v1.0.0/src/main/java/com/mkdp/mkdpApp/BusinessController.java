package com.mkdp.mkdpApp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BusinessController {
	
	/** http 요청을 받아서 API Dart 기업개황 을 Map데이터로 돌려준다  */
	@ResponseBody
	@RequestMapping(value = "/companyOverview", method = RequestMethod.GET)
	public Map<Object,Object> companyOverviewController(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {	

		Map<Object, Object> result = new HashMap<>();
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		String url = "https://opendart.fss.or.kr/api/company.json";
		String crtfc_key = "7d0f1dcd2423d0a924566799752d81b114b9debe";
		String corp_code = "00126380";

		URIBuilder builder = new URIBuilder(url);
		builder.setParameter("crtfc_key", crtfc_key);
		builder.setParameter("corp_code", corp_code);

		// 프록시 서버를 통해 요청을 보냄
		HttpGet request1 = new HttpGet(builder.build());
		request1.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		CloseableHttpResponse apiResponse = httpClient.execute(request1);
		logger.info("[response] : "+apiResponse);

		try {
			HttpEntity entity = apiResponse.getEntity();
			String responseBody = EntityUtils.toString(entity, StandardCharsets.UTF_8);
			result.put("result", responseBody);
		} finally {
			apiResponse.close();
		}
		
		
		return result;

	}	
}
