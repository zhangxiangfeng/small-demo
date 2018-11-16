package cn.openread.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 设计一个支持100000个短链接,长链接转化
 * <p>
 * 思路：key->获取value 采用 ConcurrentHashMap
 */
public class Codec {

    private static final int DEFAULT_SHORT_ID_LENGTH = 8;
    private static final String SHORT_DOMAIN = "http://t.com/";
    public static final int MAX_NUM = 10000000;
    private static final String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private volatile static ConcurrentHashMap<String, String> storageIDValueMap = new ConcurrentHashMap<>(16);

    /**
     * 计算随机字符
     *
     * @param length 长度
     * @return 随机数
     */
    private static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = allChars.length();
        for (int i = 0; i < length; i++) {
            sb.append(allChars.charAt(getRandomNumber(len - 1)));
        }
        return sb.toString();
    }

    /**
     * 计算随机数
     */
    private static int getRandomNumber(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) throws Exception {
        //step 1.基本检查
        if (null == longUrl || longUrl.trim().equals("")) {
            return null;
        }

        //step 2.递归计算唯一ID
        String shortUrlID = this.calcShortUrlID();

        //step 3.是否超出
        if (storageIDValueMap.size() >= MAX_NUM) {
            throw new Exception(String.format("存储失败! => 存储已满 超过 %d 个，请升级该服务", MAX_NUM));
        }

        //step 4.存储+返回
        return SHORT_DOMAIN + this.putData(shortUrlID, longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (null == shortUrl || shortUrl.trim().equals("")) {
            return null;
        }
        String key = shortUrl.replace(SHORT_DOMAIN, "");
        return storageIDValueMap.get(key);
    }

    /**
     * 存储
     * 这里考虑
     * A,B存入相同内容的URL，要返回不同的短链，存在并发
     */
    private synchronized String putData(String shortUrlID, String originLongUrl) {
        String storeAfterOriginLongUrl = storageIDValueMap.putIfAbsent(shortUrlID, originLongUrl);
        if (null != storeAfterOriginLongUrl) {
            //key已经存在，重新计算值
            shortUrlID = this.calcShortUrlID();
            return putData(shortUrlID, originLongUrl);
        }
        return shortUrlID;
    }

    /**
     * 计算短链唯一ID
     */
    private String calcShortUrlID() {
        String randomKey = getRandomString(DEFAULT_SHORT_ID_LENGTH);
        if (storageIDValueMap.containsKey(randomKey)) {
            return calcShortUrlID();
        }
        return randomKey;
    }
}