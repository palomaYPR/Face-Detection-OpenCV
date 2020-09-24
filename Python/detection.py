import numpy as np
import cv2 

face_cascade = cv2.CascadeClassifier('C:/**Sitio donde esta guardado el ->**/haarcascade_frontalface_alt.xml')


cap = cv2.VideoCapture(0) #Se consultan los modulos de la camara para que se active.

while(True): 
    ret, img = cap.read() 
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY) 
    faces = face_cascade.detectMultiScale(gray, 1.3, 5) 

    for (x,y,w,h) in faces: 
        cv2.rectangle(img,(x,y),(x+w,y+h),(123.255,0),2)

    cv2.imshow('Reconocimiento Facial',img)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()

