import tkinter as tk
from tkinter import filedialog
from tkinter import *
import tkinter.font as font
import cv2
import numpy as np

def cartoonize(img_1):
    num_down = 2
    num_bilateral = 7 # bilateral count
    img_rgb = cv2.imread(img_1)

    img_rgb = cv2.resize(img_rgb,(900,900))

    img_color = img_rgb

    for i in range(num_down):
        img_color = cv2.pyrDown(img_color)

    for i in range(num_bilateral):
        img_color = cv2.bilateralFilter(img_color,d= 20,sigmaColor = 10,sigmaSpace=10)

    for i in range(num_down):
        img_color = cv2.pyrUp(img_color)

    img_gray = cv2.cvtColor(img_rgb,cv2.COLOR_RGB2GRAY)
    img_blur = cv2.medianBlur(img_gray,7)
    img_edge = cv2.adaptiveThreshold(img_blur,255,cv2.ADAPTIVE_THRESH_MEAN_C,cv2.THRESH_BINARY,blockSize=9,C=2)

    img_edge = cv2.cvtColor(img_edge,cv2.COLOR_GRAY2RGB)
    img_cartoon = cv2.bitwise_and(img_color,img_edge)
    
    cv2.imshow('cartoon',img_cartoon)
    cv2.imwrite(img_1[:-4]+"_cartoon.jpg",img_cartoon)
    '''
    cartoon_gray = cv2.cvtColor(img_cartoon,cv2.COLOR_BGR2GRAY)
    # threshold 
    th, threshed = cv2.threshold(gray, 100, 255,cv2.THRESH_BINARY|cv2.THRESH_OTSU) 
  
    # findcontours 
    cnts = cv2.findContours(threshed, cv2.RETR_LIST,cv2.CHAIN_APPROX_SIMPLE)[-2] 

    for cnt in cnts: 
        if s1<cv2.contourArea(cnt) <s2: 
            xcnts.append(cnt)
    '''
    return



def openfilename(): 
    filename = filedialog.askopenfilename(title ="Input Image")
    return filename

def ButtonClicked(event):
    #  Dialog Box Opened 
    imagepath = openfilename()
    #Taking the image path for the path obtained from the dialogbox
    cartoonize(imagepath)



try:
    # Creating a GUI window
    master = Tk(screenName=" Home ")
    master.configure(bg = "white")
    #width, height = master.winfo_screenwidth(), master.winfo_screenheight()
    #Defining size attributes to the GUI window
    master.geometry("400x400")

    myfont = font.Font(size = 15)

    button = Button(master,text = " SelectImage ",bg = "green" ,fg = "black",width = 15)
    button['font'] = myfont
    button.grid(row = 0,column = 1)
    button.bind("<Button>",ButtonClicked)
    # Button Clicked Event is used to do the needed execution
    master.mainloop()
finally :
    pass




