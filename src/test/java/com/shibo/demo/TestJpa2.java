package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.Menu;
import com.shibo.demo.jpaTest.entity.Role;
import com.shibo.demo.jpaTest.repository.MenuRepository;
import com.shibo.demo.jpaTest.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa2 {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    MenuRepository menuRepository;

    @Test
    public void test1(){
        //这里有一些区别，需要我们进行两侧的保存
        //或者在操作上开启级联操作
        Role role=new Role();
        role.setName("role-1");
        Menu menu=new Menu();
        menu.setName("menu-3");
        menu.setUrl("menu-url-3");
        role.setMenus(new HashSet(){{
            add(menu);
        }});
        menu.setRoles(new HashSet(){{
            add(role);
        }});
        this.menuRepository.save(menu);
        //保存后直接获取主键
        System.out.println(menu);
    }

    @Test
    public void test2(){
        //懒加载
        this.roleRepository.findAll().stream().forEach(e->{
            System.out.println(e+" "+this.menuRepository.findMenusByRolesIs(e));
        });
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test3(){
        this.roleRepository.deleteById(1l);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test4(){
        //应先查询再删除
        this.menuRepository.deleteById(3l);
    }

    @Test
    public void test5(){
        //目标一次性获取信息,这里需要使用entityGraph来进行我们的左联操作
        Role r=this.roleRepository.findById(3l);
        System.out.println(r+" "+r.getMenus());

        Menu m=this.menuRepository.findById(4l);
        System.out.println(m+" "+m.getRoles());
    }
}
