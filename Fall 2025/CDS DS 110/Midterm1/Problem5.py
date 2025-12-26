"""

1. Given a lengthy list of destinations on a rock concert tour, we'd like a dictionary that can
easily look up the next destination after a particular city.

Write a function next_dest_lookup() that takes a list of strings L as an argument,
and returns a dictionary where the item that was at position i in list L can be looked up to get
the item at position i+1. 

Looking up the last item in the list should produce the result 'END'.

For example, next_dest_lookup(['Boston', 'New York', 'DC']) should produce
the dictionary {'Boston': 'New York', 'New York': 'DC', 'DC': 'END'}.

You can assume the input is a list containing at least one string, and that all its elements
are strings.

"""

def next_dest_lookup(L : list[str])->dict[str,str]:
    route : dict[str,str] = {}

    for i in range(len(L)):
        try:
            route[L[i]] = L[i+1]
        except:
            route[L[i]] = "END"
    return route