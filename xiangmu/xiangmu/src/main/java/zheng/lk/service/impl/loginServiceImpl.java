package zheng.lk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zheng.lk.enter.loginEnter;
import zheng.lk.mapper.LoginMapper;
import zheng.lk.service.loginService;

import javax.annotation.Resource;
import java.util.List;


@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private LoginMapper mapper;

    @Override
    public List<loginEnter> getpage(){
        return this.mapper.getpage();
    }

}
