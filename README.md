# Minimum-number-to-make-median-X

Given an unsorted array A[] of integers and size N, and an element X, you need to find the Minimum Number of Elements required to be added to this array so the new median of array becomes X.
Median of array is middle element of array in its sorted form. For odd number of elements N it is the element at position (N-1)/2. For even number of elements N, it is (A[N/2] + A[(N/2) - 1])/2.

Input
The first line contains number of testcases T. Every testcase consists of 2 lines, first line contains N - no of element of arrays and X, and second line contains Array elements in unsorted manner.

Constraints:
1 <= T <= 100
1 <= N <= 2*10^5
1 <= X <= 10^6
1 <= A[i] <= 10^6

Sum of N for every test case is less than or equal to 2*10^5
Output
You need to find total number of elements to be added to array so that the new median becomes equal to X.

Sample Input: 
2
6 30
10 20 30 100 150 200
5 50
10 20 30 100 150

Sample Output: 
1
1

Explanation: 
Testcase 1: Only 1 element before 30 is required to be added to the array, to make median of array 30.
Testcase 2: Only 1 element between 30 and 100, i. e number 70 is required to be added to make median 50.
