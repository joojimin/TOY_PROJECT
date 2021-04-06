package com.my.toyproject.test.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
public abstract class CustomMockitoTester {

	protected abstract Class getTestClass();

	@Order(0)
	@BeforeEach
	public void init(){
		MockitoAnnotations.initMocks(getTestClass());
	}

	protected <T>OngoingStubbing<T> when(T methodCall){
		return Mockito.when(methodCall);
	}

	protected <T> T verify(T mock){
		return Mockito.verify(mock);
	}

	protected <T> T verify(T mock, VerificationMode verificationMode){
		return Mockito.verify(mock, verificationMode);
	}
}
