package com.kh.ready.book.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.service.BookService;

@Controller
public class AladinApiController {
	@Autowired
	private BookService bService;
	
	@RequestMapping(value="aladinApi.kh", method=RequestMethod.GET)
	public Book getAladinData(Model model) throws IOException, org.json.simple.parser.ParseException {
		Book book = new Book();
		List<Book> bList = new ArrayList<Book>();
		//1.URL을 만들기 위한 StringBuilder
		StringBuilder urlBuilder = new StringBuilder(" http://www.aladin.co.kr/ttb/api/ItemSearch.aspx");
		
		//2. 오픈 api의 요청 규격에 맞는 파라미터 생성
		urlBuilder.append("?" + URLEncoder.encode("ttbkey", "UTF-8") + "=ttbspeen121915001");
		urlBuilder.append("&" + URLEncoder.encode("Query", "UTF-8") + "=" + URLEncoder.encode("여행","UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("QueryType","UTF-8") + "=" + URLEncoder.encode("Title", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("MaxResults","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("start","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("SearchTarget","UTF-8") + "=" + URLEncoder.encode("Book", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("output","UTF-8") + "=" + URLEncoder.encode("js", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("Version","UTF-8") + "=" + URLEncoder.encode("20131101", "UTF-8"));
		//3. URL 객체 생성
		URL url = new URL(urlBuilder.toString());
		//4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//5. 통신을 위한 메소드 및 Content-type set
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		//6.통신 응답코드 확인
		System.out.println("Response code : " + conn.getResponseCode());
		//7. 전달받은 데이터 BufferReader 객체로 저장
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		//8. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = rd.readLine()) != null) {
			sb.append(line);
		}
		//9. 객체해제
		rd.close();
		conn.disconnect();
		//10. 전달받은 데이터 확인
		//System.out.println(sb.toString());
		
		//json 파싱작업 준비
		//1. 문자열 형태의 JSON을 파싱하기 위한 JSONParser 객체 생성
		JSONParser parser = new JSONParser();
		//2. 문자열을 JSON 형태로 JSONObject 객체에 저장
		JSONObject obj = (JSONObject)parser.parse(sb.toString());
		
		JSONArray array = (JSONArray)obj.get("item");
		StringBuilder sb2 = new StringBuilder();
		JSONObject tmp;
		for(int i=0; i<array.size(); i++) {
			tmp = (JSONObject) array.get(i);
			sb2.append("책 제목("+i+") : " + tmp.get("title") + "\n");
			sb2.append("저자("+i+") : " + tmp.get("author") + "\n");
			sb2.append("출간일("+i+") : " + tmp.get("pubDate") + "\n");
			sb2.append("카테고리("+i+")" + tmp.get("categoryName") + "\n"); 
			sb2.append("도서소개("+i+") : " + tmp.get("description") + "\n");
			sb2.append("ISBN("+i+") : " + tmp.get("isbn13") + "\n");
			sb2.append("판매가("+i+") : " + tmp.get("priceStandard") + "\n");
			sb2.append("적립금("+i+") : " + tmp.get("mileage") + "\n");
			sb2.append("표지("+i+") : " + tmp.get("cover") + "\n");
			sb2.append("출판사("+i+") : " + tmp.get("publisher") + "\n");
			
			book.setBookTitle(tmp.get("title").toString());
			book.setBookWriter(tmp.get("author").toString());
			book.setPubDate(tmp.get("pubDate").toString());
			book.setCategory(tmp.get("categoryName").toString());
			book.setBookContents(tmp.get("description").toString());
			book.setISBN(tmp.get("isbn13").toString());
			book.setPriceSales((long)tmp.get("priceStandard"));
			book.setMileage((long)tmp.get("mileage"));
			book.setImgPath(tmp.get("cover").toString());
			book.setPublisher(tmp.get("publisher").toString());
			
			int result = bService.registerBook(book);
		}
		
		//System.out.println(sb2.toString());
		
		return book;
	}
}
