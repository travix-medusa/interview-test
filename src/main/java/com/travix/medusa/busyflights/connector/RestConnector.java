package com.travix.medusa.busyflights.connector;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.validation.GenericValidator;
import com.travix.medusa.busyflights.validation.ValidationResponse;

/**
 * Performs HTTP calls.
 * @author marcelo.chiaradia
 *
 */
public abstract class RestConnector {

    @Autowired
    private RestTemplate restTemplate;

    protected <T, R extends T> T getForObject(String urlTemplate, Class<R> responseType, Object[] uriArguments,
        GenericValidator<T> responseValidator) {
        T response = this.restTemplate.getForObject(urlTemplate, responseType, uriArguments);

        this.validateResponse(response, responseValidator);
        return response;
    }

    protected <T> T postForObject(String urlTemplate, Object request, Class<T> responseType,
        GenericValidator<T> responseValidator) {
        T response = this.restTemplate.postForObject(urlTemplate, request, responseType);

        this.validateResponse(response, responseValidator);
        return response;
    }

    protected <T> void validateResponse(T response, GenericValidator<T> responseValidator) {
        ValidationResponse validationResponse = responseValidator.validate(response);

        if (!validationResponse.isSucceeded()) {
            throw new ValidationException(validationResponse.getErrors().toString());
        }
    }
}
