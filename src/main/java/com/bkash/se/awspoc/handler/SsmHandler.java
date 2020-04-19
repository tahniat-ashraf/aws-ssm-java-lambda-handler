package com.bkash.se.awspoc.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bkash.se.awspoc.ssm.SsmUtility;

import java.util.Map;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/22/20
 */
public class SsmHandler implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> myMap, Context context) {
        SsmUtility ssmUtility = new SsmUtility();
        String ops = myMap.get("ops");
        System.out.println("ops = " + ops);
        String secured = myMap.get("secured");
        System.out.println("secured = " + secured);
        if (ops.equalsIgnoreCase("save")) {
            String key = myMap.get("key");
            String value = myMap.get("value");
            ssmUtility.saveParam(key, value, secured);
            return "saved";
        } else {
            //get request
            String key = myMap.get("key");
            return ssmUtility.getParamValue(key, secured);
        }
    }
}
