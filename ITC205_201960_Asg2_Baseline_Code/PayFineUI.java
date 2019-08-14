import java.util.Scanner;


public class PayFineUI {


	public static enum UiState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED };//UI_STATE IS CHANGED TO UiState

	private PayFineControl control;//coNtRoL is changed to control
	private Scanner input;
	private UiState state;//StAtE is changed to state

	
	public payFineUI(PayFineControl control) { //PayFineUI is changed to payFineUi and PayFineControl is changed to PayFineControl
		this.control = control;//CoNtRoL is changed to control and control is changed to control
		input = new Scanner(System.in);
		state = UiState.INITIALISED;//StAtE is changed to state and UI_STATE is changed to UiState
		control.setUi(this);//Set_UI is changed to setUi
	}
	
	
	public void setState(UiState state) { //Set_State is changed to setState and UI_STATE is changed to UiState 
		this.state = state; //State is changed to state and state is changed to state 
	}


	public void run() { //RuN is changed to run
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) { //StAtE is changed to state
			
			case READY:
			      String memberString = input("Swipe member card (press <enter> to cancel): "); //Mem_Str is changed to memberString
				if (memberString.length() == 0) { //Mem_Str is changed to memberString
					control.cancel();//CoNtRoL is changed to control and CaNcEl is changed to cancel
					break;
				}
				try {
				int memberId = Integer.valueOf(memStr).intValue();//Member_ID is changed to memberId and Mem_Str is changed to memStr
					control.cardSwiped(memberId);//CoNtRoL is changed to control,Card_Swiped is changed to cardSwiped and Member_ID is changed to memberId
				}
				catch (numberFormatException e) { //NumberFormatException is changed to numberFormatException
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0; //AmouNT is changed to amount
				String amountString = input("Enter amount (<Enter> cancels) : "); //Amt_Str is changed to amountString
				if (amountString.length() == 0) { //Amt_Str is changed to amountString
					control.cancel();//CoNtRoL is changed to control and CaNcEl is changed to cancel 
					break;
				}
				try {
					amount = Double.valueOf(amtStr).doubleValue();//AmouNT is changed to amount and Amt_Str is changed to amtStr
				}
				catch (numberFormatException e) {} //NumberFormatException is changed to numberFormatException
				if (amount <= 0) { //AmouNT is changed to amount
					output("Amount must be positive");
					break;
				}
				control.payFine(amount);//CoNtRoL is changed to control and PaY_FiNe is changed to payFine and AmouNT is changed to amount
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);//StAtE is changed to state			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	public void display(Object object) { //DiSplAY is changed to display
		output(object);
	}


}
