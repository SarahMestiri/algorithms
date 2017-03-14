package cracking.code.exercices;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Exercice ex = new Exercice();
		//System.out.println(ex.removeSpaces("Hi, how are you?"));
		//int[] A = {30,20,10};
		//System.out.println("result: "+ ex.reverseNotSpecialChar("a!!!b.c.d,e'f,ghi").equals("i!!!h.g.f,e'd,cba"));
		//int[] arr1 = {4,5,3,5,3,2,5,1,5};
		System.out.println(ex.reverseWords("we test coders"));
	/*	 int[] A = {10, 15, 25};
		    int[] B = {1, 5, 20, 30};

		    Stack<Integer> st = new Stack<>();

		    for (int i = 0; i < A.length; i++) {
		    	System.out.println("Main again");
		        st.push(A[i]);
		        ex.generateArrays(A, B, i, 0, st, false);
		        st.clear();
		    }*/

	}

}
