import numpy as np

def trace(input):
    length = len(input)
    input = input[1:length-1]
    rows = input.split(";")
    matrix = []
    for i in range(0,len(rows)):
        row = rows[i].split(",")
        temp = []
        for j in row:
          temp.append(int(j))
        matrix.append(temp)
    transpose = np.transpose(matrix)
    result = np.matmul(matrix,transpose)

    length = len(result)
    dg = 0
    for i in range(0,length):
        dg+=result[i][i]
    return dg

input = "[2,3,4;3,1,2]"
print(trace(input))
