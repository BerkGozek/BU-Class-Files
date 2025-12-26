"""

Write a Python program that simulates rolling a six-sided die until a 6 is obtained. Perform the following tasks:

1. **Function Definition:** Create a function `roll_die()` that simulates rolling a die by returning a random integer between 1 and 6.

2. **Simulation:** Use a `while` loop within a function `simulate_rolls()` to roll the die repeatedly until a 6 appears. Record the number of rolls it took to get a 6. Repeat this simulation 100 times and store the results in a list.

3. **Categorization:** After collecting the results, categorize each simulation based on the number of rolls:
   - `'1-2 rolls'`
   - `'3-4 rolls'`
   - `'5-6 rolls'`
   - `'7+ rolls'`

4. **Counting:** Use a dictionary to count how many simulations fall into each category.

5. **Visualization:** Plot a bar chart using `matplotlib` to display the number of simulations in each category.

**

"""

from random import *
from matplotlib import pyplot as plt
import numpy as np

def roll_die()->int:
    return randint(1,6)


def simulate_rolls()->int:
    newRoll : int = roll_die()
    i : int = 0
    while(newRoll != 6):
        i+=1
        newRoll = roll_die()
    return i

tests : list[int] = []

for i in range(100):
    tests.append(simulate_rolls())

orgTests : dict[str,int] = {"1-2 rolls":0,"3-4 rolls":0,"3-4 rolls":0,"5-6 rolls":0,"7+ rolls":0}

for i in tests:
    if(i<=2):
        orgTests["1-2 rolls"]+=1
    elif(i<=4):
        orgTests["3-4 rolls"]+=1
    elif(i<=6):
        orgTests["5-6 rolls"]+=1
    else:
        orgTests["7+ rolls"]+=1

countArr : np.array = np.array(list(orgTests.values()))
categArr : np.array = np.array(list(orgTests.keys()))

plt.bar(categArr,countArr)
plt.title("d6 roll simulation")
plt.xlabel("roll categories")
plt.ylabel("number of rolls")

plt.show()