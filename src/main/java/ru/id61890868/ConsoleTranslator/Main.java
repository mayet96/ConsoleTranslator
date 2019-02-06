package ru.id61890868.ConsoleTranslator;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class Main {

    private static final String url = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String API_KEY= "trnsl.1.1.20190205T155945Z.1aefd439be03bf8e." +
            "4f37ccec873aac57fcc5db89a755526efc4a94ab";

    public static void main(String[] args){

        String line = InputHelper.inputSting("Введите строку");
        System.out.println(translate(line));


    }

    public static String translate(String str){
        try {
            RestTemplate template = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("key", API_KEY)
                    .queryParam("text", str)
                    .queryParam("lang", "ru");

            ResponseEntity<ResponseModel> response =
                    template.getForEntity(URLDecoder.decode(builder.toUriString(), "UTF-8"), ResponseModel.class);

            if(response.getStatusCodeValue() != 200){
                System.out.println("Неожиданный ответ от сервера");
                return null;
            }

            return response.getBody().toString();
        }catch (UnsupportedEncodingException e){
            System.out.println("ошибка в кодировке" + e.getMessage());
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }


}
