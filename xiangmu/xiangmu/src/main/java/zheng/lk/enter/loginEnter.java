package zheng.lk.enter;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *登录信息实体
 */

@TableName("ZHENG_LK_LOG_ON")
@Data
//@Component
public class loginEnter {

     /**
      * 账户id
      */
     private String id;

     /**
      * 用户名
      */
     private String user;


     /**
      * 账户密码
      */
     private String password;


     /**
      * 账户状态
      */
     private int status;


     /**
      * 密保信息
      */
     private String confidentiality;


     /**
      *  手机号
      */
     private String phone;

}
