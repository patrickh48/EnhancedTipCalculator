# Enhanced Tip Calculator

A simple and enhanced **Employee Management System** with salary and tax calculations, built using **Java** and **JavaFX**. This application allows users to manage different types of employees—Salary, Commission, and Base + Commission—and see their salary breakdown, insurance deductions, and taxes.

## Features

- Add and delete employees via a user-friendly GUI
- Select employee type and insurance plan
- Automatically calculates:
  - Total salary
  - FICA (Social Security & Medicare)
  - Federal and state tax withholdings
  - Medical insurance cost
- Displays a detailed tax and deduction summary
- Defaults to **PPO** insurance if none is selected

## Technologies Used

- Java
- JavaFX (FXML for UI layout)
- Object-Oriented Programming (OOP)

## Employee Types

- **SalaryEmployee** – Fixed yearly income
- **CommissionEmployee** – Paid by commission only
- **BaseCommissionEmployee** – Paid by base salary + commission

## Deductions Breakdown

| Type                  | Rate / Rule                                |
|-----------------------|---------------------------------------------|
| FICA Social Security | 6.2% up to $132,000                          |
| FICA Medicare        | 1.45% of total salary                       |
| SUTA (State Tax)     | 1% up to $28,000                            |
| Federal Tax          | 0.6% (capped at $280,000)                   |
| Medical Insurance    | HSA: $400, HMO: $427, PPO: $517 (monthly)  |

## How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/enhanced-tip-calculator.git
   cd enhanced-tip-calculator
