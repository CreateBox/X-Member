package com.manager.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091900545603";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2+NpUFwQScF5lrZ7npNu/HTxt5DMGzU0HWt0JvDwM+AzwEkua2jt0w7WAsjlJO+/yLbeLoiOUQg+lpurHMoQKLZX4mODa5L95K2CbObuoYoHoGD/Im0XbsKrbCZRwOHvWNfJ4pwGittl0K9N4lfgo93RiBolYmbnkWVvQgAMpz2ccvzV+k/AxEEIH7d5osw3X3UbOasyg2scY81Sk13FMf/biRYNXkKMjsbUmi1dYVrmZaAuduRFKgAp+07JDUiX5M8n0jy+QqanHuflfVOUkxNXCMeOgc+pr/9F+XBaM7MV0Tz4e9GVSIHK4QaHw/ywXuvdSE/mtgr/RdwP9WlKdAgMBAAECggEAaYCye3xN98fdVmm3T8BqiRd1ibPkjE6C1PPasktcoOnCpAcYmzCsydYzaQLbL1QlNhKQXC5gr5Mr7IuDotqI8kl4yUB1nyH5GggeC0NN5njuiQK6fJSzwkprKiOq+M5I8apnppQ9yDIAzxCaPlTTI+QTspYsSe9SFc5Et8Ooj0kzH1SZ9UjIDrMxW9HdhY0mk/5wM8kmLrzdbiZ+kVs8Scn5MVGsx/mkhtfIaLXmZyX3wNtKDB6HcsfAINdYBlLHBiyostSMdzTtddSLGr8EIgmIZT2r+kkRn24iJ/pwOYEMBKS8fSzlqGHrTfB8AN1FhZQSh3pDBOkoNFW8DtwQIQKBgQDlI0WGeXqtikEVmMPIasFs0/22M9RB/3EIg4g4TrKMhcDwZS1EJjrH+eCz1UC/BEHUL5aRnmxYjD7YEHQngzOUQ5+Bu0kY492qPkR+7GR142McAH5KmSxw2MnA//6kcKI0r9z/kOPTItOfB5SFVMnKMFRbbPSTl/CA60HI9TL1SQKBgQDMbBZlL5VDtkDa+KaHx5uv86su9I6oAV29LmZUb9IVyFmXbRuerlrpyT6S0qJPWM0IikSDp6XZb0NdjaeKtkp/yoqi2xtthLdtKbH0UBA/jlr7ao3xoAXImjzqjJLlFIoZf5QrgXmk3ehpRyUn0c5hhorYRaPIKCw4uXFWc2m2tQKBgBnmksVQlf1n01ONoRPWfWa/z734vdV3+l7r/0neG3Cm7dg+l49Mgvh31l59jIQLByXk+zAaqESaFcB2m6qbugjYW/9eHDUkDLphr3xpXDG3MkzIAX6NMejPmH6ocTBFSxCJkIGS7y2+kg033iH0I5snO2HaPwsv8Y+hCB6fGNOBAoGBAIBh9aKwwpaW9J5RAQ1PQCi96KmBr8I1sXBpnpyy6YcCn7mpLWp35+Lhn6nIHWWlyIbvh14DwPYQmYc8upc0Kw+c3XqwDsa2ThiB0iA01C+GMP+rCOBR9q/opg9MH8k9IAophJ3aH9J6B0dvBhe+/VVkkPiIq/a9vCAX3uVDcIXtAoGBAKR1pmSEMhTd2Y8xfVkIYhKBma6eOZ9NSEfOwvlEWtkXNN4V2lpLtNFKebXs+c+nUXOVIhDEHMgu/OAj9irqgx4gQKNg+um/bCA5ZD/WZfujr+FSyvw9rolk78w5iEOhAeu53TI/SfDCxdlXX7yPkglbLnmmcDQ7JmDHj6uig+aI";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyl+3n+BW6bMnE0dk7wXjlyf75q8CmS8jNyU2uvtlXJG+3hOdL73nM3tDuf/vjUcepRh2uoezq9wFoe8nJ/BEvDHHiOBY6LnkCwBDHiNIbNerJ+TRiWTQhpfwi75Lzr67++i17HXntJF6oBQ7FCDDaXeeYxUcr0ihB+swC8nENTdjh+0RhALixNpBjT7q7MYUVBz3ZYxRx+Ea1KMDlaQ4teVd5WpZIfYOtIZUGc3WDMEtnoe9TEVyAIba1Ac+q71YFd3IPDYTBYLbXLp+Mz7i/m8pCl0GoA7J4PMWZH+eN0HSmv0/ttd/NQWtGdabRuv9U+1bnNXzjFr22iqkfSoE0QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://localhost:8080/alipay/notify_url.jsp";
    public static String notify_url = "http://172.16.7.251:80/alipay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://localhost:8080/alipay/return_url.jsp";
    public static String return_url = "http://172.16.7.251:80/alipay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/log";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

