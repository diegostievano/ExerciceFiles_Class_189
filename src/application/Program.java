package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		
		List<Product> productList = new ArrayList<>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the file path: ");
		String sourcePath = input.nextLine();
		
		File arq = new File(sourcePath);
		
		new File(arq.getParent() + "\\out").mkdir();				
		
		/*MANIPULAÇÃO DE ARQUIVOS SEM TRY WITH RESOURCES
		FileReader fr = null;
		BufferedReader br = null;*/
	
		try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
			/*
			fr = new FileReader("C:\\Users\\Menino\\Desktop\\Udemy\\Eclipse\\ExerciceFiles_Class_189\\bin");
			br = new BufferedReader(fr);
			*/
			
			System.out.println(sourcePath);
			
			String line = br.readLine();
			
			while(line != null) {				
				String[] fields = line.split(",");				
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);				
				Product product = new Product(name, price, quantity);
				productList.add(product);
				line = br.readLine();
			}	
			
		}
		catch (IOException e){
			System.out.println("Reading file Error: " + e.getMessage());
		}		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arq.getParent() + "\\out\\summary.csv"))) {
			/*fr = new FileReader("C:\\Users\\Menino\\Desktop\\Udemy\\Eclipse\\ExerciceFiles_Class_189\\bin");
			br = new BufferedReader(fr);*/
			for(Product list : productList) {
				bw.write(list.toString());
				bw.newLine();
				System.out.println(list.toString());
				
			}
		}
		catch (IOException e){
			System.out.println("Writing file Error: " + e.getMessage());
		}
		
		input.close();
	}

}
