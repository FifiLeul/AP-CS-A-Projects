/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccounts;

/**
 *
 * @author mercyougothis
 */
public class Tester 
{
    public static void main(String[] args) {
		
		//Testing savings account: should get $1,104 after 5 years
		Savings savings = new Savings(1000, 2, 12);
                System.out.println("-----------------------------------------");
		for(int i = 0; i < 5; i++)
		{
			savings.nextYear();
		}
		
		System.out.println("interest earned: " + savings.getIntEarned());
		System.out.println("year: " + savings.getYear());
		System.out.println("rate: " + savings.getRate());
		System.out.println(savings.getInterestPlan());
		System.out.println(savings.toString());
		
		
		
		Credit credit = new Credit(800, 14.5);
		System.out.println("-----------------------------------------");
		credit.withdraw(80);
		System.out.println("Principal: " + credit.getBalance());
		credit.setNumBillingDays(14);
		credit.nextMonth();
		System.out.println("Balance after one month: " + credit.getBalance());
		credit.nextMonths(5);
		System.out.println("Balance after 5 months: " + credit.getBalance());
		System.out.println(credit.toString());
		
		
		
		//testing checkings account
		System.out.println("-----------------------------------------");
		Checking checking = new Checking(900.23);
		System.out.println("Principal: " + checking.getBalance());
		checking.deposit(200.689);
		System.out.println("Balance after deposit: " + checking.getBalance());
		checking.withdraw(900);
		System.out.println("Balance after withdrawal: " + checking.getBalance());
		System.out.println(checking.toString());


	}

}
