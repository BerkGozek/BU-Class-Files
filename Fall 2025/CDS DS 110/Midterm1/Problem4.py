"""


You are provided with a list of customer purchase amounts (in dollars). Write a Python function that processes this list to categorize each purchase as 'Small', 'Medium', or 'Large' based on the following criteria:

- `'Small'` if the purchase is less than \$20
- `'Medium'` if the purchase is between \$20 and \$100 (inclusive)
- `'Large'` if the purchase is over \$100

Your function should:

1. Iterate through the list of purchases using a `for` loop.
2. Use `if/elif/else` statements to categorize each purchase.
3. Keep track of the number of purchases in each category using a dictionary.
4. After processing all purchases, print the counts of each category.
5. Additionally, use a `while` loop to allow the user to input additional purchase amounts until they enter `'done'`. These additional purchases should also be categorized and counted.
6. Finally, use `numpy` to calculate the average purchase amount and use `matplotlib` to create a bar chart showing the counts of each category.

Use sets or dictionaries where appropriate.

*Note: Assume that all purchase amounts are positive numbers.*

---

**

"""

purchases : list[float] = [5.50,23.35,49.99,300.00,69.99]


def categorizePurchases(ls : list[float])->dict[str,int]:
    catPurch : dict[str,int] = {"Small":0,"Medium":0,"Large":0,}

    for i in purchases:
        if i<20:
            catPurch["Small"]+=1
        elif i<=100:
            catPurch["Medium"]+=1
        else:
            catPurch["Large"]+=1
    for i in catPurch.keys():
        print(f"There are {str(catPurch[i])} number of {i} purchases")
    return catPurch

orgGiven : dict[str,int] = categorizePurchases(purchases)

userPurch : list[float] = []
while True:
    inp = input("Enter purchase amount. Enter \"done\" to exit.")
    if(inp == "done"):
        break
    try:
        userPurch.append(int(inp))
    except:
        print("Invalid value. Please try again.")


