
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Library implements Serializable {//library should be change as Library
	
	private static final String LIBRARY_FILE = "library.obj";//libraryFile should be as LIBRARY_FILE
	private static final int LOAN_LIMIT = 2;//loanLimit should be as LOAN_LIMIT
	private static final int LOAN_PERIOD = 2;//loanPeriod should be as LOAN_PERIOD
	private static final double FINE_PER_DAY = 1.0;//finePerDay should be as FINE_PER_DAY
	private static final double MAX_FINES_OWED = 1.0;//maxFinesOwed should be as MAX_FINES_OWED
	private static final double DAMAGE_FEE = 2.0;//damageFee should be as DAMAGE_FEE
	
	private static Library self;//SeLf should be as self and library should be change as Library
	private int bookId;//BOOK_ID should be as bookId
	private int memberId;//MEMBER_ID should be as memberId
	private int loanId;//LOAN_ID should be as loanId
	private Date loanDate;//LOAN_DATE should be as loanDate
	
	private Map<Integer, book> catalog;//CATALOG should be as catalog
	private Map<Integer, member> members;//MEMBERS should be as members
	private Map<Integer, loan> loans;//LOANS should be as loans
	private Map<Integer, loan> currentLoans;//CURRENT_LOANS should be as currentLoans
	private Map<Integer, book> damagedBooks;//DAMAGED_BOOKS should be as damagedBooks
	

	private library() {
		catalog = new HashMap<>();//CATALOG should be as catalog
		members = new HashMap<>();//MEMBERS should be as members
		loans = new HashMap<>();//LOANS should be as loans
		currentLoans = new HashMap<>();//CURRENT_LOANS should be as currentLoans
		damagedBooks = new HashMap<>();//DAMAGED_BOOKS should be as damagedBooks
		bookId = 1;//BOOK_ID should be as bookId
		memberId = 1;//MEMBER_ID should be as memberId	
		loanId = 1;//LOAN_ID should be as loanId	
	}

	
	public static synchronized Library getInstance() {//INSTANCE should be as getInstance and library should be change as Library	
		if (self == null) {//SeLf should be as self
			Path path = Paths.get(LIBRARY_FILE);//libraryFile should be as LIBRARY_FILE and PATH should be as path		
			if (Files.exists(path)) {//PATH should be as path	
				try (ObjectInputStream lif = new ObjectInputStream(new FileInputStream(LIBRARY_FILE));) {
					//libraryFile should be as LIBRARY_FILE and LiF should be change as lif
			    
					self = (Library) lif.readObject();
					//SeLf should be as self and library should be change as Library and LiF should be change as lif
					Calendar.getInstance().setDate(self.loanDate);//Set_dATE should be as setDate
					//LOAN_DATE should be as loanDate and INSTANCE should be as getInstance and SeLf should be as self
					lif.close();//LiF should be change as lif
				}
				catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			else self = new library();//SeLf should be as self
		}
		return self;//SeLf should be as self
	}

	
	public static synchronized void SAVE() {
		if (self != null) {//SeLf should be as self
			self.loanDate = Calendar.getInstance().Date();//LOAN_DATE should be as loanDate and INSTANCE should be as getInstance and SeLf should be as self
			try (ObjectOutputStream lof = new ObjectOutputStream(new FileOutputStream(LIBRARY_FILE));) {
				//libraryFile should be as LIBRARY_FILE and LoF should be change as lof
				lof.writeObject(self);//SeLf should be as self and LoF should be change as lof
				lof.flush();//LoF should be change as lof
				lof.close();//LoF should be change as lof
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	
	public int getBookId() {//BookID should be as getBookId
		return bookId;//BOOK_ID should be as bookId
	}
	
	
	public int getMemberId() {//MemberID should be as getMemberId
		return memberId;//MEMBER_ID should be as memberId
	}
	
	
	private int getNextBookId() {//NextBID should be as getNextBookId
		return bookId++;//BOOK_ID should be as bookId
	}

	
	private int getNextMemberId() {//NextMID should be as getNextMemberId
		return memberId++;//MEMBER_ID should be as memberId
	}

	
	private int getNextLoanId() {//NextLID should be as getNextLoanId
		return loanId++;//LOAN_ID should be as loanId
	}

	
	public List<Member> getMembers() {//members should be as getMembers and member should be as Member		
		return new ArrayList<Member>(members.values());//MEMBERS should be as members and member should be as Member
	}


	public List<book> getBooks() {//BOOKS should be as getBooks and book should be as Book		
		return new ArrayList<book>(catalog.values());//CATALOG should be as catalog
	}


	public List<loan> getCurrentLoans() {//CurrentLoans should be as getCurrentLoans
		return new ArrayList<loan>(currentLoans.values());//CURRENT_LOANS should be as currentLoans
	}


	public Member addMember(String lastName, String firstName, String email, int phoneNo) {//Add_mem should be as addMember and member should be as Member		
		Member member = new Member(lastName, firstName, email, phoneNo, nextMemberId());//NextMID should be as nextMemberId and member should be as Member
		members.put(Member.getId(), Member);//MEMBERS should be as members and GeT_ID should be as getId and member should be as Member	
		return Member;//member should be as Member
	}

	
	public Book addBook(String author, String title, String callNumber) {
		//Add_book should be as addBook and book should be change as Book a should be as author and t should be as title and c should be as callNumber	
		Book book = new Book(author, title, callNumber, getnextBookId());
		//NextBID should be as getnextBookId and book should be as Book and and b should be as book and a should be as author and t should be as title and c should be as callNumber
		catalog.put(book.bookId(), b);//CATALOG should be as catalog and ID should be as bookId and b should be as book	
		return book;//b should be as book
	}

	
	public Member getMember(int memberId) {//MEMBER should be as getMember and member should be as Member
		if (members.containsKey(memberId))//MEMBERS should be as members 
			return members.get(memberId);//MEMBERS should be as members
		return null;
	}

	
	public Book getBook(int bookId) {//book should be as Book and Book should be as getBook
		if (catalog.containsKey(bookId))//CATALOG should be as catalog 
			return catalog.get(bookId);//CATALOG should be as catalog		
		return null;
	}

	
	public int loanLimit() {//LOAN_LIMIT should be as loanLimit
		return LOAN_LIMIT;//loanLimit should be as LOAN_LIMIT
	}

	
	public boolean memberCanBorrow(Member member) {//MEMBER_CAN_BORROW should be as memberCanBorrow	and member should be as Member	
		if (Member.getNumberOfCurrentLoans() == LOAN_LIMIT )
			//Number_Of_Current_Loans should be as getNumberOfCurrentLoans and loanLimit should be as LOAN_LIMIT and member should be as Member
			return false;
				
		if (Member.getFinesOwed() >= MAX_FINES_OWED)
			//Fines_OwEd should be as getFinesOwed and maxFinesOwed should be as MAX_FINES_OWED and member should be as Member
			return false;
				
		for (Loan loan : Member.getLoans())//GeT_LoAnS should be as getLoans and member should be as Member and loan loan should change as Loan loan
			if (loan.isOverDue())//OVer_Due should be as isOverDue
				return false;
			
		return true;
	}

	
	public int loansRemainingForMember(Member member) {//Loans_Remaining_For_Member should be as loansRemainingForMember and member should be as Member
		return LOAN_LIMIT - Member.getNumberOfCurrentLoans();
		//loanLimit should be as LOAN_LIMIT and Number_Of_Current_Loans should be as getNumberOfCurrentLoans and member should be as Member
	}

	
	public loan issueLoan(Book book, Member member) {//ISSUE_LAON should be as issueLoan and member should be as Member and book should be as Book
		Date dueDate = Calendar.getInstance().getDueDate(LOAN_PERIOD);//Due_Date should be as getDueDate and loanPeriod should be as LOAN_PERIOD and INSTANCE should be as getInstance
		Loan loan = new loan(nextLoanId(), book, member, dueDate);//NextLID should be as nextLoanId and loan loan should change as Loan loan
		Member.takeOutLoan(loan);//Take_Out_Loan should be as takeOutLoan and member should be as Member
		book.borrowBooks();//Borrow should be channge as borrowBooks
		loans.put(loan.bookId(), loan);//LOANS should be as loans and ID should be as bookId
		currentLoans.put(book.bookId(), loan);//CURRENT_LOANS should be as currentLoans ID should be as bookId
		return loan;
	}
	
	
	public loan getLoanByBookId(int bookId) {//LOAN_BY_BOOK_ID should be as getLoanByBookId
		if (currentLoans.containsKey(bookId)) {//CURRENT_LOANS should be as currentLoans
			return currentLoans.get(bookId);//CURRENT_LOANS should be as currentLoans
		}
		return null;
	}

	
	public double calculateOverDueFine(Loan loan) {//CalculateOverDueFine should be as calculateOverDueFine and loan loan should change as Loan loan
		if (loan.isOverDue()) {//OVer_Due should be as isOverDue
			long daysOverDue = Calendar.getInstance().getDaysDifference(loan.getDueDate());
			//INSTANCE should be as getInstance and Get_Days_Difference should be as getDaysDifference and Get_Due_Date should be as getDueDate 
			double fine = daysOverDue * FINE_PER_DAY;//finePerDay should be as FINE_PER_DAY
			return fine;
		}
		return 0.0;		
	}


	public void dischargeLoan(Loan currentLoan, boolean isDamaged) {//Discharge_loan should be as dischargeLoan and loan should be as Loan
		Member member = currentLoan.member();//member should be as Member
		Book book  = currentLoan.getBook();//Book should be as getBook and book should be as Book
		
		double overDueFine = calculateOverDueFine(currentLoan);//CalculateOverDueFine should be as calculateOverDueFine
		Member.addFine(overDueFine);//Add_Fine should be as addFine and member should be as Member	
		
		Member.dischargeLoan(currentLoan);//dIsChArGeLoAn should be as dischargeLoan and member should be as Member
		book.returnBooks(isDamaged);//book.Return should be as book.returnBooks
		if (isDamaged) {
			Member.addFine(DAMAGE_FEE);//damageFee should be as DAMAGE_FEE and Add_Fine should be as addFine and member should be as Member
			damagedBooks.put(book.bookId(), book);//DAMAGED_BOOKS should be as damagedBooks and ID should be as bookId
		}
		currentLoan.discharge();//DiScHaRgE should be as discharge
		currentLoans.remove(book.bookId());//CURRENT_LOANS should be as currentLoans and ID should be as bookId
	}


	public void checkCurrentLoans() {
		for (Loan loan : currentLoans.values()) {//CURRENT_LOANS should be as currentLoans and loan loan should change as Loan loan
			loan.checkOverDue();
		}		
	}


	public void repairBook(book currentBook) {//Repair_BOOK should be repairBook
		if (damagedBooks.containsKey(currentBook.bookId())) {//DAMAGED_BOOKS should be as damagedBooks and ID should be as bookId
			currentBook.repairBooks();//Repair should be as repairBooks
			damagedBooks.remove(currentBook.bookId());//DAMAGED_BOOKS should be as damagedBooks and ID should be as bookId
		}
		else {
			throw new RuntimeException("Library: repairBook: book is not damaged");
		}
		
	}
	
	
}
