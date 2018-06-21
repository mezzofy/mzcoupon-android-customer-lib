package com.mezzofy.MzCouponAPI.mapper;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonMapper<T> {

	public static <T> T mapJsonToObj(String json, Class<T> outputClass) throws IOException,	JSONException {
		Gson gson = new Gson();
		T retobj = (T) gson.fromJson(json, outputClass);
		return retobj;
	}

	public static <T> T mapJsonToObj(Object inputObject, Class<T> outputClass) throws IOException,	JSONException {
		Gson gson = new Gson();
		String json = gson.toJson(inputObject);
		T retobj = (T) gson.fromJson(json, outputClass);
		return retobj;
	}

	public static <T> List<T> mapJsonToObjList(String json, Type collectionType) throws IOException,	JSONException {
		Gson gson = new Gson();
		List<T> outputList =  gson.fromJson(json, collectionType);
		return outputList;
	}

	public static <T> List<T> mapJsonToObjList(List<T> inputList, Object inputObject, Type inputType, Type outputType) throws IOException,	JSONException {
		Gson gson = new Gson();
		String json = gson.toJson(inputList, inputType);
		List<T> outputList =  gson.fromJson(json, outputType);
		return outputList;
	}
}
