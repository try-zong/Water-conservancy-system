package listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import Entity.User;
import Entity.WaterGate;


@WebListener
public class ServerInitListener implements ServletContextListener {
	private ServletContext application = null;
    public void contextInitialized(ServletContextEvent sce)  { 
        ArrayList<User> array_user= new ArrayList<User>();
        User user1 = new User("张三",3,"123","普通会员","正常") ;
        array_user.add(user1);
        User user2 = new User("李四",3,"123","普通会员","正常") ;
        array_user.add(user2);
        User user3 = new User("王五",3,"123","普通会员","正常") ;
        array_user.add(user3);
        User user4 = new User("赵六",3,"123","普通会员","正常") ;
        array_user.add(user4);
        User user5 = new User("陈七",3,"123","普通会员","正常") ;   
        array_user.add(user5);
        application = sce.getServletContext();
        this.application.setAttribute("User", array_user);
        ArrayList<WaterGate> array_gate= new ArrayList<WaterGate>();
        WaterGate gate1 = new WaterGate("铜山闸", "Z01","1992年2月1日",
        		"张三","经度","纬度","简介") ;
        array_gate.add(gate1);
        WaterGate gate2 = new WaterGate("龙门闸","Z03","1998年5月6日",
        		"李四","经度","纬度","简介") ;
        array_gate.add(gate2);
        WaterGate gate3 = new WaterGate("月亮湾闸","Z10","1995年8月6日",
        		"王武","经度","纬度","简介") ;
        array_gate.add(gate3);
        WaterGate gate4 = new WaterGate("沈庄闸","Z22","1999年9月12日",
        		"赵六","经度","纬度","简介") ;
        array_gate.add(gate4);
        WaterGate gate5 = new WaterGate("三堡闸","Z32","1993年4月9日",
        		"钱七","经度","纬度","简介") ;
        array_gate.add(gate5);
        WaterGate gate6 = new WaterGate("南笤溪闸","Z34","2002年11月25日",
        		"刘八","经度","纬度","简介") ;
        array_gate.add(gate6);
        WaterGate gate7 = new WaterGate("好溪闸","Z32","2008年9月6日",
        		"陈九","经度","纬度","简介") ;
        array_gate.add(gate7);
        WaterGate gate8 = new WaterGate("南台头闸","Z99","1992年2月2日",
        		"孙式","经度","纬度","简介") ;
        array_gate.add(gate8);
        WaterGate gate9 = new WaterGate("北台头闸","Z88","1992年2月3日",
        		"铁汁","经度","纬度","简介") ;
        array_gate.add(gate9);
        WaterGate gate10 = new WaterGate("东台头闸","Z77","1992年2月4日",
        		"花藤","经度","纬度","简介") ;
        array_gate.add(gate10);
        application = sce.getServletContext();
        this.application.setAttribute("WaterGate",array_gate);
    }
	
}
