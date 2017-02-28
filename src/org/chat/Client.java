package org.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket soc;
		BufferedReader userInput = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Client Started");
		soc = new Socket("localhost", 9849);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				soc.getInputStream()));

		PrintWriter out = new PrintWriter(soc.getOutputStream(), true);


		int option = 0;
		int num1 = 0;
		int num2 = 0;
		do{
			System.out.println("Choose options ");
			System.out.println("1. Add ");
			System.out.println("2. Sub ");
			System.out.println("3. Mul ");
			System.out.println("4. Div ");
			System.out.println("5. Exit");
			System.out.println("Enter an option: ");
			option = Integer.parseInt(userInput.readLine());
			
			if(option!=5){
			System.out.println("Enter first number ");
			num1 = Integer.parseInt(userInput.readLine());
			
			System.out.println("Enter second number ");
			num2 = Integer.parseInt(userInput.readLine());
			out.println(option +":"+num1+":"+num2);
			}
			else{
				out.println(option+":0:0");
				break;
			}
			
			
			
			String answer = in.readLine();
			System.out.println("Server says "+ answer);
			
		}while(true);
		soc.close();
		System.out.println("Client Terminated");
	}

}
