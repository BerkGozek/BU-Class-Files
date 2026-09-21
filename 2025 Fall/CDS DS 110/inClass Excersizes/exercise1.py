

def wordprob(word:str,worddict:dict):
    denom=0#denominator
    for i in worddict:
        denom +=worddict[i]
    return worddict.get(word,0)/denom

dictin = {"hello":2,"guy":4}

print(wordprob("hello",dictin))
