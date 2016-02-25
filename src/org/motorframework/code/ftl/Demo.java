package org.motorframework.code.ftl;

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
		System.out.println(d.getClass().getClassLoader().getResource(""));
		System.out.println(System.getProperty("java.class.path"));
	}
}
