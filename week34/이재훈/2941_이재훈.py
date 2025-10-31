string = input()

dictionary = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for x in dictionary:
  string = string.replace(x, '*')

print(len(string))