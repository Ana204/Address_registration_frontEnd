package br.com.addressregistration.Utils;

public class Utils {
    public static final String URL_USERS = "http://";
    public static final String BASE_URL_VIA_CEP = "https://viacep.com.br/ws/01001000/json/";

    public static String checkNull(String value){
        if (value.equals("null"))
            return "";
        else return value;
    }
}
