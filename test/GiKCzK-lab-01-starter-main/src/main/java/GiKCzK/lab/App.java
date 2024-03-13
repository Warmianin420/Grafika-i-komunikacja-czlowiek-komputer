package GiKCzK.lab;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class App {
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;
// wczytaj obraz
        try {
            f = new File("img/drzewo.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
// pobieramy szerokość i wysokość obrazów
        int width = img.getWidth();
        int height = img.getHeight();
        // pobieramy środkowy piksel
        int p = img.getRGB(width / 2, height / 2);
// Odczytujemy wartosci kanalow przesuwajac o odpowiednia liczbe bitow w prawo, tak aby 
// kanal znalazł się na bitach 7-0, następnie zerujemy pozostałe bity używając bitowego AND z maską 0xFF.

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

// Ustawiamy wartosci poszczegolnych kanalow na przykładowe liczby


        a = 255;
        r = 100;
        g = 150;
        b = 200;

// TODO: ustaw ponownie wartości kanałów dla zmiennej p

        //zadanie 2
        Color piksel = new Color(r, g, b, a);
        img.setRGB(width / 2, height / 2, piksel.getRGB());

        //zadanie 3
        allWhite(img);

        //zadanie 4
//        imgNegative(img);

// zapis obrazu
        try {
            f = new File("img/modified.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void allWhite(BufferedImage img) {
        // TODO: zaimplementuj
        ;

        Color piksel = new Color(255, 255, 255, 255);

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                img.setRGB(j, i, piksel.getRGB());
            }
        }
    }

    public static void imgNegative(BufferedImage img) {
        Color piksel = new Color(255, 255, 255, 255);
        int r,g,b;
        int p;

        for (int i=0; i<img.getHeight(); i++)
        {
            for (int j=0; j<img.getWidth(); i++)
            {
                p = img.getRGB(i, j);
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p & 0xff;
                img.setRGB(i, j, new Color(255-r, 255-g, 255-b).getRGB());
            }
        }
    }
}
