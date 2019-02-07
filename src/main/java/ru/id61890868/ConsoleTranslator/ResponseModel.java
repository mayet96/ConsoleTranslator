package ru.id61890868.ConsoleTranslator;

import java.util.List;

public class ResponseModel {

    public ResponseModel(){

    }

    private Integer code;
    //язык, с какого и на какой был осуществлен перево
    private String lang;
    //переведенный текст
    private List<String> text;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "["+lang +"]: " + text.get(0);
    }

}
