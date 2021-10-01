# Checkout Kata

## Prototype

An initial prototype has been prepared that meets the below specifications.
During the interview you'll be asked to extend and improve upon the initial implementation.

## Task

This code implements a supermarket checkout that scans one item at a time and calculates the total price. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store, we use individual letters of the alphabet (A, B, C, and so on as the SKUs). Our goods are priced individually.

This week’s prices are:

| Item | Unit Price | 
|------|------------|
| A    | 50         | 
| B    | 30         | 
| C    | 20         | 
| D    | 15         | 

Our checkout accepts items in any order. Because the pricing changes frequently, we pass in a set of pricing rules each time we start handling a checkout transaction.


