N = int(input())

sangsungja = 0
while True:
  if sangsungja > N:
    sangsungja = 0
    break
  
  namuzi = sum(map(int, str(sangsungja)))
  temp = sangsungja + namuzi
  
  if temp == N:
    break
  
  sangsungja += 1
print(sangsungja)