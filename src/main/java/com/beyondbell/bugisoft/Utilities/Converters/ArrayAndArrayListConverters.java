package com.beyondbell.bugisoft.Utilities.Converters;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayAndArrayListConverters {
	public static Object[] arrayListToArrayConverter(ArrayList<Object> arrayList) {
		Object[] array = new Object[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			array[i] = arrayList.get(i);
		}
		return array;
	}

	public static ArrayList<Object> arrayToArrayListConverter(Object[] array) {
		ArrayList<Object> arrayList = new ArrayList<>();
		Collections.addAll(arrayList, array);
		return arrayList;
	}
}
