package com.kh.ready.refund.domain;

import org.json.simple.JSONObject;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class Refund {
    private String code;
    private String messege;
    private JSONObject response = new JSONObject();
}