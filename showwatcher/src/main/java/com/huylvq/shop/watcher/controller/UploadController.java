/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.huylvq.shop.watcher.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.huylvq.shop.watcher.config.CloudinaryConfig;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.Map;

/**
 *
 * @author hanly
 */
@WebServlet(name = "UploadController", urlPatterns = {"/upload"})
@MultipartConfig(maxFileSize = 10*1024*1024)
public class UploadController extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part file = request.getPart("file");
        if(file == null || file.getSize() == 0){ // trường hợp không nhận được file
            request.setAttribute("error", "File not found!");
            RequestDispatcher rd = request.getRequestDispatcher("upload.jsp");
            rd.forward(request, response);
            return;
        }//trường hợp nhận được file
        Cloudinary cloudinary = new CloudinaryConfig(getServletContext()).getClient();
        
        
         byte[] data = file.getInputStream().readAllBytes();
        
        Map uploadRes = cloudinary.uploader().upload(data, ObjectUtils.asMap(
                "resourc_type","image"
        ));
        String url = (String) uploadRes.get("secure_url");
        request.setAttribute("success", "DONE");
        request.setAttribute("imageUrl", url);
        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }



}
