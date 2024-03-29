package utils;

/**
 * @author shangfeng
 * @Title: ServerEnum
 * @Package com.fh.commons.response
 * @Description: ${todo}
 * @date 2019/7/2  10:28
 */
public enum ServerEnum {

    SUCCESS(200,"操作成功"),
    DEL_DEPT_SCUCCESS(201,"删除部门成功"),
    LOGIN_ISNULL(5000,"用户名或者密码为空"),
    PHONE_ISNULL(5007,"手机号不能为空"),
    USERNAME_NOTEXIST(5001,"用户名输入有误。"),
    PASSWORD_WRONG(5002,"密码输入错误，请检查"),
    LOGIN_SUCCESS(5003,"登陆成功"),
    LOGIN_EXPIRED(5004,"登录超时，请重新登陆"),
    SECRET_ERROR(5005,"传入的token值有误，不能通过签名验证"),
    TOKEN_TIMEOUT(5006,"登录失效，请重新登录"),
    TOKEN_ISNULL(5008,"获取到的Token值为空"),
    NO_MENU_RIGHT(6000,"没有权限访问该菜单，请联系管理员"),
    NOT_DATA(7001,"没有要导出的数据"),
    HTTP_URL_ISNULL(8002,"你传递的URL路径为空了"),
    SERVER_TIMEOUT(8004,"服务连接请求超时"),
    HTTP_ERROR(8003,"接口访问失败"),
    SERVER_STOP(8005,"服务连接不上"),
    SAFETY_ERROR(9000,"接口验签失败"),
    SAFETY_BAD(9001,"接口被非法攻击"),
    SAFETY_TIMEOUT(9002,"接口访问超时"),
    SAFETY_INVALID(9003,"签名值无效"),
    SAFETY_REPLAY_ATTACK(9004,"接口被重放攻击"),
    LOGIN_PHONEORCODE_ISNULL(10000,"手机号或者验证码为空了"),
    LOGIN_CODE_ERROR(10001,"验证码无效"),
    ERROR(500,"操作失败");

    private ServerEnum(int code ,String message){
        this.code=code;
        this.message=message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
