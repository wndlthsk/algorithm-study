def solution(points, routes):
    visit = {}
   
    for r in routes:
        cnt =  0
        startPoint = r[0]
        startX,startY = points[startPoint-1]
        posX  = startX
        posY = startY
        if (str(cnt)+","+str(posX)+","+str(posY)) not in visit:
                visit[(str(cnt)+","+str(posX)+","+str(posY)) ] = 0
        else :
            visit[(str(cnt)+","+str(posX)+","+str(posY)) ] += 1
        for endPoint in range(1,len(r)):
            #startX,startY = points[startPoint-1]
            endX,endY =  points[r[endPoint]-1]
            # posX  = startX
            # posY = startY
            
            if endX>posX:
                for x in range(posX,endX):
                    cnt+=1
                    posX+=1
                    if (str(cnt)+","+str(posX)+","+str(posY)) not in visit:
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] = 0
                    else :
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] += 1
            elif endX<posX:
                for x in range(endX,posX):
                    cnt+=1
                    posX-=1
                    if (str(cnt)+","+str(posX)+","+str(posY)) not in visit:
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] = 0
                    else :
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] += 1
            
            if endY>posY:
                for y in range(posY,endY):
                    cnt+=1
                    posY+=1
                    if (str(cnt)+","+str(posX)+","+str(posY)) not in visit:
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] = 0
                    else :
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] += 1
                        
            elif endY<posY:
                for y in range(endY,posY):
                    cnt+=1
                    posY-=1
                    if (str(cnt)+","+str(posX)+","+str(posY)) not in visit:
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] = 0
                    else :
                        visit[(str(cnt)+","+str(posX)+","+str(posY)) ] += 1
    
    return  sum(1 for value in visit.values() if value > 0)
