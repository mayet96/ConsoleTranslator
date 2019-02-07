package ru.id61890868.ConsoleTranslator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class Main {

    private static final String url = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    //API_KEY яндекс.переводчика (тестовый, валиден до 25.02.2019)
    private static final String API_KEY = "trnsl.1.1.20190205T155945Z.1aefd439be03bf8e." +
            "4f37ccec873aac57fcc5db89a755526efc4a94ab";

    public static void main(String[] args) {

        String line = InputHelper.inputSting("Введите строку");
        try {
            System.out.println(translate(line));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * @param str строка, которая будет переведена на русский язык
     * @return null при
     */
    static String translate(String str) throws Exception {
        try {
            RestTemplate template = new RestTemplate();

            //Составляем url с параметрами
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("key", API_KEY)
                    .queryParam("text", str)
                    .queryParam("lang", "ru");

            //получаем ответ, отправив GET запрос по созданному url
            ResponseEntity<ResponseModel> response =
                    template.getForEntity(URLDecoder.decode(builder.toUriString(), "UTF-8"), ResponseModel.class);

            //если статус-код не 200, значит перевод выполнен не был.
            if (response.getStatusCodeValue() != 200) {
                throw new Exception("Неожиданный ответ от сервера");
            }
            return response.getBody().toString();
        } catch (UnsupportedEncodingException e) {
            throw new Exception("Ошибка в кодировке: ", e);
        }
    }


}
