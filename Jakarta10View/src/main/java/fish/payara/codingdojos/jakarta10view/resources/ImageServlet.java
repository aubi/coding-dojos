package fish.payara.codingdojos.jakarta10view.resources;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "ImageServlet", urlPatterns = "/image.png")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        BufferedImage bufferedImage = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("Payara", 50, 50);
        
        ImageIO.write(bufferedImage, "png", resp.getOutputStream());
    }
}
