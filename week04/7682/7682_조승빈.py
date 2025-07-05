def find(arr,f):
    for x in range(3):
        
        flag = 1
        for y in range(3):
            if arr[x][y] != f:
                flag =0
                break
        if flag == 1:
            return 1
    for y in range(3):
        flag = 1
        for x in range(3):
            if arr[x][y] != f:
                flag =0
                break
        if flag == 1:
            return 1
    if arr[0][0]==f and arr[1][1]==f and arr[2][2]==f :
        return 1
    if arr[0][2]==f and arr[1][1]==f and arr[2][0]==f :
        return 1
    return 0   
while True:
    tic = input()
    if tic == "end":
        break
    tic = list(tic)

    if tic.count("O") > tic.count("X"):
        print("invalid")
        continue
    if tic.count("O")+1 < tic.count("X"):
        print("invalid")
        continue
    arr = []
    arr.append(tic[:3])
    arr.append(tic[3:6])
    arr.append(tic[6:])
    
    
    if find(arr,"O") ==1 and tic.count("O") < tic.count("X"):
        print("invalid")
        continue
    if find(arr,"X") ==1 and tic.count("O") >= tic.count("X"):
        print("invalid")
        continue
    if find(arr,"X")  == 0 and find(arr,"O") == 0 and tic.count(".")>0:
        print("invalid")
        continue


    print("valid")
