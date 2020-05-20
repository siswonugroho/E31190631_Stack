
package com.sovana.stack;

//Created by Sovana S

import java.util.Stack;


public class ProgramStack {
    private String[] buku = new String[5];
    
    
    public void stackPush(Stack<String> stack){
        stack.push(buku[buku.length]);
    }
}
