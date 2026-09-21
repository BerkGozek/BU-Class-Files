1. Problem 1
	1. fill in the truth table

| $P$ | $Q$ | $\neg P$ | $\neg Q$ | $P\vee Q$ | $\neg P\vee\neg Q$ | $\neg Q\wedge \neg P$ | $P\rightarrow Q$ | $\neg P \rightarrow \neg Q$ |
| --- | --- | -------- | -------- | --------- | ------------------ | --------------------- | ---------------- | --------------------------- |
| T   | T   | F        | F        | T         | F                  | F                     | T                | T                           |
| T   | F   | F        | T        | T         | T                  | F                     | F                | T                           |
| F   | T   | T        | F        | T         | T                  | F                     | T                | F                           |
| F   | F   | T        | T        | F         | T                  | T                     | T                | T                           |
Table continued:

| $\neg Q \rightarrow P$ | $P\wedge Q$ | $P\wedge \neg Q$ | $P\vee \neg Q$ |
| ---------------------- | ----------- | ---------------- | -------------- |
| T                      | T           | F                | T              |
| F                      | F           | T                | T              |
| T                      | F           | F                | F              |
| F                      | F           | F                | T              |
1. Problem 1
	2. Identify if the following statements are true using the truth table above
		1. (p ∧q) ⇔¬(¬p ∨¬q)
			1. True
		2. ¬(p ⇒q) ⇔(p ∧¬q)
			1. True
		3. (p ⇒q) ⇔(¬p ∨q)
			1. False
2. Problem 2: Write the negation, converse, inverse, and contrapositive for each statement.
	1. Every polygon that is a square has four sides.
		1. Negation: Not every polygon that is a square does has four sides.
		2. Converse: Every polygon that has four sides is a square.
		3. Inverse: Every polygon that isn't a square doesn't have four sides.
		4. Contrapositive:Every polygon that doesn't have four sides isn't a square.
	2. ∀x ∈R. (x > 2 ⇒ x2 > 4)
		1. Negation: $\exists x \in \mathbb{R}.(x>2\wedge x^2 \leq 4)$
		2. Converse:$\forall x \in \mathbb{R}. (x^2>4\rightarrow x>2)$
		3. Inverse:  $\forall x \in \mathbb{R}. (x\leq2\rightarrow x^2\leq4)$
		4. Contrapositive:$\forall x \in \mathbb{R}. (x^2\leq4\rightarrow x\leq2)$
3. Problem 3:Define perfect squares using Biconditional statement
	1. $n \text{ is a perfect square } \iff \exists k \in \mathbb{Z} \text{ such that } n = k^2$
4. Sum of Products of Consecutive Natural Numbers. Let P(n) be the statement:$P(n) = 1 ×2 + 2 ×3 +···+ n(n + 1) = \frac{1}{3}n(n + 1)(n + 2)$ 
	Use the Principle of Mathematical Induction to prove that P (n) is true for all natural numbers n ≥1 by completing the steps below.

	1. Base Case:
		$P(1) = \frac{1}{3}1(2)(3)=2 : True$ 
	2. Assume P(k) is true:
		$P(k)=\frac{1}{3}k(k+1)(k+2) : True (Hypothetically)$
	3. Prove P(k+1):
		1. $P(k+1)= 1 ×2 + 2 ×3 +···+(k+1)(k+2) = \frac{1}{3}(k + 1)(k + 2)(k+3)$ 
		2. $1 ×2 + 2 ×3 +···+k(k+1)+(k+1)(k+2) = \frac{1}{3}(k + 1)(k + 2)(k+3)$ 
		3. $P(k)+(k+1)(k+2) = \frac{1}{3}(k + 1)(k + 2)(k+3)$ 
		4. $\frac{k(k+1)(k+2)}{3}+(k+1)(k+2) = \frac{(k + 1)(k + 2)(k+3)}{3}$ 
		5. $\frac{k(k+1)(k+2)+3(k+1)(k+2)}{3} = \frac{(k + 1)(k + 2)(k+3)}{3}$ 
		6. $k(k+1)(k+2)+3(k+1)(k+2) = (k + 1)(k + 2)(k+3)$ 
		7. $(k+3)(k+1)(k+2) = (k + 1)(k + 2)(k+3):True$
		8. By PMI, P(n) is true
		