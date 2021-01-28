package com.company;

class JarOfCookies {
    private int cookies;

    JarOfCookies(int cookies){
        this.cookies = cookies;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }

    public int takeCookie(String name){
        if(name.equals("Charles")){
            return 0;
        }
        return 1;
    }
}
