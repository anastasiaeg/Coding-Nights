time = input("Input time: ").split(":")
hour = int(time[0]);
if (time[2][2] == 'P') :
    hour += 12;
print(str(hour)+":"+time[1]+":" + time[2][0] + time[2][1])