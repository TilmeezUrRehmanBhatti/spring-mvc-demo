package com.tilmeez.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private LinkedHashMap<String, String> countryOption;

    private String favoriteLanguage;

    private LinkedHashMap<String, String> favoriteLanguageOption;
    private String[] operatingSystems;

    private LinkedHashMap<String, String> operatingSystemsOption;


    public Student() {

        // populate country option: use ISO code
        countryOption = new LinkedHashMap<>();

        countryOption.put("BR", "Brazil");
        countryOption.put("FR", "France");
        countryOption.put("DE", "Germany");
        countryOption.put("PK", "Pakistan");
        countryOption.put("IN", "India");

        // populate favourite language option
        favoriteLanguageOption = new LinkedHashMap<>();

        // parameter oder: value, display Label
        favoriteLanguageOption.put("Java", "Java");
        favoriteLanguageOption.put("C#", "C#");
        favoriteLanguageOption.put("PHP", "PHP");
        favoriteLanguageOption.put("Ruby", "Ruby");

        // populate operating systems
        operatingSystemsOption = new LinkedHashMap<>();

        // parameter oder: value, display label
        operatingSystemsOption.put("Linux","Linux");
        operatingSystemsOption.put("Mac OS","Mac OS");
        operatingSystemsOption.put("MS Windows","MS Windows");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOption() {
        return countryOption;
    }

    public void setCountryOption(LinkedHashMap<String, String> countryOption) {
        this.countryOption = countryOption;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOption() {
        return favoriteLanguageOption;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public LinkedHashMap<String, String> getOperatingSystemsOption() {
        return operatingSystemsOption;
    }
}
