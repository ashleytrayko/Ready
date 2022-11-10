package com.kh.ready.refund.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.ready.refund.domain.Refund;
import com.kh.ready.refund.service.RefundService;
import com.kh.ready.refund.store.RefundStore;

import net.minidev.json.JSONObject;

@Service
public class RefundServiceImpl implements RefundService{

	@Autowired
	private RefundStore refStore;
	
    private final String imp_key="2668574740488838";
    private final String imp_secret="Q44VoZAfwC9pWRV8qaC83RwB2wZgC1rrjd7OVECCDMvwMeilYD3n4KIw1hR5nmsE9PeESLEMh0Be2M1j";
    private RestTemplate restTemplate=new RestTemplate();
    private HttpHeaders headers=new HttpHeaders();
    private JSONObject body=new JSONObject();
    
    
    private Refund getToken() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        body.put("imp_key", imp_key);
        body.put("imp_secret", imp_secret);
        try {  
            HttpEntity<JSONObject> entity =new HttpEntity<>(body,headers);
            
            Refund token=restTemplate.postForObject("https://api.iamport.kr/users/getToken",entity,Refund.class);
            System.out.println(" FULLtoken : " + token);
    
            return token;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("gettoken에서 오류가 발생");
        }finally{
            headerAndBodyClear();
        }
        return null;
    }
    
    private void headerAndBodyClear(){
        headers.clear();
        body.clear();
    }
}
