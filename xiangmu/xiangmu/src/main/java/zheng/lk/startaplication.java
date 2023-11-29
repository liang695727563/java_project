package zheng.lk;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;

@SpringBootApplication
@MapperScan({"zheng.lk.mapper"})  //这个注解就是可以扫描指定路径下的mapper的bean,不用在每一个mapper接口上加@Mapper注解
public class startaplication {
    public static void main(String[] args) {

        SpringApplication.run(startaplication.class,args);
    }
}
