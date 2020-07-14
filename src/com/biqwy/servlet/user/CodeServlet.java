package com.biqwy.servlet.user;


import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biqwy.util.CodeUtil;


/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/getCode")
public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ���ù��������ɵ���֤�����֤��ͼƬ
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

        // ����λ���ֵ���֤�뱣�浽Session�С�
        HttpSession session = req.getSession();
        session.setAttribute("code", codeMap.get("code").toString());

        // ��ֹͼ�񻺴档
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // ��ͼ�������Servlet������С�
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}