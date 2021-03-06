//
//TODO  file header comment

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

//TODO class header comment

public class Sticks {
	
	/**
	 * This is the main method for the game of Sticks. 
	 * In milestone 1 this contains the whole program for playing
	 * against a friend.
	 * In milestone 2 this contains the welcome, name prompt, 
	 * how many sticks question, menu, calls appropriate methods
	 * and the thank you message at the end.
	 * One method called in multiple places is promptUserForNumber.
	 * When the menu choice to play against a friend is chosen,
	 * then playAgainstFriend method is called.
	 * When the menu choice to play against a computer is chosen,
	 * then playAgainstComputer method is called.  If the
	 * computer with AI option is chosen then trainAI is called
	 * before calling playAgainstComputer.  Finally, 
	 * call strategyTableToString to prepare a strategy table
	 * for printing. 
	 * 
	 * @param args (unused)
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String player1Name = "";
		String player2Name = "";
		int startSticks = 0;
		int userMenuChoice = 0;
		
		System.out.println("Welcome to the Game of Sticks!");
		System.out.println("==============================");
		System.out.println("");
		
		System.out.print("What is your name? ");
		player1Name = input.next();
		System.out.println("Hello " + player1Name + ".");
		
		//*Max* responding to unexpected user input for initial number of sticks
		
		boolean haveValidNumber = false;
		do {
			//System.out.print("How many sticks are there on the table initially (10-100)? ");
			//System.out.print("How many sticks are there on the table initially (11-99)? ");
			System.out.print("How many sticks are there on the table initially ("+Config.MIN_STICKS+"-"
					+Config.MAX_STICKS+")? ");
			if (input.hasNextInt()) {
				startSticks = input.nextInt();
				input.nextLine();
				if ((startSticks >= Config.MIN_STICKS) && (startSticks <= Config.MAX_STICKS)) {
					haveValidNumber = true;
				}
				else {
					//System.out.println("Please enter a number between 10 and 100.");
					System.out.println("Please enter a number between "+Config.MIN_STICKS+" and "+Config.MAX_STICKS+".");
				}
			}
			else {
				String invalidInput = input.nextLine();
				//System.out.println("Error: expected a number between 10 and 100 but found: " + invalidInput);
				System.out.println("Error: expected a number between "+Config.MIN_STICKS+" and "+Config.MAX_STICKS+" but found: " + invalidInput);
			}
		} while (!haveValidNumber);
		
		
		
		System.out.println("");
		
		//menu
		System.out.println("Would you like to:");
		System.out.println(" 1) Play against a friend");
		System.out.println(" 2) Play against computer (basic)");
		System.out.println(" 3) Play against computer with AI");
		//System.out.print("Which do you choose (1,2,3)? ");
		//userMenuChoice = input.nextInt();
		
		//*Max* response to unexpected user input for menu choice
		
		boolean haveValidChoice = false;
		do {
			System.out.print("Which do you choose (1,2,3)? ");
			if (input.hasNextInt()) {
				userMenuChoice = input.nextInt();
				input.nextLine();
				if ((userMenuChoice >= 1) && (userMenuChoice <= 3)) {
					haveValidChoice = true;
				}
				else {
					System.out.println("Please enter a number between 1 and 3.");
				}
			}
			else {
				String invalidInput = input.nextLine();
				System.out.println("Error: expected a number between 1 and 3 but found: " + invalidInput);
			}
		} while (!haveValidChoice);
		
	
		
		System.out.println();
		
		switch (userMenuChoice) {
		case 1:
			// Play against a friend
			playAgainstFriend(input, startSticks, player1Name, player2Name);
			break;
			
		case 2:
			// Play against computer (basic)
			int[][] compStrategyTable = createAndInitializeStrategyTable(startSticks);
			playAgainstComputer(input, startSticks, player1Name, compStrategyTable);
			break;
			
		case 3:
			// Play against computer with AI
			break;
		}
		
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("Thank you for playing the Game of Sticks!");
		input.close();
	}

	/**
	 * This method encapsulates the code for prompting the user for a number and
	 * verifying the number is within the expected bounds.
	 * 
	 * @param input
	 *            The instance of the Scanner reading System.in.
	 * @param prompt
	 *            The prompt to the user requesting a number within a specific
	 *            range.
	 * @param min
	 *            The minimum acceptable number.
	 * @param max
	 *            The maximum acceptable number.
	 * @return The number entered by the user between and including min and max.
	 */
	static int promptUserForNumber(Scanner input, String prompt, 
			int min, int max) {
		
		int sticksTaken = 0;
		
		boolean haveValidSticks = false;
		do {
			System.out.print(prompt);
			if (input.hasNextInt()) {
				sticksTaken = input.nextInt();
				input.nextLine();
				if ((sticksTaken >= min) && (sticksTaken <= max)) {
					haveValidSticks = true;
				}
				else {
					System.out.println("Please enter a number between " + min + " and " + max + ".");
				}
			}
			else {
				String invalidInput = input.nextLine();
				System.out.println("Error: expected a number between " + min + " and " + max + " but found: " + invalidInput);
			}
		} while (!haveValidSticks);
		
		//System.out.println(prompt);
		//sticksTaken = input.nextInt();
		
		return sticksTaken;
	}
	
	/**
	 * This method has one person play the Game of Sticks against another
	 * person.
	 * 
	 * @param input
	 *            An instance of Scanner to read user answers.
	 * @param startSticks
	 *            The number of sticks to start the game with.
	 * @param player1Name
	 *            The name of one player.
	 * @param player2Name
	 *            The name of the other player.
	 * 
	 *            As a courtesy, player2 is considered the friend and gets to
	 *            pick up sticks first.
	 * 
	 */
	static void playAgainstFriend(Scanner input, int startSticks, 
			String player1Name, String player2Name) {
		//TODO
		
		// Play against a friend -move to playAgainstFriend
		
		
		System.out.print("What is your friend's name? ");
		player2Name = input.next();
		System.out.println("Hello " + player2Name + ".");
		System.out.println();
		
		int minAction = Config.MIN_ACTION;
		int maxAction = Config.MAX_ACTION;
		
		
		int sticksTaken = 0;
		int remainingSticks = startSticks;
		String playerName = player2Name;
	
		while (remainingSticks > 0) {
			
			
			
			if (remainingSticks <= 3) {
				 maxAction = remainingSticks;
			}
			
			String prompt = playerName + ": How many sticks do you take (" + minAction + "-" + maxAction + ")? ";
			
			String remainingStatement = "There are " + remainingSticks + " sticks on the board.";
			
			if (remainingSticks == 1) {
				remainingStatement = "There is " + remainingSticks + " stick on the board.";
			}
			
			
			System.out.println(remainingStatement);
			sticksTaken = promptUserForNumber(input, prompt, minAction, maxAction);
			remainingSticks = remainingSticks - sticksTaken;
			
			if (playerName.equals(player1Name)) {
				playerName = player2Name;
			}
			else {
				playerName = player1Name;
			}
			

		}

		
		// if() - winner
		if(playerName.equals(player1Name)) {
			System.out.println( playerName + " wins. " + player2Name + " loses." );
		}
		else {
			System.out.println( playerName + " wins. " + player1Name + " loses." );
		}
		
	}	
		
	
	/**
	 * Make a choice about the number of sticks to pick up when given the number
	 * of sticks remaining.
	 * 
	 * Algorithm: If there are less than Config.MAX_ACTION sticks remaining, 
	 * then pick up the minimum number of sticks (Config.MIN_ACTION). 
	 * If Config.MAX_ACTION sticks remain, randomly choose a number between 
	 * Config.MIN_ACTION and Config.MAX_ACTION. Use Config.RNG.nextInt(?) 
	 * method to generate an appropriate random number.
	 * 
	 * @param sticksRemaining
	 *            The number of sticks remaining in the game.
	 * @return The number of sticks to pick up, or 0 if sticksRemaining is <= 0.
	 */
	static int basicChooseAction(int sticksRemaining) {
		
		
		int computerChoice = 0;
		
		if (sticksRemaining <Config.MAX_ACTION && sticksRemaining > 0) {
			computerChoice = Config.MIN_ACTION;
		}
		else if (sticksRemaining >= Config.MAX_ACTION) {
			computerChoice = Config.RNG.nextInt(Config.MAX_ACTION) +1;
		}
		else if (sticksRemaining <= 0) {
			computerChoice = 0;
		}
		
		
		
		
		return computerChoice;
		
	}
	
	/**
	 * This method has a person play against a computer.
	 * Call the promptUserForNumber method to obtain user input.  
	 * Call the aiChooseAction method with the actionRanking row 
	 * for the number of sticks remaining. 
	 * 
	 * If the strategyTable is null, then this method calls the 
	 * basicChooseAction method to make the decision about how 
	 * many sticks to pick up. If the strategyTable parameter
	 * is not null, this method makes the decision about how many sticks to 
	 * pick up by calling the aiChooseAction method. 
	 * 
	 * @param input
	 *            An instance of Scanner to read user answers.
	 * @param startSticks
	 *            The number of sticks to start the game with.
	 * @param playerName
	 *            The name of one player.
	 * @param strategyTable
	 *            An array of action rankings. One action ranking for each stick
	 *            that the game begins with.
	 * 
	 */
	static void playAgainstComputer(Scanner input, int startSticks, 
			String playerName, int[][] strategyTable) {
		//TODO
		
		Config.RNG.setSeed(432);
		int minAction = Config.MIN_ACTION;
		int maxAction = Config.MAX_ACTION;
		int [] actionRanking = new int[maxAction];
		
		int sticksTaken = 0;
		int remainingSticks = startSticks;
		int turn = 0;
	
		while (remainingSticks > 0) {
			
			
			
			if (remainingSticks <= 3) {
				 maxAction = remainingSticks;
			}
			
			String remainingStatement = "There are " + remainingSticks + " sticks on the board.";
			String prompt = playerName + ": How many sticks do you take (" + minAction + "-" + maxAction + ")? ";
			
			if (remainingSticks == 1) {
				remainingStatement = "There is " + remainingSticks + " stick on the board.";
			}
				
			if (turn%2 ==0) {	
				System.out.println(remainingStatement);
				sticksTaken = promptUserForNumber(input, prompt, minAction, maxAction);
				remainingSticks = remainingSticks - sticksTaken;
				
			}
			else {
				
				System.out.println(remainingStatement);
				sticksTaken = aiChooseAction(remainingSticks, strategyTable[remainingSticks-1]);
				//sticksTaken = basicChooseAction(remainingSticks);
				if (sticksTaken == 1) {
					System.out.println("Computer selects " + sticksTaken + " stick.");
				}
				else {
					System.out.println("Computer selects " + sticksTaken + " sticks.");
				}
				
				remainingSticks = remainingSticks - sticksTaken;
			}
			
			
			turn++;

		}

		

		if (turn%2 == 0) {
			System.out.println(playerName + " wins. Computer loses.");
			//System.out.println("Computer wins. " + playerName + " loses.");
		}
		else {
			//System.out.println(playerName + " wins. Computer loses.");
			System.out.println("Computer wins. " + playerName + " loses.");
		}
		
		
	}
	
	/**
	 * This method chooses the number of sticks to pick up based on the
	 * sticksRemaining and actionRanking parameters.
	 * 
	 * Algorithm: If there are less than Config.MAX_ACTION sticks remaining 
	 * then the chooser must pick the minimum number of sticks (Config.MIN_ACTION). 
	 * For Config.MAX_ACTION or more sticks remaining then pick based on the 
	 * actionRanking parameter.
	 * 
	 * The actionRanking array has one element for each possible action. The 0
	 * index corresponds to Config.MIN_ACTION and the highest index corresponds
	 * to Config.MAX_ACTION. For example, if Config.MIN_ACTION is 1 and 
	 * Config.MAX_ACTION is 3, an action can be to pick up 1, 2 or 3 sticks. 
	 * actionRanking[0] corresponds to 1, actionRanking[1] corresponds to 2, etc. 
	 * The higher the element for an action in comparison to other elements, 
	 * the more likely the action should be chosen.
	 * 
	 * First calculate the total number of possibilities by summing all the
	 * element values. Then choose a particular action based on the relative
	 * frequency of the various rankings. 
	 * For example, if Config.MIN_ACTION is  1 and Config.MAX_ACTION is 3: 
	 * If the action rankings are {9,90,1}, the total is 100. Since 
	 * actionRanking[0] is 9, then an action of picking up 1 should be chosen 
	 * about 9/100 times. 2 should be chosen about 90/100 times and 1 should 
	 * be chosen about 1/100 times. Use Config.RNG.nextInt(?) method to 
	 * generate appropriate random numbers.
	 * 
	 * @param sticksRemaining
	 *            The number of sticks remaining to be picked up.
	 * @param actionRanking
	 *            The counts of each action to take. The 0 index corresponds to
	 *            Config.MIN_ACTION and the highest index corresponds to
	 *            Config.MAX_ACTION.
	 * @return The number of sticks to pick up. 0 is returned for the following
	 *         conditions: actionRanking is null, actionRanking has a length of
	 *         0, or sticksRemaining is <= 0.
	 * 
	 */
	static int aiChooseAction(int sticksRemaining, int[] actionRanking) {
		
		//copied basic action, edited
				
		
//		sticksRemaining = actionRanking[0] + actionRanking[1] + actionRanking[2]
//		not making array yet, just using the values	
		
		
		
		
		int computerChoice = 0;
		
		if (actionRanking == null) {
			computerChoice = basicChooseAction(sticksRemaining);
			//computerChoice = 0;
		}
		
		else if (actionRanking.length == 0) {
			computerChoice = 0;
		}

		else if (sticksRemaining <= 0) {
			computerChoice = 0;
		}
		
		
		
		else if (sticksRemaining <Config.MAX_ACTION && sticksRemaining > 0) {
					computerChoice = Config.MIN_ACTION;
				}
				
		// action ranking array
		else if (sticksRemaining >= Config.MAX_ACTION) {
//			computerChoice = 
//			randGen -- probability							
			
			
			int actionRankingSum = 0;
			for (int i=0; i<actionRanking.length; ++i) {
				actionRankingSum += actionRanking[i];
			}
			
			
			Random randGen = Config.RNG;
			int randomNum = randGen.nextInt(actionRankingSum);
			int[] probability = new int[actionRanking.length +1];
			
			for (int i = 1; i<probability.length; i++) {
				probability[i] = probability[i - 1] + actionRanking[i-1];
			}
			
			for (int i = 1; i<probability.length; i++) {
				if (randomNum >= probability[i-1] && randomNum < probability[i] ) {
					computerChoice = i;
				}
					
			}

			

			
		}
				
				
				
				
				
		return computerChoice;
		
	}
	

	/**
	 * This method initializes each element of the array to 1. If actionRanking
	 * is null then method simply returns.
	 * 
	 * @param actionRanking
	 *            The counts of each action to take. Use the length of the
	 *            actionRanking array rather than rely on constants for the
	 *            function of this method.
	 */
	static void initializeActionRanking(int []actionRanking) {
		if(actionRanking == null) 
			return;
		
		for(int i=0; i < actionRanking.length; ++i) {
			actionRanking[i] = 1;
		}
	}
	
	/**
	 * This method returns a string with the number of sticks left and the
	 * ranking for each action as follows.
	 * 
	 * An example: 10     3,4,11
	 * 
	 * The string begins with a number (number of sticks left), then is followed
	 * by 1 tab character, then a comma separated list of rankings, one for each
	 * action choice in the array. The string is terminated with a newline (\n) 
	 * character.
	 * 
	 * @param sticksLeft
	 *            The number of sticks left.
	 * @param actionRanking
	 *            The counts of each action to take. Use the length of the
	 *            actionRanking array rather than rely on constants for the
	 *            function of this method.
	 * @return A string formatted as described.
	 */
	static String actionRankingToString(int sticksLeft, int[]actionRanking) {
		String rankingString = sticksLeft + "\t";
		
		for(int i=0; i < actionRanking.length; ++i) {
			rankingString += actionRanking[i];
			if (i < actionRanking.length - 1) {
				rankingString += ",";
			}
			else {
				rankingString += "\n";
			}		
		}
		//System.out.print(rankingString);
		return  rankingString;
	}


	/**
	 * This method updates the actionRanking based on the action. Since the game
	 * was lost, the actionRanking for the action is decremented by 1, but not
	 * allowing the value to go below 1.
	 * 
	 * @param actionRanking
	 *            The counts of each action to take. The 0 index corresponds to
	 *            Config.MIN_ACTION and the highest index corresponds to
	 *            Config.MAX_ACTION.
	 * @param action
	 *            A specific action between and including Config.MIN_ACTION and
	 *            Config.MAX_ACTION.
	 */
	static void updateActionRankingOnLoss(int []actionRanking, int action) {
		actionRanking[action - 1] -= 1;
	}
	
	/**
	 * This method updates the actionRanking based on the action. Since the game
	 * was won, the actionRanking for the action is incremented by 1.
	 * 
	 * @param actionRanking
	 *            The counts of each action to take. The 0 index corresponds to
	 *            Config.MIN_ACTION and the highest index corresponds to
	 *            Config.MAX_ACTION.
	 * @param action
	 *            A specific action between and including Config.MIN_ACTION and
	 *            Config.MAX_ACTION.
	 */
	static void updateActionRankingOnWin(int []actionRanking, int action) {
		actionRanking[action - 1] += 1;
	}
	
	/**
	 * Allocates and initializes a 2 dimensional array. The number of rows
	 * corresponds to the number of startSticks. Each row is an actionRanking
	 * with an element for each possible action. The possible actions range from
	 * Config.MIN_ACTION to Config.MAX_ACTION. Each actionRanking is initialized
	 * with the initializeActionRanking method.
	 * 
	 * @param startSticks
	 *            The number of sticks the game is starting with.
	 * @return The two dimensional strategyTable, properly initialized.
	 */
	static int[][] createAndInitializeStrategyTable(int startSticks) {
		int[][] strategyTable = new int[startSticks][Config.MAX_ACTION];
		for(int i = 0; i < strategyTable.length; i++) {
			for(int j = 0; j < strategyTable[i].length; j++) {
				strategyTable[i][j] = 1;
			}
		}
		
		return strategyTable; //TODO change to return the array
	}	
		
	/**
	 * This formats the whole strategyTable as a string utilizing the
	 * actionRankingToString method. For example:
	 * 
	 * Strategy Table 
	 * Sticks Rankings 
	 * 10	  3,4,11 
	 * 9      6,2,5 
	 * 8      7,3,1 etc.
	 * 
	 * The title "Strategy Table" should be proceeded by a \n.
	 * 
	 * @param strategyTable
	 *            An array of actionRankings.
	 * @return A string containing the properly formatted strategy table.
	 */
	static String strategyTableToString(int[][] strategyTable) {
		
		int sticksRemaining = strategyTable.length;
		int[] actionRanking = new int[Config.MAX_ACTION];
		String strategyTableString = "\nStrategy Table\nSticks\tRankings\n";
		
		while(sticksRemaining > 0) {
			
			//actionRanking[sticksRemaining] = strategyTable[sticksRemaining][];
			for (int i = 0; i <strategyTable[sticksRemaining-1].length; i++) {
				actionRanking[i] = strategyTable[sticksRemaining-1][i];
			}
			strategyTableString += actionRankingToString(sticksRemaining, actionRanking);
			
			sticksRemaining--;
		}
		
		return strategyTableString; //TODO change to return the formatted String
	}	
	
	
	/**
	 * This updates the strategy table since a game was won.
	 * 
	 * The strategyTable has the set of actionRankings for each number of sticks
	 * left. The actionHistory array records the number of sticks the user took 
	 * when a given number of sticks remained on the table. Remember that 
	 * indexing starts at 0. For example, if actionHistory at index 6 is 2, 
	 * then the user took 2 sticks when there were 7 sticks remaining on the 
	 * table.  
	 * For each action noted in the history, this calls the 
	 * updateActionRankingOnWin method passing the corresponding action 
	 * and actionRanking. After calling this method, the actionHistory is
	 * cleared (all values set to 0).
	 * 
	 * @param strategyTable
	 *            An array of actionRankings.
	 * 
	 * @param actionHistory
	 *            An array where the index indicates the sticks left and the
	 *            element is the action that was made.
	 */
	static void updateStrategyTableOnWin(int[][] strategyTable, int[] actionHistory) {
		//TODO 
		
		for(int i=0; i < actionHistory.length; i++) {
			if (actionHistory[i] > 0) {
				strategyTable[i][actionHistory[i]-1] += 1;
			}
		}
		
		
		
		for(int i=0; i < actionHistory.length; i++) {
			actionHistory[i] = 0;
		}
	}
	
	/**
	 * This updates the strategy table for a loss.
	 * 
	 * The strategyTable has the set of actionRankings for each number of sticks
	 * left. The actionHistory array records the number of sticks the user took 
	 * when a given number of sticks remained on the table. Remember that 
	 * indexing starts at 0. For example, if actionHistory at index 6 is 2, 
	 * then the user took 2 sticks when there were 7 sticks remaining on the 
	 * table. 
	 * For each action noted in the history, this calls the 
	 * updateActionRankingOnLoss method passing the corresponding action 
	 * and actionRanking. After calling this method, the actionHistory is 
	 * cleared (all values set to 0).
	 * 
	 * @param strategyTable
	 *            An array of actionRankings.
	 * @param actionHistory
	 *            An array where the index indicates the sticks left and the
	 *            element is the action that was made.
	 */
	static void updateStrategyTableOnLoss(int[][] strategyTable, int[] actionHistory) {
		//TODO
		
		for(int i=0; i < actionHistory.length; i++) {
			if (actionHistory[i] > 0) {
				strategyTable[i][actionHistory[i]-1] -= 1;
			}
		}
		
		
		for(int i=0; i < actionHistory.length; i++) {
			actionHistory[i] = 0;
		}
	}	

	/**
	 * This method simulates a game between two players using their
	 * corresponding strategyTables. Use the aiChooseAction method
	 * to choose an action for each player. Record each player's 
	 * actions in their corresponding history array. 
	 * This method doesn't print out any of the actions being taken. 
	 * Player 1 should make the first move in the game.
	 * 
	 * @param startSticks
	 *            The number of sticks to start the game with.
	 * @param player1StrategyTable
	 *            An array of actionRankings.
	 * @param player1ActionHistory
	 *            An array for recording the actions that occur.
	 * @param player2StrategyTable
	 *            An array of actionRankings.
	 * @param player2ActionHistory
	 *            An array for recording the actions that occur.
	 * @return 1 or 2 indicating which player won the game.
	 */
	static int playAiVsAi(int startSticks, int[][] player1StrategyTable, 
			int[] player1ActionHistory, int[][] player2StrategyTable, 
			int[] player2ActionHistory) {
		
		int sticksRemaining = startSticks;
//		actionRanking
		
		while(sticksRemaining > 0) {
		// player 1
			// choose action
			int player1Choice = aiChooseAction(sticksRemaining, player1StrategyTable[sticksRemaining-1]);
			
			// update action history
			player1ActionHistory[sticksRemaining - 1] = player1Choice;
			sticksRemaining -= player1Choice;
			
			if(sticksRemaining <= 0) {
				// player 1 picked last stick
				return 2;
			}
				
		// player 2
			// choose action
			int player2Choice = aiChooseAction(sticksRemaining, player1StrategyTable[sticksRemaining-1]);
			
			// update action history
			player2ActionHistory[sticksRemaining - 1] = player2Choice;
			sticksRemaining -= player2Choice;
		}
		

		// exited loop - player 2 picked last stick
		return 1; //TODO change to return the winning player.
	}

	/**
	 * This method has the computer play against itself many times. Each time 
	 * it plays it records the history of its actions and uses those actions 
	 * to improve its strategy.
	 * 
	 * Algorithm: 
	 * 1) Create a strategy table for each of 2 players with 
	 *    createAndInitializeStrategyTable. 
	 * 2) Create an action history for each player.  An action history is a 
	 *    single dimension array of int. Each index in action history 
	 *    corresponds to the number of sticks remaining where the 0 index is
	 *    1 stick remaining.
	 * 3) For each game, 
	 * 		4) Call playAiVsAi with the return value indicating the winner. 
	 * 		5) Call updateStrategyTableOnWin for the winner and 
	 * 		6) Call updateStrategyTableOnLoss for the loser. 
	 * 7) After the games are played then the strategyTable for whichever 
	 * 	  strategy won the most games is returned. When both players win the 
	 *    same number of games, return the first player's strategy table.
	 * 
	 * @param startSticks
	 *            The number of sticks to start with.
	 * @param numberOfGamesToPlay
	 *            The number of games to play and learn from.
	 * @return A strategyTable that can be used to make action choices when
	 *         playing a person. Returns null if startSticks is less than
	 *         Config.MIN_STICKS or greater than Config.MAX_STICKS. Also returns
	 *         null if numberOfGamesToPlay is less than 1.
	 */
	static int[][] trainAi(int startSticks, int numberOfGamesToPlay) {
		if ((startSticks < Config.MIN_STICKS) || (startSticks > Config.MAX_STICKS)) {
			return null;
		}
		else if (numberOfGamesToPlay < 1) {
			return null;
		}
		
		int[][] player1StrategyTable = createAndInitializeStrategyTable(startSticks);
		int[][] player2StrategyTable = createAndInitializeStrategyTable(startSticks);
		
		int[] player1ActionHistory = new int[startSticks];
		int[] player2ActionHistory = new int[startSticks];
		
		int player1Wins = 0;
		int player2Wins = 0;
		
		for (int i = 0; i < numberOfGamesToPlay; i++) {
			
			int winner = playAiVsAi(startSticks, player1StrategyTable, 
				player1ActionHistory, player2StrategyTable, 
				player2ActionHistory);
			
			if (winner == 1) {
				player1Wins += 1;
				updateStrategyTableOnWin(player1StrategyTable, player1ActionHistory);
				updateStrategyTableOnLoss(player2StrategyTable, player2ActionHistory);
			}
			if (winner == 2) {
				player2Wins +=1;
				updateStrategyTableOnWin(player2StrategyTable, player2ActionHistory);
				updateStrategyTableOnLoss(player1StrategyTable, player1ActionHistory);
			}
		
		}
		
		//
		if (player1Wins > player2Wins) {
			return player1StrategyTable;
		}
		else if (player1Wins < player2Wins) {
			return player2StrategyTable;
		}
		else {
			return player1StrategyTable;
		}
		
		//TODO return the strategy table of the winning player
	}

}
