1. Use PMI to prove the following: **10 points**
	For all integers 𝑛 ≥ 0: $F(n)=1 + 2^1 + 2^2 + ⋯ + 2^𝑛 = 2^{𝑛+1}−1$
	
	1. Base Case:
		$F(1) = 1+2^1 = 2^{1+1}-1=3:True$
	2. Assume $F(k)$ is True:
		$F(k)=1+2^2+...+2^k=2^{k+1}-1:True$ (assumption)
	3. Prove F(k+1) is True:
		$F(k+1)=1+2^2+...+2^{k+1}=2^{(k+1)+1}-1$
		$F(k+1)=1+2^2+...+2^k+2^{k+1}=2^{(k+1)+1}-1$
		$F(k+1)=F(k)+2^{k+1}=2^{(k+1)+1}-1$
		$F(k+1)=2^{k+1}-1+2^{k+1}=2^{(k+1)+1}-1$
		$F(k+1)=2^{k+1}-1+2^{k+1}=2^{k+2}-1$
		$F(k+1)=2*2^{k+1}-1=2^{k+2}-1$
		$F(k+1)=2^{k+1+1}-1=2^{k+2}-1$
		$F(k+1)=2^{k+2}-1=2^{k+2}-1:True$
		By PMI, F(n) is true
2. Use PMI to prove the following: **10 points**
	For all integers 𝑛 ≥ 0: P(n) :$3^𝑛−1 \text{ is divisible by }2$
	1. Base Case:
			$P(1)=(3^1-1)/2= 2/2=1$
3. 
4. 
5. Reduce the following matrix to RREF: **3 points** $$\begin {bmatrix} 1,1,0\\1,2,1\\2,3,1 \end{bmatrix}$$$$\begin {bmatrix} 
1,1,0\\
1,2,1\\
2,3,1 
\end{bmatrix}
\rightarrow
\begin {bmatrix} 
1,1,0\\
0,1,1\\
2,3,1 
\end{bmatrix}
\rightarrow
\begin {bmatrix} 
1,1,0\\
0,1,1\\
0,1,1 
\end{bmatrix}
\rightarrow
\begin {bmatrix} 
1,1,0\\
0,1,1\\
0,0,0 
\end{bmatrix}
$$
6. Is the following linear system consistent with unique solutions/inconsistent or dependent? Use Gauss Jordan elimination to determine your answer. **5 points**

$$\begin{aligned} 
  𝑥 − 2𝑦 +  𝑧 = 1\\
 2𝑥 − 4𝑦 + 2𝑧 = 2\\
 −𝑥 + 2𝑦 −  𝑧 = 1\\
\end{aligned}$$

$$
\begin{bmatrix}
\begin{array}{ccc|c}
1,&-2,&1&1\\
2,&-4,&2&2\\
-1,&2,&-1&1
\end{array}
\end{bmatrix}
\rightarrow
\begin{bmatrix}
\begin{array}{ccc|c}
1,&-2,&1&1\\
0,&0,&0&0\\
-1,&2,&-1&1
\end{array}
\end{bmatrix}
\rightarrow
\text{infinite solutions(Dependent)}
$$


