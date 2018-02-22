array = [int(x) for x in input("Input array ").split(",")]

def solve(array):
    print(sum(array[:]) - min(array))
    print(sum(array[:]) - max(array))

solve(array)