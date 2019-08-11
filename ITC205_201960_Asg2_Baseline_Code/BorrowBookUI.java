import java.util.Scanner;

public class BorrowBookUI {
	
	public static enum UiState {INITIALISED, READY, RESTRICTED, SCANNING, IDENTIFIED, FINALISING, COMPLETED, CANCELLED};//'UI_STATE' changed to'UiState'

	private BorrowBookControl borrowBookControl;//'CONTROL' changed to'borrowBookControl'
	private Scanner input;
	private UiState uiState;//'UI_STATE' changed to'UiState','StaTe' changed to'uiState',

	public BorrowBookUI(BorrowBookControl control) {
		this.borrowBookControl = control;//'CONTROL' changed to'borrowBookControl'
		input = new Scanner(System.in);
		uiState = UiState.INITIALISED;//'StaTe' changed to'uiState','UI_STATE' changed to'UiState'
		control.setUI(this);
	}

	private String getInput(String prompt) {//'input' changed to'getInput'
		System.out.print(prompt);
		return input.nextLine();
	}	
		
	private void outputInfo(Object object) {//'output' changed to'outputInfo'
		System.out.println(object);
	}
	
	public void setState(UiState state) {//'Set_State' changed to'setState','UI_STATE' changed to'UiState','STATE' changed to'state'
		this.state = state;//'StaTe' changed to'state','STATE' changed to'state'
	}

	public void run() {
		outputInfo("Borrow Book Use Case UI\n");//'output' changed to'outputInfo'
		
		while (true) {
			
			switch (state) {//'StaTe' changed to'state'			
			
			case CANCELLED:
				outputInfo("Borrowing Cancelled");//'output' changed to'outputInfo'
				return;
				
			case READY:
				String strMember = input("Swipe member card (press <enter> to cancel): ");//'MEM_STR' changed to'strMember'
				if (strMember.length() == 0) {//'MEM_STR' changed to'strMember'
					borrowBookControl.borrowCancel();//'CONTROL' changed to'borrowBookControl','cancel' changed to'borrowCancel'
					break;
				}
				try {
					int memberId = Integer.valueOf(strMember).intValue();//'Member_ID' changed to'memberId','MEM_STR' changed to'strMember'
					borrowBookControl.cardSwiped(memberId);//'CONTROL' changed to'borrowBookControl','Swiped' changed to 'cardSwiped','Member_ID' changed to'memberId'
				}
				catch (NumberFormatException e) {
					outputInfo("Invalid Member Id");//'output' changed to'outputInfo'
				}
				break;
				
			case RESTRICTED:
				getInput("Press <any key> to cancel");//'input' changed to'getInput'
				borrowBookControl.borrowCancel();//'CONTROL' changed to'borrowBookControl','cancel' changed to'borrowCancel'
				break;
				
			case SCANNING:
				String strBook = getInput("Scan Book (<enter> completes): ");//'Book_Str' changed to'strBook','input' changed to'getInput'
				if (strBook.length() == 0) {//'Book_Str' changed to'strBook'
					borrowBookControl.borrowComplete();//'CONTROL' changed to'borrowBookControl','Complete' changed to 'borrowComplete'
					break;
				}
				try {
					int bookId = Integer.valueOf(strBook).intValue();//'BiD' changed to'bookId',//'Book_Str' changed to'strBook'
					borrowBookControl.Scanned(bookId);//'CONTROL' changed to'borrowBookControl','BiD' changed to'bookId'
					
				} catch (NumberFormatException e) {
					outputInfo("Invalid Book Id");//'output' changed to'outputInfo'
				} 
				break;		
				
			case FINALISING:
				String answer = getInput("Commit loans? (Y/N): ");//'Ans' changed to'answer','input' changed to'getInput'
				if (answer.toUpperCase().equals("N")) {//'Ans' changed to'answer'
					borrowBookControl.borrowCancel();//'CONTROL' changed to'borrowBookControl','cancel' changed to'borrowCancel'
					
				} else {
					borrowBookControl.commitLoans();//'CONTROL' changed to'borrowBookControl','Commit_LOans' changed to'commitLoans'
					getInput("Press <any key> to complete ");//'input' changed to'getInput'
				}
				break;
				
			case COMPLETED:
				outputInfo("Borrowing Completed");//'output' changed to'outputInfo'
				return;
				
			default:
				outputInfo("Unhandled state");//'output' changed to'outputInfo'
				throw new RuntimeException("BorrowBookUI : unhandled state :" + StaTe);			
			}
		}		
	}

	public void displayInfo(Object object) {   //'Display' changed to'displayInfo'
		outputInfo(object);		//'output' changed to'outputInfo'
	}

}
