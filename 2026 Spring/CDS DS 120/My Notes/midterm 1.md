1. Use a truth table to determine whether the following two statements are logically equivalent: $(P\wedge Q)\rightarrow R$ and $P\rightarrow (Q\rightarrow R)$

| $P$ | $Q$ | $R$ | $P\wedge Q$ | $Q\rightarrow R$ | $(P\wedge Q)\rightarrow R$ | $P\rightarrow (Q\rightarrow R)$ |
| --- | --- | --- | ----------- | ---------------- | -------------------------- | ------------------------------- |
| T   | T   | T   | T           | T                | T                          | T                               |
| T   | T   | F   | T           | F                | F                          | F                               |
| T   | F   | T   | F           | T                | T                          | T                               |
| T   | F   | F   | F           | T                | T                          | T                               |
| F   | T   | T   | F           | T                | T                          | T                               |
| F   | T   | F   | F           | F                | T                          | T                               |
| F   | F   | T   | F           | T                | T                          | T                               |
| F   | F   | F   | F           | T                | T                          | T                               |
2. Negate the following: $(P\rightarrow Q)\wedge (Q \rightarrow R)$
      $(P\wedge\neg Q)\vee(Q\wedge\neg R)$
3. Reduce the following augmented matrix RREF and say if the solution set is unique/infinite or if there are no solutions:
$$\begin{matrix}\begin{bmatrix}\begin{array}{ccc|c}
1&2&-1&3\\
2&4&-2&6\\
3&6&-4&9\\
\end{array}\end{bmatrix}\\
\text{Augmented Form}
\end{matrix}$$
$$
\begin{bmatrix}\begin{array}{ccc|c}
1&2&-1&3\\
2&4&-2&6\\
3&6&-4&9\\
\end{array}\end{bmatrix}\rightarrow
\begin{bmatrix}\begin{array}{ccc|c}
1&2&-1&3\\
0&0&0&0\\
3&6&-4&9\\
\end{array}\end{bmatrix}\rightarrow
\begin{bmatrix}\begin{array}{ccc|c}
1&2&-1&3\\
0&0&0&0\\
0&0&0&0\\
\end{array}\end{bmatrix}
$$
This matrix has infinitely many solutions solutions
4. A fruit seller sells apples for 2$ each and oranges for 3$ each. One day, she sells 20 fruits for a total of 52$. How many apples and how many oranges did she sell? **Solve using Gauss Jordan elimination and show proper steps**
	- 20 fruits sold = 52
	- 2a+3o= 52
	- a+o=20

$$\begin{bmatrix}\begin{array}{cc|c}
2&3&52\\
1&1&20\\
\end{array}\end{bmatrix}\rightarrow
\begin{bmatrix}\begin{array}{cc|c}
1&1&20\\
2&3&52\\
\end{array}\end{bmatrix}\rightarrow
\begin{bmatrix}\begin{array}{cc|c}
1&1&20\\
0&1&12\\
\end{array}\end{bmatrix}\rightarrow
\begin{bmatrix}\begin{array}{cc|c}
1&0&8\\
0&1&12\\
\end{array}\end{bmatrix}
$$
8 apples and 12 oranges sold.

5. Prove using mathematical induction that for all $n \geq 1$: 
   $F(n)=\frac{1}{1*2}+\frac{1}{2*3}+\frac{1}{3*4}+...+\frac{1}{n*(n+1)}=\frac{n}{n+1}$
	1. Base Case:
		1. F(1) = 1/2=1/1+1=1/2 : True
	2. Assume F(k) is true
		1. F(k) = k/k+1 is true (hypothesis)
	3. Prove F(k+1) $$
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
6. Given two vectors, for what value of x will the two vectors be orthogonal/perpendicular:$$\begin{aligned}
\vec{a}=(x,2)\\
\vec{b}=(3,1)
\end{aligned}$$
   $\vec{a}=(x,2)*\vec{b}=(3,1)=3x+2$ 
   For $\vec{a}$ and $\vec{b}$ to be orthogonal, the dot product of $\vec{a}$ and $\vec{b}$ has to be 0, therefore x has to be -2/3.
7. If A is a $2*3$ matrix and B is a $3*4$, what is the order of AB? What about BA?
	- order of AB: 2 by 4
	- order of BA: impossible, $2 \neq 4$
8. Let P be "$x^2=4$" and Q be "$x=2$"
	- Is P necessary or sufficient for Q?
		- P is sufficient for Q
	- Write your answer as an implies statement.
		- $P\rightarrow Q$
9. Given: "For every real number x, if $x>1$, then $x^2>1$".
	- Write the above statement using mathematical notation.
		- $\forall x \in \mathbb{R},x>1\rightarrow x^2>1$
	- Write the converse, Inverse and contrapositive of the above statement. Use mathematical notations.
		- converse:        $\forall x \in \mathbb{R}, x^2>1 \rightarrow x>1$ 
		- inverse:          $\forall x \in \mathbb{R}, x\leq 1 \rightarrow x^2\leq 1$
		- contrapositive:  $\forall x \in \mathbb{R}, x^2\leq1 \rightarrow x\leq1$




