FORM Questionnaire {
	myCheckbox "1. If you check this box, you'll get extra questions" choice
	if(myCheckbox) {
		ifBody1 "1a. If-statement please work" digits
		ifBody2 "1b. If-statement one more" digits
	}
	hasSoldHouse "2. How much did you get for your house?" digits
	amountHouses "3. How much did you pay for new house?" digits
	calculation "4. The difference between q#2 and q#3 equals to:" digits (hasSoldHouse -amountHouses)
	
	if(calculation > 100) {
		ifText "4a. Appears when calculation of q4 is bigger than 100" digits
			if(ifText == 6) {
			devilOne "4aa. Equality check worked in nested if" text
			}
	}
	
	extra "5. Above should appear if-question, when q#4 > 100." text
	if(hasSoldHouse > 1000) {
		ifelseIF "IF. Appears when question 2 value is bigger than 1000." text
	}
	else {
		ifelseELSE "ELSE. Default and when answer on q#2 is less than 1k." text
	}
		
} END