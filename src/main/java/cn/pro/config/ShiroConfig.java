package cn.pro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.pro.Entity.User;
import cn.pro.service.UserService;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShiroConfig {
    @Autowired
    UserService userService;

    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        List<User> ul = userService.findAll();
        String str = "";
        for(User user   : ul){
            str+= user.getUserName()+"="+user.getPassword()+",user\n";
        }
        str+= "sang=123,user\n admin=123,admin";
        realm.setUserDefinitions(str);
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc");
        return chainDefinition;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
