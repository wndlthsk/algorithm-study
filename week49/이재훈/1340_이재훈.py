import sys
input = sys.stdin.readline

months = {
  "January":31, "February":28, "March":31, "April":30,
  "May":31, "June":30, "July":31, "August":31,
  "September":30, "October":31, "November":30, "December":31
}

line = input().strip()
month, day, year, time = line.split()
day = int(day[:-1])
year = int(year)
hour, minute = map(int, time.split(':'))

def is_leap(y):
  return (y % 400 == 0) or (y % 4 == 0 and y % 100 != 0)

if is_leap(year):
  months["February"] = 29

total_days = sum(months.values())

passed_days = 0
for m in months:
  if m == month:
    break
  passed_days += months[m]

passed_days += (day - 1)

total_minutes = total_days * 24 * 60
passed_minutes = passed_days * 24 * 60 + hour * 60 + minute
print(passed_minutes / total_minutes * 100)