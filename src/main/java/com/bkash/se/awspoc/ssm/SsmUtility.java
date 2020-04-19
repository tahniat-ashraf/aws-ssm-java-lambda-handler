package com.bkash.se.awspoc.ssm;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;
import com.amazonaws.services.simplesystemsmanagement.model.PutParameterRequest;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/22/20
 */

public class SsmUtility {
    private AWSSimpleSystemsManagement ssmClient;

    public SsmUtility() {
        this.ssmClient = AWSSimpleSystemsManagementClientBuilder.defaultClient();
    }


    public void saveParam(String paramName, String paramValue, String secured) {

        try {
            PutParameterRequest putParameterRequest = new PutParameterRequest();
            putParameterRequest.setName(paramName);
            putParameterRequest.setValue(paramValue);
            putParameterRequest.setOverwrite(true);
            putParameterRequest.setType("String");
            if (secured.compareTo("Y") == 0) {
                putParameterRequest.setType("SecureString");
            }
            this.ssmClient.putParameter(putParameterRequest);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public String getParamValue(String paramKey, String secured) {
        String paramValue = null;

        try {
            GetParameterRequest request = new GetParameterRequest();
            request.withName(paramKey);
            if (secured.compareTo("Y") == 0) {
                request.withWithDecryption(true);
            }
            GetParameterResult result = this.ssmClient.getParameter(request);
            paramValue = result.getParameter().getValue();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return paramValue;
    }
}
