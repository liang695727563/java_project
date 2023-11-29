package zheng.lk.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import zheng.lk.enter.loginEnter;

import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<loginEnter> {

    //@Select("select * from crucical.zheng_lk_log_on")
    List<loginEnter> getpage();

}
