"""

2. A square matrix is upper triangular if all its entries a_(ij) where i > j are zero; that is, all its
entries below the diagonal, where the row number exceeds the column number, are zero. 

Write a function check_upper_tri() that checks whether a square matrix, represented by a 2D
numpy array, is upper triangular. 

You can assume the input is a square 2D numpy array of numbers. 

(Don't worry about eﬃciency; you can iterate over the numbers that aren't in the
lower left triangle without being penalized, for example.)

"""

import numpy as np

def check_upper_tri(mat : np.ndarray)->bool:
    row,col = mat.shape()

    if(not(row==col)):
        raise ValueError("Parameter has to be a square matrix. ")

    isTri : bool = True
    for i in range(row):
        for j in range(col):
            if(not i>j):
                continue
            if(not mat[i][j]==0):
                isTri = False
    return isTri