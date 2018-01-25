# Cameron Harris
# Nikhil Shirsekar
# This program counts the number of months where the first
# day of the month is on a Sunday.

sundays = 0
leap = 1
count = 2

for i in range(0, 100):
               
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 28
     if leap % 4 == 0:
          count += 1
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 30
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 30
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 30
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
     count += 30
     if count % 7 == 0:
          sundays += 1
     count += 31
     if count % 7 == 0:
          sundays += 1
          
     leap += 1

print sundays
