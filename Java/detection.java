/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author
 */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgproc.Imgproc;

class DetCara{       
    public void run(){  
        //Cargamos el path de opencv (libreria, versión x64 no la soporta)
        System.load("C:/Users/chuky/Documents/opencv/build/java/x86/opencv_java401.dll");
        
        //URL del archivo clasificador de OpenCV XML
        CascadeClassifier faceDetector = new CascadeClassifier("recursos/lbpcascade_frontalface.xml");       
        
        //URL del archivo a leer
        Mat image = Imgcodecs.imread("recursos/cara1.jpg");
        
        //Lectura del vector
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        //System.out.println(String.format("Hay %s caras", 
                //faceDetections.toArray().length));
        
        //Lectura de coordenadas a dibujar
        for(Rect rect : faceDetections.toArray()){
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        
        //Creación del nuevo .png con cuadro de detección en el
        String filename = "faceDetectionTest1.png";
        
        //Mensaje de comprobación y guradado del mismo
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
    }
}

public class detection {
    public static void main(String[] args) {         
         DetCara e = new DetCara();
         e.run();         
    }    
}
