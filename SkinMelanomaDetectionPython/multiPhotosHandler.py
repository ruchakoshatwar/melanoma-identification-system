#!C:\Users\Megha Home\AppData\Local\Programs\Python\Python310\python

import shutil
import cgi, os
from FunFactory import *
from DBInsertion import *
from Threshold import *
UPLOAD_DIR=os.getcwd()+"\\DataSet\\temp\\" 
UPLOAD_DIR1=os.getcwd()+"\\DataSet" 
print("""\
Content-Type: text/html\n
<html>
<body>

""")

print("sss")
form = cgi.FieldStorage()
 
category=form.getvalue("category")
print(category)
try:
   os.mkdir(UPLOAD_DIR+"/"+category) 
except FileExistsError:
   print("directory exist")
 
try:
    os.mkdir(UPLOAD_DIR1+"/"+"/train/") 
except FileExistsError:
    print("directory exist")
try:
    os.mkdir(UPLOAD_DIR1+"/"+"/test/") 
except FileExistsError:
    print("directory exist") 
 
 
fileitem = form['file']

if 'file' in form:

   filefield = form['file']
   if not isinstance(filefield, list):
      filefield = [filefield]
    
   for fileitem in filefield:
      print("f"+fileitem.filename)
       #if fileitem.filename:
          #fn = os.path.basename(fileitem.filename)
      #docid=getMaxIdParts1()
      #print("id="+str(docid))
      #nm,ext=os.path.basename(fileitem.filename).split('.')
      #fn=str(docid1)+"_"+str(docid)+"."+ext
      #print("file")
      #print(fn)
      filename=os.path.basename(fileitem.filename)
      print(filename)
      print("file")
          # save file
      with open(UPLOAD_DIR+"/"+category+"/" + filename, 'wb') as f:
         print("saved")
         shutil.copyfileobj(fileitem.file, f)
      print("saved")
      print("filename="+filename +" "+category)
      #insertCarPartPhotos(docid1,title,docid,userid,fn,dt,tm,category)
      img_preprocessing1(filename,category)
 
print("<html>")
print("<head>")
print("<meta http-equiv='refresh' content='0;url=http://localhost:8080/datasetInsrtPython?sts=success'/>")
print("</head>")
print("</html>")