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
        User user1 = new User("����",3,"123","��ͨ��Ա","����") ;
        array_user.add(user1);
        User user2 = new User("����",3,"123","��ͨ��Ա","����") ;
        array_user.add(user2);
        User user3 = new User("����",3,"123","��ͨ��Ա","����") ;
        array_user.add(user3);
        User user4 = new User("����",3,"123","��ͨ��Ա","����") ;
        array_user.add(user4);
        User user5 = new User("����",3,"123","��ͨ��Ա","����") ;   
        array_user.add(user5);
        application = sce.getServletContext();
        this.application.setAttribute("User", array_user);
        ArrayList<WaterGate> array_gate= new ArrayList<WaterGate>();
        WaterGate gate1 = new WaterGate("ͭɽբ", "Z01","1992��2��1��",
        		"����","����","γ��","���") ;
        array_gate.add(gate1);
        WaterGate gate2 = new WaterGate("����բ","Z03","1998��5��6��",
        		"����","����","γ��","���") ;
        array_gate.add(gate2);
        WaterGate gate3 = new WaterGate("������բ","Z10","1995��8��6��",
        		"����","����","γ��","���") ;
        array_gate.add(gate3);
        WaterGate gate4 = new WaterGate("��ׯբ","Z22","1999��9��12��",
        		"����","����","γ��","���") ;
        array_gate.add(gate4);
        WaterGate gate5 = new WaterGate("����բ","Z32","1993��4��9��",
        		"Ǯ��","����","γ��","���") ;
        array_gate.add(gate5);
        WaterGate gate6 = new WaterGate("����Ϫբ","Z34","2002��11��25��",
        		"����","����","γ��","���") ;
        array_gate.add(gate6);
        WaterGate gate7 = new WaterGate("��Ϫբ","Z32","2008��9��6��",
        		"�¾�","����","γ��","���") ;
        array_gate.add(gate7);
        WaterGate gate8 = new WaterGate("��̨ͷբ","Z99","1992��2��2��",
        		"��ʽ","����","γ��","���") ;
        array_gate.add(gate8);
        WaterGate gate9 = new WaterGate("��̨ͷբ","Z88","1992��2��3��",
        		"��֭","����","γ��","���") ;
        array_gate.add(gate9);
        WaterGate gate10 = new WaterGate("��̨ͷբ","Z77","1992��2��4��",
        		"����","����","γ��","���") ;
        array_gate.add(gate10);
        application = sce.getServletContext();
        this.application.setAttribute("WaterGate",array_gate);
    }
	
}
