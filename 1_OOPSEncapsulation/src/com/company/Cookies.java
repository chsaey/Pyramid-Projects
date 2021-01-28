package com.company;

class CookiesMain {
    public static void main(String[] args) {
        JarOfCookies jar = new JarOfCookies(100);
        System.out.println(jar.takeCookie("Charles"));
        System.out.println(jar.takeCookie("Joe"));

    }
}
