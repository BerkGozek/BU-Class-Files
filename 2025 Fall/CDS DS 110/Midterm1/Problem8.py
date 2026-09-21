"""

2. Write a function called transpose(matrix) that computes and returns the transpose of
the 2D NumPy array matrix. 

The transpose of a matrix is a new matrix created by interchanging the rows and columns 
of the original matrix. 

For example, given a matrix of shape (2, 3)
    matrix = np.array([ [1, 2, 3],
                        [4, 5, 6]])

Then transpose(matrix) should return the NumPy array 

    np.array([  [1, 4],
                [2, 5],
                [3, 6]),

    which has a shape of (3, 2). 

Your function should work for a matrix of shape (m, n). 

You are NOT allowed to use the built-in NumPy transpose function to solve this problem. 

Remember to import the necessary modules. Hint: The numpy function np.zeros() can be 
used to create an array of zeros.

"""
import numpy as np

def transpose(matrix : np.array)->np.array:
    row,col = matrix.shape

    retval = np.zeros((col,row))

    for i in range(row):
        for j in range(col):
            retval[j][i]=matrix[i][j]


    return retval