first = input()
second = input()
third = input()

color = [
  "black",
  "brown",
  "red",
  "orange",
  "yellow",
  "green",
  "blue",
  "violet",
  "grey",
  "white"
]

first_idx = color.index(first)
second_idx = color.index(second)
third_idx = color.index(third)

p = 10 ** third_idx

print((first_idx * 10 + second_idx) * p)