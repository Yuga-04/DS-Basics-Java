
Policemen - Thieves 2
Problem
Submissions
Leaderboard
Discussions
an array of size N. Which has the following specifications: Each element in the array contains either a policeman or a thief. Each policeman can catch only one thief. A policeman cannot catch a thief who is more than K units away from him. We need to find the maximum number of thieves that can be caught.

image

Input Format

6
P
T
P
T
T
P
3

Output Format

Maximum thieves caught: 3

Sample Input 0

6
P
T
P
T
T
P
3
Sample Output 0

Maximum thieves caught: 3
Contest ends in a month
Submissions: 13
Max Score: 10
Difficulty: Medium
Rate This Challenge:

    
More
 

import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int count=0;
        int n=sc.nextInt();
        char arr[]=new char[n];
        for(int i=0;i<n;i++)
                arr[i]=sc.next().charAt(0);
        int k=sc.nextInt();
        for(int i=0;i<n;i++){
            if(arr[i]=='P'){
                for(int j=1;j<=k;j++){
                    if(i+j<n && arr[i+j]=='T'){
                        count++;
                        arr[i+j]='C';
                        break;
                }
                }
            }
            else if(arr[i]=='T'){
                for(int j=1;j<=k;j++){
                    if(i+j<n && arr[i+j]=='P'){
                        count++;
                        arr[i+j]='C';
                        break;
                    }
                }
            }
        }
        System.out.print("Maximum thieves caught: "+count);
    }
}




import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int count=0,p=0,t=0,m=0,l=0;
        int n=sc.nextInt();
        char arr[]=new char[n];
        List<Integer> pr=new ArrayList<>();
        List<Integer> tr=new ArrayList<>();
        for(int i=0;i<n;i++){
                arr[i]=sc.next().charAt(0);
                if(arr[i]=='P')
                    pr.add(i);
                else
                    tr.add(i);
        }
        int k=sc.nextInt();
        
        
        int i=0,j=0;
        while(i<pr.size() && j< tr.size()){
            int prr=pr.get(i);
            int trr=tr.get(j);
            if(Math.abs(prr-trr)<=k){
                count++;
                i++;
                j++;
            }
            else if(prr<trr){
                i++;
            }
            else{
                j++;
            }
        }
        System.out.print("Maximum thieves caught: "+count);
    }
}
Line: 20 Col: 33
Run Code Submit CodeUpload Code as File 
Test against custom input
Testcase 0
Congratulations, you passed the sample test case.

Click the Submit Code button to run your code against all the test cases.

Input (stdin)

6
P
T
P
T
T
P
3
Your Output (stdout)

Maximum thieves caught: 3
Expected Output

Maximum thieves caught: 3
