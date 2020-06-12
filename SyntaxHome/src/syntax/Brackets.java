package syntax;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Brackets {
 	Letter input;
	char next;
	public Brackets(){ }

	public int depthSquare(String word) {
		int res = 0;
		int prevRes = 0;
		if(!analys(word)){
			return -1;
		}
		Stack<Character> stack = new Stack<Character>();
		for(char c: word.toCharArray()){
			if(c=='['){
				stack.push('[');
			}else if(c==']'){
				stack.pop();
				res++;
				if(stack.size()==0){
					if(res>prevRes){
						prevRes = res;
					}
					res = 0;
				}
			}
		}
		return prevRes;
	}
	public int depthRound(String word) {
		int res = 0;
		int prevRes = 0;
		if(!analys(word)){
			return -1;
		}

		Stack<Character> stack = new Stack<Character>();
		for(char c: word.toCharArray()){
			if(c=='('){
				stack.push('(');
			}else if(c==')'){
				stack.pop();
				res++;
				if(stack.size()==0){
					if(res>prevRes){
						prevRes = res;
					}
					res = 0;
				}
			}
		}
		return prevRes;
	}

	public boolean analys(String str){
		Stack<Character> stack = new Stack<Character>();
		for(char c:str.toCharArray()){
			if(c=='{'||c=='['||c=='('){
				stack.push(c);
			}else if(c=='}'){
				if(stack.pop().charValue() != '{'){
					return false;
				}
			}else if(c==')'){
				if(stack.pop().charValue() != '('){
					return false;
				}
			}else if(c==']'){
				if(stack.pop().charValue() != '['){
					return false;
				}
			}else {
				return false;
			}
		}
		if(!stack.empty()){
			return false;
		}
		return true;
	}
	// .... methods
	// ......
	// ......
}
