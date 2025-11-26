nums = [int(input()) for _ in range(5)]

avg = sum(nums) // 5
mid = sorted(nums)[2]

print(avg)
print(mid)