package com.finalproject;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ManagedBean
@ApplicationScoped
public class GraphicRender {

    private StreamedContent graphicText;
    private static Map<String, BufferedImage> imageMap = new HashMap<>();

    @PostConstruct
    public void pointlessInit() {
        System.out.println("Initialized");
    }

    public StreamedContent getMagicImage() {

        FacesContext context = FacesContext.getCurrentInstance();
//        System.out.println(context.getRenderResponse());
        String title = context.getExternalContext().getRequestParameterMap().get("title");
        String film_id = context.getExternalContext().getRequestParameterMap().get("image_id");

//        System.out.println(title);
//        System.out.println(film_id);

        if (title == null) {
            return new DefaultStreamedContent();
        } else {

            BufferedImage bufferedImg = imageMap.get(film_id);

            if (bufferedImg == null) {

                Random random = new Random();
                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();

                bufferedImg = new BufferedImage(106, 150, BufferedImage.TYPE_INT_RGB);
                Graphics2D render = bufferedImg.createGraphics();
                render.setColor(new Color(r, g, b));
                render.fillRect(bufferedImg.getMinX(), bufferedImg.getMinY(), bufferedImg.getWidth(), bufferedImg.getHeight());
                render.setColor(new Color(0));
                render.setFont(new Font("Truetype", Font.BOLD, 10));
                String[] stringette = title.split("\\s+");
                for (String string : stringette) {
                    System.out.println(string);
                }

                for(int i = 0; i < stringette.length; i++) {
                    render.drawString(stringette[i], (bufferedImg.getWidth() / 6), ((bufferedImg.getHeight() * (i + 1)) / 4));
                }
                render.dispose();
                imageMap.put(film_id, bufferedImg);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try {
                ImageIO.write(bufferedImg, "png", outputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return new DefaultStreamedContent();
            }


            return new DefaultStreamedContent(new ByteArrayInputStream(outputStream.toByteArray()), "image/png");


        }

    }

    public StreamedContent getGraphicText() {
        return graphicText;
    }

    public void setGraphicText(StreamedContent graphicText) {
        this.graphicText = graphicText;
    }

}
