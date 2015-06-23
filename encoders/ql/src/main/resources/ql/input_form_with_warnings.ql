form taxOfficeExample { 
  "Did you sell a house in 2010?"
    hasSoldHouse: boolean
  "Did you buy a house in 2010?"
    hasBoughtHouse: boolean
  "Did you enter a loan?"
    hasMaintLoan: boolean
  "What is the percentage?"
    percentage: integer
  "What is the commissioning?"
    commissioning: integer
  "Do you have a contract?"
    hasContract: boolean
  "Do you have a contract?"
    hasContract2: boolean
    
  if (hasSoldHouse) {
    "What was the selling price?"
      sellingPrice: integer
    "Private debts for the sold house:"
      privateDebt: integer
    "Value residue:"
      valueResidue: integer = 
        (sellingPrice - privateDebt * ( percentage - commissioning ) )
  }
  
  
  if (hasContract && hasSoldHouse) {
    "How long do you have a contract?"
      yearContract: integer
    "How many times did you receive a temporary contract?"
      temporaryContract: integer
    "Employer followed rules according CAO:"
      rulesFollowed: boolean =
        yearContract >= temporaryContract 
  }
  
  if((10 > 5) && (6 < 7) || (2 >= 2) && !((4 + 3) <= 6) && ((4 / 2) == 2) && (6 != 7) && ((4 * 2) == 8) && true && ("this" != "that")) {
      "How long do you have a contract?"
      yearContract: integer
  }

}