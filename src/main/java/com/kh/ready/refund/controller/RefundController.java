package com.kh.ready.refund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ready.refund.domain.Refund;
import com.kh.ready.refund.service.RefundService;

@Controller
public class RefundController {
	
	@Autowired
	private RefundService refService;

	@PostMapping(value="/refund/doRefund")
	@ResponseBody
	public String canclePay(@RequestParam(value="orderId") String orderId) {
		System.out.println("orderId : " + orderId);
		
		Refund refund = new Refund();
		return orderId;
	}
}
