package syntax;

import java.util.Stack;

public class Main{
    public static void main(String[] args){
        Expr expr = new Expr();
        System.out.println("Res:"+expr.evalLeft("5*3+4*7"));
    }
}