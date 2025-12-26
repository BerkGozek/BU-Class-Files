"""

Write a function calculate_events(months, events) that takes a list of months and
a dictionary events containing month names as keys and values equal to the number of
events for that month. 

Your function should return a dictionary with keys, “Attend” and “Ignore”. 

The value for the “Attend” key should be equal to the sum of the number of events 
for all months in the months list. 

The value for the “Ignore” key should be the sum of the number of events for all months 
that are NOT in the months list. 

You may assume that every month is a key in the events dictionary.

For example, given the list months=[‘March’, ‘April’] and
events={ 'January': 1, 'February': 1, 'March': 4, 'April': 3,
'May': 11, 'June': 1, 'July': 1, 'August': 1,
'September': 1, 'October': 1, 'November': 1, 'December': 1}

The function should return the dictionary {‘Attend’: 7, “Ignore’: 9 }.

"""

def calculate_events(months : list[str], events : dict[str,int]) -> dict[str,int]:
    program : dict[str,int] = {"Attend":0,"Ignore":0}
    
    for key in events:
        if key in months:
            program["Attend"]+=events[key]
        else:
            program["Ignore"]+=events[key]

    return program