form taxOfficeExample { 
  question "Did you sell a house in 2010?" hasSoldHouse : Boolean
  question "Did you buy a house in 2010?"  hasBoughtHouse : Boolean
  question "Did you enter a loan?" hasMaintLoan : Boolean
  question "How much was the loan?" loanValue : Number
  question "Why did you take the loan?" loanDescription : String
  question "Did you buy AND sell a house in 2010?" boughtAndSold: Boolean = hasSoldHouse && hasBoughtHouse 
  if hasSoldHouse == true && hasBoughtHouse then question "Sold and Bought?" hasTest1: Boolean end
  if hasSoldHouse then question "Sold?" hasTest2: Boolean end  
  if hasBoughtHouse then question "Bought?" hasTest3: Boolean end
  if loanValue > -1 then question "Ping " ping: Boolean end
}