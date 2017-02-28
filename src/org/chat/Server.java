package org.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket ss;
		Socket soc;
		BufferedReader in;
		PrintWriter out;
		System.out.println("Server Started");

		ss = new ServerSocket(9849);
		System.out.println("Waiting for client");
		soc = ss.accept();
		System.out.println("Connection Established");
		in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		out = new PrintWriter(soc.getOutputStream(), true);
		while(true){
			String str[] = in.readLine().split(":");
			int option = Integer.parseInt(str[0]);
			int num1 = Integer.parseInt(str[1]);
			int num2 = Integer.parseInt(str[2]);
			String result = "";
			boolean flag = false;

			switch(option){
			case 1: result="Addition is"+ (num1 + num2); break;
			case 2: result="Subtraction is"+ (num1 - num2); break;
			case 3: result="Product is"+ (num1 * num2); break;
			case 4: result="Division is"+ (num1 / num2); break;
			case 5: flag = true;break;
			}
			if(flag ==true){
				break;
			}
			out.println(result);
			
		}
		System.out.println("Server Terminated");
	}

}
