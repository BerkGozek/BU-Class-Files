1. Let **P:** “The training dataset has more than 10,000 rows.”
		**Q:** “The model training takes more than 5 minutes.”
	1. If The training dataset has more than 10,000 rows, then the model training takes more than 5 minutes.
	2. No, the conditional is true, as this is a false positive. 
2. Let the original statement be "*If a feature is measured in large units, then feature scaling is necessary.*"
	1. **Converse:** If feature scaling is necessary, then a feature is measured in large units
	2. **Inverse:** If a feature isn't measured in large units, then feature scaling isn't necessary.
	3. **Contrapositive:** If feature scaling isn't necessary, then a feature isn't measured in large units.
3. Let **P:** “The data pipeline fails”
		**Q:** “An alert is triggered”
	Which of the following is equivalent to “If the data pipeline fails then an alert is triggered”. Explain your choice.
	- $\text{If the data pipeline fails then an alert is triggered: }P\rightarrow Q$
	- The correct answer is "If no alert is triggered then the pipeline did not fail"**(C)**

| $P$ | $Q$ | $P\rightarrow Q$ | $Q\rightarrow P$ (A) | $\neg P\rightarrow \neg Q$ (B) | $\neg Q\rightarrow \neg P$ (C) |
| --- | --- | ---------------- | -------------------- | ------------------------------ | ------------------------------ |
| T   | F   | F                | T                    | T                              | F                              |
| T   | T   | T                | T                    | T                              | T                              |
| F   | F   | T                | T                    | T                              | T                              |
| F   | T   | T                | F                    | F                              | T                              |
4. Prove the following using Truth Tables$(P\wedge Q)\rightarrow R \leftrightarrow P\rightarrow(Q\rightarrow R)$ :
	- Truth Table below

| $P$ | $Q$ | $R$ | $P\wedge Q$ | $(P\wedge Q)\rightarrow R$ | $Q\rightarrow R$ | $P\rightarrow(Q\rightarrow R)$ |
| --- | --- | --- | ----------- | -------------------------- | ---------------- | ------------------------------ |
| T   | T   | T   | T           | T                          | T                | T                              |
| T   | T   | F   | T           | F                          | F                | F                              |
| T   | F   | T   | F           | T                          | T                | T                              |
| T   | F   | F   | F           | T                          | T                | T                              |
| F   | T   | T   | F           | T                          | T                | T                              |
| F   | T   | F   | F           | T                          | F                | T                              |
| F   | F   | T   | F           | T                          | T                | T                              |
| F   | F   | F   | F           | T                          | T                | T                              |
5. Prove the claim ($(P\wedge Q)\rightarrow R \leftrightarrow P\rightarrow(Q\rightarrow R)$ ) in question 4 using De Morgan’s Law.
	- $(P\wedge Q)\rightarrow R \leftrightarrow P\rightarrow(Q\rightarrow R)$
	- $\neg(P\wedge Q)\vee R \leftrightarrow \neg P\vee(\neg Q\vee R)$
	- $(\neg P\vee \neg Q)\vee R \leftrightarrow \neg P\vee(\neg Q\vee R)$
	- $(\neg R\vee \neg Q)\vee P \leftrightarrow \neg P\vee(\neg Q\vee R)$
	- $P \vee(\neg R\vee \neg Q)\leftrightarrow \neg P\vee(\neg Q\vee R)$
	- 
6. Consider the following statement “*Removing outliers is necessary for using linear regression on this dataset*”
	Let,
		**P:** “Outliers are removed”
		**Q:** “Linear regression is used”
	Translate the above into a conditional statement.
	- $Q\rightarrow P$
7. Prove the following using semantics:
	- $P \wedge (Q \vee R) \leftrightarrow (P\wedge Q) \vee (P\wedge R)$
		- Left Side
			- Case 1: $P = True$
				- LHS: $T\wedge(Q\vee R)=(Q\vee R)$
				- RHS: $(T\wedge Q) \vee (T\wedge R)=Q\vee R$
				- LHS = RHS
			- Case 2: $(Q \vee R)=True$
				- LHS: $P\wedge T = P$
				- RHS:
					- Case 2.1: $Q=True$
						- $(P\wedge T) \vee (P\wedge R) = P\vee(unknown) = P$
					- Case 2.2: $R=True$
						- $(P\wedge Q) \vee (P\wedge T) = (unknown)\vee P = P$
				- LHS = RHS
		- Right Side
			- Case 1: $(P\wedge Q)=True$
				- $P=T$
				- $Q=T$
				- LHS: 
					- $T\wedge T=T$
				- RHS
					- $(T)\vee(T\wedge R) = T$
				- LHS=RHS
			- Case 2: $(P\wedge R)=True$
				- $P=T$
				- $R=T$
				- LHS: 
					- $T\wedge T=T$
				- RHS
					- $(T)\vee(T\wedge Q) = T$
				- LHS=RHS
	- $P \vee (Q \wedge R) \leftrightarrow (P \vee Q) \wedge (P \vee R)$
		- Left Side
			- Case 1 : $P=True$
				- LHS:
					- $T \vee (Q \wedge R)=T$
				- RHS:
					- $(T \vee Q) \wedge (T \vee R)=T\wedge T=T$ 
				- LHS=RHS
			- Case 2 : $(Q\wedge R)$
				- $Q=T$
				- $R=T$
				- LHS
					- $P\vee T=T$
				- RHS
					- $(P \vee T) \wedge (P \vee T) = T\wedge T = T$
				- LHS=RHS
		- Right Side
			- Case 1 : $P=True$
				- LHS:
					- $T \vee (Q \wedge R)=T$
				- RHS:
					- $(T \vee Q) \wedge (T \vee R)=T\wedge T=T$
				- LHS=RHS
			- Case 2 : $(Q \wedge R)=True$
				- $Q=T$
				- $R=T$
				- LHS:
					- $P \vee (T)=T$
				- RHS:
					-  $(P \vee T) \wedge (P \vee T) = T\wedge T = T$
				- LHS=RHS