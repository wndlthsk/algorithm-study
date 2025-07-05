a, b, c, d, e, f = map(int, input().split())

up_x_hang = a * e
up_val = c * e

down_x_hang = d * b
down_val = f * b

X = (up_val - down_val) // (up_x_hang - down_x_hang)
Y = (a * f - c * d) // (up_x_hang - down_x_hang)
print(X, Y)

# 문제에서 해가 정수로 유일하게 존재함이 보장되었기 때문에, // (정수 나눗셈) 으로 연산