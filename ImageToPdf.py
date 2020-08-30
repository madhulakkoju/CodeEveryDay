#The first seleting image file name should be  pdffilename_dfsdfs.jpg 
#
# This converts Landscape Images collection into a pdf
# 

import tkinter as tk
from fpdf import FPDF
from tkinter import filedialog
root = tk.Tk()
root.withdraw()
root.call('wm', 'attributes', '.', '-topmost', True)
files = filedialog.askopenfilename(multiple=True) 

var = root.tk.splitlist(files)
filePaths = []
for f in var:
    filePaths.append(f)

from fpdf import FPDF
pdf = FPDF('L',"mm",(250,480))
# imagelist is the list with all image filenames
for image in filePaths:
    pdf.add_page()
    pdf.image(image)
i = filePaths[0].index('_')
name = filePaths[0][0:i+1]
pdfname = name +".pdf"

pdf.output(pdfname, "F")
