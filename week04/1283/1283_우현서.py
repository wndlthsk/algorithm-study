import sys

n = int(sys.stdin.readline())
keys = []
for i in range(n):
    raw_option = sys.stdin.readline().rstrip()
    option = raw_option.split()
    result = raw_option
    check = 1

    for j in range(len(option)):
        if option[j][0].lower() not in keys:
            keys.append(option[j][0].lower())
            option[j] = f"[{option[j][0]}]{option[j][1:]}"
            result = " ".join(option)
            check = 0
            break


    check_break = 0
    if check == 1:
        for x in range(len(option)): # save, all
            check_break = 0
            for y in range(len(option[x])): # s,a,v,e
                if option[x][y].lower() not in keys:
                    keys.append(option[x][y].lower())
                    option[x] = option[x][:y] + f"[{option[x][y]}]" + option[x][y+1:]
                    result = " ".join(option)
                    check_break = 1
                    break
            if check_break == 1:
                break

    print(result)
