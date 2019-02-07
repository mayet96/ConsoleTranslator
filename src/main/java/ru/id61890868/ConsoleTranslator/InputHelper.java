package ru.id61890868.ConsoleTranslator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

    /**
     * Получить строку из консоли
     * @param prompt подпись ожидаемых данных("prompt: inputData")
     * @return полученная строка
     */
    static String inputSting(String prompt){
        String inputLine = null;
        System.out.print(makePrompt(prompt));
        try{
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            inputLine = input.readLine();
            if(inputLine.length() == 0){
                return "";
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        return inputLine;
    }

    public static String inputSting(){
        return inputSting("");
    }

    private static String makePrompt(String prompt){
        if(prompt == null || prompt.equals("")){
            return "";
        }else{
            return prompt + ": ";
        }
    }
}
