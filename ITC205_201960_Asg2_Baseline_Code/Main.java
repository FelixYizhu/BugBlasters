import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Main {
	
	private static Scanner input;//IN should be as input
	private static Library library;//LIB should be as library and library should be as Library
	private static String menu;//MENU should be as menu
	private static Calendar calendar;//CAL should be as calendar
	private static SimpleDateFormat simpleDateFormat;//SDF should be as simpleDateFormat
	
	
	private static String getMenu() {//Get_menu should be as getMenu
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nLibrary Main Menu\n\n")
		  .append("  M  : add member\n")
		  .append("  LM : list members\n")
		  .append("\n")
		  .append("  B  : add book\n")
		  .append("  LB : list books\n")
		  .append("  FB : fix books\n")
		  .append("\n")
		  .append("  L  : take out a loan\n")
		  .append("  R  : return a loan\n")
		  .append("  LL : list loans\n")
		  .append("\n")
		  .append("  P  : pay fine\n")
		  .append("\n")
		  .append("  T  : increment date\n")
		  .append("  Q  : quit\n")
		  .append("\n")
		  .append("Choice : ");
		  
		return sb.toString();
	}


	public static void main(String[] args) {		
		try {			
			input = new Scanner(System.in);//IN should be as input
			library = Library.getInstance();//LIB should be as library and INSTANCE should be as getInstance and library should be as Library
			calendar = Calendar.getInstance();//CAL should be as calendar and INSTANCE should be as getInstance
			simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//SDF should be as simpleDateFormat
	
			for (member m : library.members()) {//LIB should be as library and MEMBERS should be as members
				output(m);
			}
			output(" ");
			for (book b : library.books()) {//LIB should be as library and BOOKS should be as books
				output(b);
			}
						
			menu = getMenu();//Get_menu should be as getMenu and MENU should be as menu
			
			boolean isFalse = false;//e should be change as isFalse
			
			while (!isFalse) {//e should be change as isFalse
				
				output("\n" + simpleDateFormat.format(calendar.Date()));//CAL should be as calendar and SDF should be as simpleDateFormat
				String inputString = getInput(menu);//input should be as getInput and MENU should be as menu and c should be as inputString
				
				switch (c.toUpperCase()) {
				
				case "M": 
					addMember();//ADD_MEMBER should be as addMember
					break;
					
				case "LM": 
					members();//MEMBERS should be as members
					break;
					
				case "B": 
					addBook();//ADD_BOOK should be as addBook
					break;
					
				case "LB": 
					books();//BOOKS should be as books
					break;
					
				case "FB": 
					fixBooks();//FIX_BOOKS should be as fixBooks
					break;
					
				case "L": 
					borrowBook();//BORROW_BOOK should be as borrowBook
					break;
					
				case "R": 
					returnBook();//RETURN_BOOK should be as returnBook
					break;
					
				case "LL": 
					currentLoans();//CURRENT_LOANS should be as currentLoans
					break;
					
				case "P": 
					fines();//FINES should be as fines
					break;
					
				case "T": 
					incrementDate();//INCREMENT_DATE should be as incrementDate
					break;
					
				case "Q": 
					isFalse = true;//e should be change as isFalse
					break;
					
				default: 
					output("\nInvalid option\n");
					break;
				}
				
				Library.SAVE();//library should be as Library
			}			
		} catch (RuntimeException isFalse) {//e should be change as isFalse
			output(isFalse);//e should be change as isFalse
		}		
		output("\nEnded\n");
	}	

	
	private static void fines() {//FINES should be as fines
		new PayFineUI(new PayFineControl()).run();//RuN should be as run		
	}


	private static void currentLoans() {//CURRENT_LOANS should be as currentLoans
		output("");
		for (Loan loan : library.currentLoans()) {//LIB should be as library and CurrentLoans should be as currentLoans and loan loan should be change as Loan loan
			output(loan + "\n");
		}		
	}



	private static void outputBooks() {//BOOKS should be as outputBooks
		output("");
		for (Book book : library.getBooks()) {//LIB should be as library and BOOKS should be as getBooks and book book should be change as Book book
			output(book + "\n");
		}		
	}



	private static void outputMembers() {//MEMBERS should be as outputMembers
		output("");
		for (Member member : library.getMembers()) {//LIB should be as library and MEMBERS should be as getMembers and member member should be change as Member member
			output(member + "\n");
		}		
	}



	private static void borrowBook() {//BORROW_BOOK should be as borrowBook
		new BorrowBookUI(new BorrowBookControl()).run();		
	}


	private static void returnBook() {//RETURN_BOOK should be as returnBook
		new ReturnBookUI(new ReturnBookControl()).run();//RuN should be as run		
	}


	private static void fixBooks() {//FIX_BOOKS should be as fixBooks
		new FixBookUI(new FixBookControl()).run();//RuN should be as run		
	}


	private static void incrementDate() {//INCREMENT_DATE should be as incrementDate
		try {
			int days = Integer.valueOf(getInput("Enter number of days: ")).intValue();//input should be as getInput
			calendar.incrementDate(days);//CAL should be as calendar
			library.checkCurrentLoans();//LIB should be as library
			output(simpleDateFormat.format(calendar.Date()));//CAL should be as calendar and SDF should be as simpleDateFormat
			
		} catch (NumberFormatException isFalse) {//e should be change as isFalse
			 output("\nInvalid number of days\n");
		}
	}


	private static void addBook() {//ADD_BOOK should be as addBook
		
		String author = getInput("Enter author: ");//A should be as author and input should be as getInput
		String title  = getInput("Enter title: ");//T should be as title and input should be as getInput
		String callNumber = getInput("Enter call number: ");//C should be as callNumber and input should be as getInput
		book B = library.addBook(author, title, callNumber);//LIB should be as library and Add_book should be as addBook
		//A should be as author and T should be as title and C should be as callNumber
		output("\n" + B + "\n");
		
	}

	
	private static void addMember() {//ADD_MEMBER should be as addMember
		try {
			String lastName = getInput("Enter last name: ");//LN should be as lastName and input should be as getInput
			String firstName  = getInput("Enter first name: ");//FN should be as firstName and input should be as getInput
			String email = getInput("Enter email: ");//EM should be as email and input should be as getInput
			int phoneNo = Integer.valueOf(getInput("Enter phone number: ")).intValue();//PN should be as phoneNo and input should be as getInput
			member M = library.addMember(lastName, firstName, email, phoneNo);//LIB should be as library and Add_mem should be as addMember
			//LN should be as lastName and FN should be as firstName and EM should be as email and PN should be as phoneNo
			output("\n" + M + "\n");
			
		} catch (NumberFormatException isFalse) {//e should be change as isFalse
			 output("\nInvalid phone number\n");
		}
		
	}


	private static String getInput(String prompt) {//input should be as getInput
		System.out.print(prompt);
		return input.nextLine();//IN should be as input
	}
	
	
	
	private static void output(Object object) {
		System.out.println(object);
	}

	
}
