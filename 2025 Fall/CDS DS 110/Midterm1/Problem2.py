



"""

Write a Python program that categorizes a list of movies by their genre and visualizes the results. 
    The program should perform the following tasks:

1. **Function `categorize_movies(movies)`**:
   - Takes a list of tuples `movies`, where each tuple contains a movie title and its genre (e.g., `("Inception", "Action")`).
   - Returns a dictionary where the keys are genres and the values are lists of movie titles in that genre.
   - Use `for` loops and `if/elif/else` statements within the function.

2. **Main Program**:
   - Create a list of 10 sample movies with their genres.
   - Use a `while` loop to process each movie in the list and categorize them using the `categorize_movies` function.
   
3. **Data Analysis and Visualization**:
   - Use `numpy` to compute the number of movies in each genre.
   - Use `matplotlib` to plot a pie chart showing the distribution of movie genres.

**Requirements**:
- Utilize the following Python concepts: `if/elif/else`, lists, `while` loops, boolean operators, `for` loops, nested loops, functions, dictionaries, sets, `matplotlib`, and `numpy`.
- Ensure the solution is straightforward for exam practice with limited time.
"""

import numpy as np
import matplotlib.pyplot as plt

def categorize_movies(movies : list[tuple[str,str]])->dict:
    retdict : dict[str , list[str]] = {}
    for mov,gen in movies:
        if(gen not in list(retdict.keys())):
            retdict[gen] =[mov]
        else:
            retdict[gen].append(mov)
    
    return retdict

sampleList : list[tuple[str,str]] = [("Shrek", "Animation"),("Shrek 2", "Animation"),("Inception","Action"),("Fast and Furious","Action"),("Harold and Kumar go to White Castle","Comedy")]

organized = categorize_movies(sampleList)

print(organized)

# Bad question