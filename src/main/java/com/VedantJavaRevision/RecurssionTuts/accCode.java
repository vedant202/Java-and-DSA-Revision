package com.VedantJavaRevision.RecurssionTuts;

public class accCode {
	public static void func(int k) {
		if(k>155) {
			return;
		}
		System.out.println(k);
		func(k+2);
		System.out.println(k);
	}
	public static void main(String[] args) {
		int k=150;
		func(k);
	}
}
