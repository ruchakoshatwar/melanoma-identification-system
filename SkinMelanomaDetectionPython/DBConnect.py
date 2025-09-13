#!C:\Users\Spider Projects\AppData\Local\Programs\Python\Python39\python
import mysql.connector as mycon

def connect() : 
    con=mycon.connect(host='bm5jqgqw3udrinqjdm24-mysql.services.clever-cloud.com',user='uctc281psvdxokog',password='LjuUlE4jGzfZkaTgfEUL',database='bm5jqgqw3udrinqjdm24')
    return con