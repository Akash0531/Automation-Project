package com.dikshatech.tst.utilitylibrary;

import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.dikshatech.tst.objectrepository.RetryFailedTestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestNGListeners implements ITestListener{

	public void onTestStart(ITestResult result) 
	{
		System.out.println("Testcase Started and Testcase name is:"+result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Testcase verified and succeed and Testcase name is:"+result.getName());
	}

	public void onTestFailure(ITestResult result) 
	{}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Testcase skipped and Testcase name is:"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{}

	public void onStart(ITestContext context)
	{}

	public void onFinish(ITestContext context)
	{}
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}

	}

}