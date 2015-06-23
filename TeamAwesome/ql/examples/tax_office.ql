form taxOfficeExample { 

    question hasSoldHouse {
        "Did you sell a house in 2010?"
        boolean
    }

    // Get details of house sale 
    if (hasSoldHouse) {
        question sellingPrice {
            "What was the selling price?"
            money
        }

        question privateDebt {
            "Private debts for the sold house:"
            money
        }

        question valueResidue {
            "Value residue:"
            money = (sellingPrice - privateDebt)
        }
    }

    question hasBoughtHouse {
        "Did you buy a house in 2010?"
        boolean
    }

    question hasMaintLoan {
        "Did you enter a loan?"
        boolean
    }
}
