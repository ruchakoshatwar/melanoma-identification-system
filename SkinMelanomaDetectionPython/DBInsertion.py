from DBConnect import *
def insert(partId1=0,title='NA',userid="NA",cpath="NA",dt="NA",tm="NA",cate='NA',
    sts="NA") : 
    conn = connect()    
    cursor = conn.cursor()
    args = [partId1,title,userid,cpath,dt,tm,cate]
    args1=cursor.callproc('insertDataset', args)
    print("Return value:", args1)
    #for result in cursor.stored_results():
     #       print(result.fetchall())
    cnt=cursor.rowcount 
    conn.commit()
def getSrno(cate='NA'):
    conn = connect()
    #integrated security 
    cursor = conn.cursor() 
    print("select srNo as mxid from labels where title='"+cate+"';")
    cursor.execute("select srNo as mxid from labels where title='"+cate+"';")

    #args = [userid,title,docPath,docDesc,dt,tm,key]
    #args1=cursor.callproc('insertDoc', args)
    #print("Return value:", args1)
    #for result in cursor.stored_results():
    #        print(result.fetchall())
    #cnt=cursor.rowcount
    conn.commit()
    #return cnt
 
def getMaxId():
    conn = connect()
    #integrated security 
    cursor = conn.cursor() 
    cursor.execute('select (ifnull(max(imgId),1000)+1) as mxid from dataset;')
    mxid=0
    for row in cursor: 
        mxid=row[0]
        print(int(mxid)+1)
    return mxid

 
def insertLabels() :  
    conn = connect()    
    cursor = conn.cursor() 
    args1=cursor.callproc('insertTitle')
    conn.commit()
def getDictionary() :  
    conn = connect()    
    cursor = conn.cursor() 
    cursor.execute("select srNo as key1,title as val from labels")
    out = cursor.fetchall()
    variable = {key:val for key,val in out}
    print(variable)
    conn.commit()
    return variable
def getLabelCount() :  
    conn = connect()    
    cursor = conn.cursor() 
    cursor.execute("select count(*) as cnt from labels")
    out = cursor.fetchall() 
    print(out[0][0])
    conn.commit()
    return int(str(out[0][0]).strip())