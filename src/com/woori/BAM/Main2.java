package com.woori.BAM;

public class Main2 {
	public static void main(String[] args) {

		String a = "asd";
		String b = "asd";

		System.out.println(a == b); // a, b의 주소가 같은가
		System.out.println(a.equals(b)); // a, b이 가진 값이 같은가
		
		System.out.println("---------------");
		
		String c = new String("asd");
		String d = new String("asd");
		System.out.println(c == d);
		System.out.println(c.equals(d)); // a, b이 가진 값이 같은가
		
	}

}
