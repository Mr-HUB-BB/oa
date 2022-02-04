package com.big_fish.oa.service.exception;

/**
 * ClassName: BussinessException
 * Description:业务逻辑异常
 * date: 2022/1/30 1:13
 *
 * @author: 孟家宝
 * @version:
 * @since: JDK 1.8
 */
public class BussinessException extends RuntimeException{
    private String code; //异常编码，异常的标识
    private String massage; //异常具体的文本消息
    public BussinessException(String code, String massage){
        super(code+":"+massage);
        this.code =code;
        this.massage=massage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
