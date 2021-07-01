package com.project.buyandsell;

import com.project.buyandsell.product.Product;
import com.project.buyandsell.ledger.ShopLedger;
import java.util.Scanner;


public class Shop {
	
	static ShopLedger shopLedger = new ShopLedger("Business Name");
	
	public static void main(String[] args) {
		
		while(true){
			
            showMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();        
            
            switch( choice ){

                case 1:
                	caseAddProduct();
                    break;
                case 2:
                	caseDeleteProduct();
                    break;                   
                case 3:
                	caseBuyProduct();
                    break;
                case 4:
                	caseSellProduct();
                    break;
                    
                case 5:                
					shopLedger.showDetails();
                    break;          
                case 6:
                	caseGetBalance();                    
                    break;
                case 7:
                	System.exit(0);
                	break;
                default:
                    System.out.println("Please Enter Valid Input!");
            }   
        }
	}
	
	static void showMenu() {
		 System.out.println("\n====================================\n");
         System.out.println("1. Add a Product");
         System.out.println("2. Delete a Product");
         System.out.println("3. Buy a Product");
         System.out.println("4. Sell a Product");
         System.out.println("5. See List of Products");
         System.out.println("6. See Available Balance");
         System.out.println("7. Exit\n");
         System.out.print("Enter your Choice: ");
	}
	
	
	static void caseAddProduct() {
		
		Scanner scanner = new Scanner(System.in);
		double buyingPrice = 0, sellingPrice = 0;
        int quantity, id;
        String name;
        Product product;
        
		System.out.println("\n========== Adding Products =========");
        System.out.print("Enter Product Name: ");
        name = scanner.next();                   
        
        System.out.print("Enter Product quantity: ");
        quantity = scanner.nextInt();
             
        product = new Product(name, buyingPrice, sellingPrice, quantity);      
        shopLedger.addProduct(product);
	}
	
	
	static void caseDeleteProduct() {
		 System.out.println("========== Deleting Products =========");	
		 shopLedger.showDetails();	
         System.out.print("\nEnter Id to delete product: ");
         Scanner scanner = new Scanner(System.in);
         int id  = scanner.nextInt();
         shopLedger.deleteProduct(id);      
	}
	
	
	static void caseBuyProduct() {		
		System.out.println("========== Buying Products =========\n");
		Scanner scanner = new Scanner(System.in);
		shopLedger.showDetails();

        System.out.print("\nEnter Product id to Buy: ");
        int id = scanner.nextInt(), quantity;
        
        System.out.print("Enter Product Quantity: ");
        quantity = scanner.nextInt();
        shopLedger.buyProduct(id, quantity);
	}
	
	
	
	static void caseSellProduct() {		
		int numberOfProoducts = shopLedger.getTotalProducts();
		
    	if(numberOfProoducts > 0) {
    		System.out.println("============== Selling Products ==============\n\n");
    		shopLedger.showDetails();
			
			if(numberOfProoducts > 2) {
                System.out.print("\nEnter Id to Sell the product: ");
                Scanner scanner = new Scanner(System.in);
                int item  = scanner.nextInt();
                shopLedger.sellProduct(item);
			} else {
		    	System.out.println("You are not allowed to sell less or equal 2 products!!!");
		    }
    	}     
	}
	
	
	static void caseGetBalance() {
		System.out.println("Total Balance in Cash " + shopLedger.getBalance());
	}
}
