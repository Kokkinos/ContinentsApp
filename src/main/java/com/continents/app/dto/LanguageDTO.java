package com.continents.app.dto;

public class LanguageDTO {

    private String language;
    private Boolean official;

    public LanguageDTO() {}
    public LanguageDTO(String language, Boolean official) {
        this.language = language;
        this.official = official;
    }

    public String getLanguage() { return language; }
    public Boolean getOfficial() { return official; }

    public void setLanguage(String language) { this.language = language; }
    public void setOfficial(Boolean official) { this.official = official; }
}
