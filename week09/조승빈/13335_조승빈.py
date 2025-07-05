from collections import deque

n, w, L = map(int, input().split())
arr = list(map(int, input().split()))

bridge = deque([0] * w)  
time = 0
weight_on_bridge = 0 

for truck in arr:
    while True:
      
        time += 1
       
        left = bridge.popleft()
        weight_on_bridge -= left
        if weight_on_bridge + truck <= L:
            bridge.append(truck)
            weight_on_bridge += truck
            break
        else:
           
            bridge.append(0)

time += w
print(time)
