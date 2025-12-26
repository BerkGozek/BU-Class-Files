"""
You are provided with daily temperature data for a city over a month. Write a Python program that performs the following tasks:

1. Continuously prompt the user to enter daily temperatures (integer values). The user can stop entering data by typing "done".
2. Store all entered temperatures in a list.
3. Categorize each temperature as "Cold" (below 50°F), "Moderate" (50°F to 80°F inclusive), or "Hot" (above 80°F) using if/elif/else statements.
4. Count the number of days in each category using a dictionary.
5. Define and use a function to calculate the average temperature using NumPy.
6. Plot a bar chart using Matplotlib that shows the number of days in each temperature category.

Ensure your program uses the following concepts: if/elif/else, lists, while loops, boolean operators, for loops, nested loops, functions, dictionaries, NumPy, and Matplotlib.
"""

import numpy as np
import matplotlib.pyplot as plt

temps : list[int] = []
inp : str = input("Enter daily temperatures. Type\"done\" if finished. ")
while(inp!="done"):
    try:
        temps.append(int(inp))
    except:
        print("Invalid Value.")
    inp : str = input("Enter daily temperatures. Type\"done\" if finished. ")
catTemps : dict = {"Cold":0,"Moderate":0,"Hot":0}
for i in temps:
    if(i<50):
        catTemps["Cold"]+=1
    elif(50<=i and i<=80):
        catTemps["Moderate"]+=1
    else:
        catTemps["Hot"]+=1
arrTemps : np.array = np.array(list(catTemps.values()))
arrCats : np.array = np.array(list(catTemps.keys()))

def calcAvg(d : list[int])->float:
    return np.average(d)



plt.bar(arrCats,arrTemps)
plt.title("Temperatures")
plt.xlabel("Category")
plt.ylabel("Days")
plt.show()
a="hello"
