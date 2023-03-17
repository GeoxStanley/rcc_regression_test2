package pojo;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import pojo.Constant.Update_SMS_Template.Update_SMS_Template_Pojo;
import pojo.SMS_Template.sms_Template;

import static utility.Utility.fetchvalue;

public class PayloadManager {

    private static Gson gson = new Gson();

    public static String AuthorizationPayload() {
        return gson.toJson(LoginPojo.builder().login(fetchvalue("Email"))
                .password(fetchvalue("Password")).build());
    }

    public static String Add_SMS_Template_Payload() {
        return gson.toJson(sms_Template.builder().name(new Faker().app().name() + " " + new Faker().name().fullName())
                .content(new Faker().name().fullName()).build());
    }

    public static String Update_SMS_Template_Payload() {
        return gson.toJson(Update_SMS_Template_Pojo.builder()
                .id(5)
                .name(new Faker().app().name())
                .content(new Faker().name().fullName()).build());
    }
}

