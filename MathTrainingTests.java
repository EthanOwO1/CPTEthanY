import arc.*;

public class MathTrainingTests{
	public static void linearTest(Console con){
		TextInputFile linear = new TextInputFile("linear.txt");

		// Creating an array to randomize the questions
		String strRandomNum[][];

		// Variables
		String strQuestion = "";
		String strAnswer1 = "";
		String strAnswer2 = "";
		String strAnswer3 = "";
		int intQuestions = 0;
		int intCorrectAnswer = 0;
		int intNumQuestions = 0;
		double dblPercentage = 0.0;
		

		while(linear.eof() == false){
						
			strQuestion = linear.readLine();
			strAnswer1 = linear.readLine();
			strAnswer2 = linear.readLine();
			strAnswer3 = linear.readLine();
			intQuestions += 1;
		}
		
		linear.close();
					
		strRandomNum = new String[intQuestions][5];

		System.out.println("Continue");
		
		linear = new TextInputFile("linear.txt");

		while(linear.eof() == false){
			String strRandomNum1;
			
			int intRow;
			
			for(intRow = 0; intRow < intQuestions; intRow++){
				
				strRandomNum1 = Integer.toString((int)(Math.random() * 100 + 1));
				
				strRandomNum[intRow][0] = linear.readLine();
				strRandomNum[intRow][1] = linear.readLine();
				strRandomNum[intRow][2] = linear.readLine();
				strRandomNum[intRow][3] = linear.readLine();
				strRandomNum[intRow][4] = strRandomNum1;
			}
		}
		
		linear.close();
		
		// Bubble Sort 
		String strTempQuestion;
		String strTempAns1;
		String strTempAns2;
		String strTempAns3;
		String strTempRandomNum;
		int intRow2;
		int intRow3;
	
		
		for(intRow3 = 0; intRow3 < intQuestions - 1; intRow3++){
			
			for(intRow2 = 0; intRow2 < intQuestions - 1 - intRow3; intRow2++){
				// Bubble sort. If left is bigger than right
				
				if(Integer.parseInt(strRandomNum[intRow2][4]) > Integer.parseInt(strRandomNum[intRow2 + 1][4])){
					
					// Take the left item
					strTempQuestion = strRandomNum[intRow2][0];
					strTempAns1 = strRandomNum[intRow2][1];
					strTempAns2 = strRandomNum[intRow2][2];
					strTempAns3 = strRandomNum[intRow2][3];
					
					// Right item moves to the left
					strRandomNum[intRow2][0] = strRandomNum[intRow2 + 1][0];
					strRandomNum[intRow2][1] = strRandomNum[intRow2 + 1][1];
					strRandomNum[intRow2][2] = strRandomNum[intRow2 + 1][2];
					strRandomNum[intRow2][3] = strRandomNum[intRow2 + 1][3];
					
					// Put temporary value on the right
					strRandomNum[intRow2 + 1][0] = strTempQuestion;
					strRandomNum[intRow2 + 1][1] = strTempAns1;
					strRandomNum[intRow2 + 1][2] = strTempAns2;
					strRandomNum[intRow2 + 1][3] = strTempAns3;
				}
			}
		}
							
		int intLoop;
		
		for(intLoop = 0; intLoop < intQuestions; intLoop++){
		
			con.println("Question: ");
			con.println(strRandomNum[intLoop][0]);
			String strResponse = con.readLine();
		
			if(strResponse.equalsIgnoreCase(strRandomNum[intLoop][1]) || 
			strResponse.equalsIgnoreCase(strRandomNum[intLoop][2]) ||
			strResponse.equalsIgnoreCase(strRandomNum[intLoop][3])
			){
			
				con.println("Congrats! You got the correct answer.");
				intCorrectAnswer += 1;
				
				con.sleep(3000);
			
			} else {
				con.println("You got the wrong answer. It should either be: " + strRandomNum[intLoop][1] + ", " + strRandomNum[intLoop][2] + ", " + strRandomNum[intLoop][3]);
				con.sleep(3000);
			}
			
			intNumQuestions += 1;
			dblPercentage = intCorrectAnswer / intNumQuestions;
			con.clear();
			
		}
		
		// Calculating the percentage of answers
		con.println("Number of correct answer: " + intCorrectAnswer);
		con.sleep(2000);
		con.println("Thanks for playing!");
		con.println("Return back to main menu?");
		String strBack = con.readLine();
		con.clear();
	}
}

