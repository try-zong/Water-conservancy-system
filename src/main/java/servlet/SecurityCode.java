package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecurityCode")
public class SecurityCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String str = "1234567890" +
    		"abcdefghijklmnopqrstuvwxyz" +
    		"ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] code = str.toCharArray();	
    private static final int WIDTH = 60;     //������֤��ͼƬ���
    private static final int HEIGHT = 20;   //������֤��ͼƬ�߶�
    private static final int LENGTH = 4;    //������֤�볤��
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Expires", "0");
        resp.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, 
        		BufferedImage.TYPE_INT_RGB);
        Font mFont = new Font("Arial",Font.TRUETYPE_FONT,18);
        Graphics grap = image.getGraphics();
        Random rd = new Random();
        //���ñ�����ɫ�����ƾ��α���������
        grap.setColor(new Color(rd.nextInt(55)+200,rd.nextInt(55)+200,
        		rd.nextInt(55)+200));
        grap.fillRect(0, 0, WIDTH, HEIGHT);
        grap.setFont(mFont);
        //���߿�
        grap.setColor(Color.black);
        grap.drawRect(0, 0, WIDTH-1, HEIGHT-1);
       //������֤��
        String result = "";
        for (int i = 0; i < LENGTH; ++i) {
            result += code[rd.nextInt(code.length)];
        }
        HttpSession se = req.getSession();
        se.setAttribute("rand",result);
        //������֤��
      //������֤�벢����
        for (int i = 0; i < result.length(); i++) {
            grap.setColor(new Color(rd.nextInt(200),rd.nextInt(200),
            		rd.nextInt(200)));
            grap.drawString(result.charAt(i)+"", 12 * i + 1, 16);
        }
        //���ɸ��ŵ�
        for (int i = 0; i < 2; i++) {
            grap.setColor(new Color(rd.nextInt(200),rd.nextInt(200),
            		rd.nextInt(200)));
            int x1 = rd.nextInt(WIDTH);
            int x2 = rd.nextInt(WIDTH);
            int y1 = rd.nextInt(HEIGHT);
            int y2 = rd.nextInt(HEIGHT);
            grap.drawLine(x1, y1, x2, y2);
        }
        //�ͷ�ͼ����Դ
        grap.dispose();
        try {
			OutputStream os= resp.getOutputStream();
			ImageIO.write(image,"JPEG", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
