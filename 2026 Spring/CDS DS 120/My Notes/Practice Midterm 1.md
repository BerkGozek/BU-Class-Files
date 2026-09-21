1. Let
   P: “The model accuracy is greater than 90%”
   Q: “The F-1 score is greater than 0.8”
	- Write $P\wedge Q$ in words
		- The model accuracy is greater than 90% and the F-1 score is greater than 0.8
	- Write $P\vee Q$ in words
		- The model accuracy is greater than 90% or the F-1 score is greater than 0.8
	- Write $\neg P$ 
		- The model accuracy is less than or equal to 90%
	- Write $\neg(P\wedge Q)$
		- The model accuracy is less than or equal to 90% or The F-1 score is less than or equal to 0.8.
2. Let:
	- **A** be the set of all features
	- 𝑃(𝑥): “Feature 𝑥 is normalized.”
	- 𝑄(𝑥): “Feature 𝑥 has no missing values.”
   Statement: $\forall x \in A. (P(x)\wedge Q(x))$
	- Write in words.
		- All the features are normalized and has no missing values.
	- Negate it and write it in words.
		- $\exists x \in A.(\neg P(x)\vee \neg Q(x))$
			- There exists a feature than isn't normalized or has missing values.
3. Let:
	- 𝑃: “A person can legally drive.”
	- 𝑄: “The person has a valid driver’s license.”
   Suppose: Having a valid license is necessary for driving legally.
	- Write the implication symbolically.
		- $P\rightarrow Q$
4. Negate $\neg Q\rightarrow P$
	- $\neg Q \wedge \neg P$
5. Let P be “A triangle is equilateral” and Q be “ A triangle is isosceles”
	- Is P necessary or sufficient for Q?
		- P is sufficient for Q
	- Write your answer as an implies statement
		- $P\rightarrow Q$
6. Use truth table to determine whether the following two statements are logically equivalent: $(P \wedge Q) \rightarrow R$ and $P\rightarrow(Q\rightarrow R)$

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
7. Which of the following matrices are in RREF(why/why not)
   $\begin {bmatrix}1&3&5\\2&3&0\\1&0&0\end{bmatrix}$, $\begin {bmatrix}1&0&0&0\\0&1&2&0\\0&0&0&1\end{bmatrix}$, $\begin {bmatrix}2&0&0\\0&2&0\\0&0&2\end{bmatrix}$,$\begin {bmatrix}1&0&2&3\\0&1&0&1\\0&1&2&0\end{bmatrix}$

- $\begin {bmatrix}1&3&5\\2&3&0\\1&0&0\end{bmatrix}$ isn't in RREF, pivots aren't 1

- $\begin {bmatrix}1&0&0&0\\0&1&2&0\\0&0&0&1\end{bmatrix}$ is in RREF because each row’s first nonzero entry is 1, the pivots move to the right as you go down, and every pivot column has zeros everywhere else.

- $\begin {bmatrix}2&0&0\\0&2&0\\0&0&2\end{bmatrix}$ isn't in RREF, pivots aren't 1

- $\begin {bmatrix}1&0&2&3\\0&1&0&1\\0&1&2&0\end{bmatrix}$ isn't in RREF because column 2 has a pivot in row 2
8. Use Gauss Jordan Elimination to solve the following system of equations. *(Show proper steps)*
$$
\begin{aligned}
x_1+5x_3=-4\\
x_1+4x_2+3x_3=-2\\
2x_1+7x_2+x_3=-2
\end{aligned}
$$
$$
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
1&4&3&-2\\
2&7&1&-2\\
\end{array}
\end{bmatrix}\\\text{Augmented Form}
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&4&-2&-2\\
2&7&1&-2\\
\end{array}
\end{bmatrix}\\R_2=R_2-R_1
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&2&-1&-1\\
2&7&1&-2\\
\end{array}
\end{bmatrix}\\R_2=R_2/2
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&2&-1&-1\\
0&7&-9&-10\\
\end{array}
\end{bmatrix}\\R_3=R_3-2R_1
\end{matrix}\rightarrow
$$

$$
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&2&-1&-1\\
0&1&-6&-7\\
\end{array}
\end{bmatrix}\\R_3=R_3-3R_2
\end{matrix}\rightarrow

\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&1&-6&-7\\
0&2&-1&-1\\
\end{array}
\end{bmatrix}\\R_3\leftrightarrow R_2
\end{matrix}\rightarrow

\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&1&-6&-7\\
0&0&11&13\\
\end{array}
\end{bmatrix}\\R_3 = R_3-2R_2
\end{matrix}\rightarrow

\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&1&-6&-7\\
0&0&1&1.18\\
\end{array}
\end{bmatrix}\\R_3 = R_3/11
\end{matrix}\rightarrow
$$

$$
\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&5&-4\\
0&1&0&0.08\\
0&0&1&1.18\\
\end{array}
\end{bmatrix}\\R_2 = R_2+6R_3
\end{matrix}\rightarrow

\begin{matrix}
\begin{bmatrix}
\begin{array}{ccc|c}
1&0&0&-9.9\\
0&1&0&0.08\\
0&0&1&1.18\\
\end{array}
\end{bmatrix}\\R_1 = R_1-5R_3
\end{matrix}\rightarrow

\begin{aligned}
x_1=-9.9\\
x_2=0.08\\
x_3=1.18\\
\end{aligned}
$$


9. Reduce the following augmented matrix to RREF and say if the solution set is unique/infinite or there are no solutions? *(Explain why/why not)*$$
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
2&4&-2&6\\
3&6&-3&9\\
\end{array}
\end{bmatrix}
$$


$$
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
2&4&-2&6\\
3&6&-3&9\\
\end{array}
\end{bmatrix}\rightarrow
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
0&0&2&0\\
3&6&-3&9\\
\end{array}
\end{bmatrix}\rightarrow
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
0&0&2&0\\
0&0&3&0\\
\end{array}
\end{bmatrix}\rightarrow
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
0&0&1&0\\
0&0&1&0\\
\end{array}
\end{bmatrix}\rightarrow
$$

$$
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&-2&3\\
0&0&1&0\\
0&0&0&0\\
\end{array}
\end{bmatrix}\rightarrow
\begin{bmatrix}
\begin{array}{ccc|c}
1&2&0&3\\
0&0&1&0\\
0&0&0&0\\
\end{array}
\end{bmatrix}$$
- There are infinite solutions to this solution set as $x_2$ has no pivot.
10. Prove using mathematical induction that for all $n \geq 1$: 
     $F(n)=\frac{1}{1*2}+\frac{1}{2*3}+\frac{1}{3*4}+...+\frac{1}{n*(n+1)}=\frac{n}{n+1}$
	1. Base Case:
		1. F(1) = 1/2=1/1+1=1/2 : True
	2. Assume F(k) is true
		1. F(k) = k/k+1 is true (hypothesis)
	3. Prove F(k+1) 
$$
	\begin{aligned}
	F(k+1)=\frac{1}{1*2}+\frac{1}{2*3}+\frac{1}{3*4}+...+\frac{1}{(k+1)*((k+1)+1)}=\frac{(k+1)}{(k+1)+1}\\
	F(k+1)=
	\frac{1}{1*2}+\frac{1}{2*3}+\frac{1}{3*4}+...
	+\frac{1}{k*(k+1)}+\frac{1}{(k+1)*((k+1)+1)}=
	\frac{(k+1)}{(k+1)+1}\\
	F(k+1)=
	F(k)+\frac{1}{(k+1)*((k+1)+1)}=
	\frac{(k+1)}{(k+1)+1}\\
	F(k+1)=
	\frac{k}{k+1}+\frac{1}{(k+1)*((k+1)+1)}=
	\frac{(k+1)}{(k+1)+1}\\
	F(k+1)=
	\frac{k*(k+1)+1)+1}{(k+1)*((k+1)+1)}=
	\frac{(k+1)}{(k+1)+1}\\
	F(k+1)=
	\frac{k*((k+1)+1)+1}{(k+1)}=
	(k+1)\\
	F(k+1)=
	k*((k+1)+1)+1=
	(k+1)^2\\
	F(k+1)=
	k^2+2k+1=
	k^2+2k+1\\	
	F(k+1)=
	1=
	1 : TRUE\\
	\end{aligned}
	$$
	4. By the rules of PMI, F(k+1) is true, therefore F(n) is true.
11. The sum of two numbers is 25. Their difference is 7. Find the numbers.***Solve using Gauss Jordan elimination and show proper steps***
$$
\begin{aligned}
x+y=25\\
x-y=7
\end{aligned}
$$

$$
\begin{matrix}
\begin{bmatrix}
\begin{array}{cc|c}
1&1&25\\
1&-1&7
\end{array}
\end{bmatrix}\\\text{Augmented Form}
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{cc|c}
1&1&25\\
0&-2&-18
\end{array}
\end{bmatrix}\\R_2=R_2-R_1
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{cc|c}
1&1&25\\
0&1&9
\end{array}
\end{bmatrix}\\R_2=R_2/-2
\end{matrix}\rightarrow
\begin{matrix}
\begin{bmatrix}
\begin{array}{cc|c}
1&0&16\\
0&1&9
\end{array}
\end{bmatrix}\\R_1=R_1-R_2
\end{matrix}\rightarrow
\begin{aligned}
x=16\\
y=9
\end{aligned}
$$
