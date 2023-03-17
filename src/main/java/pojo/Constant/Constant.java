package pojo.Constant;

import Base.TestBase;

public class Constant extends TestBase {
    //Notification MicroService
    public static String add_sms_template_EndPoint = "/basic-templates";
    public static String Update_sms_template_EndPoint = "/basic-templates";
    public static String Get_sms_template_ID_EndPoint = "/basic-templates/6";
    public static String Get_sms_template_Invalid_ID_EndPoint = "/basic-templates/600";
    public static String Send_SMS_Template_EndPoint = "/notifications";
    public static String Delete_SMS_Template_EndPoint = "/basic-templates/";


    //CustomerFeeds MicroService
    public static String Get_AllCustomer_Feed = "/customer-feeds";
    public static String Get_FeedComments = "/feed-comments";
    public static String Get_FeedActivity_Logs = "/feed-activity-logs";
    public static String Get_FeedCategories = "/feed-categories";
    public static String Get_FeedLabel = "/feed-labels";
    public static String Get_FeedType = "/feed-types";
    public static String Get_FeedItems = "/feed-items";
    public static String Get_Enrollees = "/enrollees";
    public static String Get_SatisfactionSurvey = "/satisfaction-surveys";


}
