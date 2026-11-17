# Java Lab Sheet-07 (OOP Using Java) - MCA III Semester

Solutions for Lab Sheet-07: Exception Handling, Packages, and Multithreading.
Every program is a separate file and uses OOP concepts (classes, objects, encapsulation,
inheritance, interfaces, custom exceptions).

## Structure

```
01_exceptions/   Q01 - Q10   Exception handling
02_packages/     Q01 - Q10   Packages (Intermediate)
03_threads/      T01 - T10   Multithreading (Advance)
```

## How to compile and run

### 1. Exceptions
```bash
cd 01_exceptions
javac *.java
java Q01_DivideByZero
```

### 2. Packages
Package folders (`mypack`, `shapes`, `testpack`, ...) must stay inside `02_packages`.
```bash
cd 02_packages
javac $(find . -name "*.java")      # Windows PowerShell: javac (Get-ChildItem -Recurse -Filter *.java).FullName

java Q01_UseHello
java Q02_UseShapes
java Q03_TestAccess
java company.main.MainApp           # Q4
java Q05_AccessTest
java Q06_ImportVsFullName
java Q07_WildcardImport
java Q08_JavaUtilPackage
java Q09_UseMathUtils
java college.students.Main          # Q10
```

Q10 manual steps (as asked in the lab sheet):
```bash
javac -d . college/students/Student.java college/students/Main.java
java college.students.Main
```

### 3. Threads
```bash
cd 03_threads
javac *.java
java T01_ThreadExtend
```

## Index

| # | File | Topic |
|---|------|-------|
| E1 | 01_exceptions/Q01_DivideByZero.java | ArithmeticException, try-catch-finally |
| E2 | Q02_ArrayIndexOutOfBounds.java | ArrayIndexOutOfBoundsException |
| E3 | Q03_MultipleCatch.java | Multiple catch blocks |
| E4 | Q04_NestedTry.java | Nested try |
| E5 | Q05_FinallyBlock.java | finally always runs |
| E6 | Q06_ThrowKeyword.java | throw |
| E7 | Q07_CustomException.java | User-defined exception |
| E8 | Q08_ThrowsKeyword.java | throws |
| E9 | Q09_FinallyVsReturn.java | finally vs return |
| E10 | Q10_BankAccount.java | Custom + built-in exceptions |
| P1 | 02_packages/mypack/Hello.java, Q01_UseHello.java | Simple package |
| P2 | shapes/Circle.java, shapes/Rectangle.java, Q02_UseShapes.java | Multiple classes |
| P3 | testpack/*, Q03_TestAccess.java | Public vs default class |
| P4 | company/employees/Employee.java, company/main/MainApp.java | Subpackages |
| P5 | demo/AccessDemo.java, Q05_AccessTest.java | Access modifiers |
| P6 | animals/Dog.java, Q06_ImportVsFullName.java | import vs fully qualified name |
| P7 | mypackage/A,B,C.java, Q07_WildcardImport.java | Wildcard import |
| P8 | Q08_JavaUtilPackage.java | java.util (ArrayList, Scanner) |
| P9 | utils/MathUtils.java, Q09_UseMathUtils.java | Utility package |
| P10 | college/students/Student.java, Main.java | Command-line packaging |
| T1 | 03_threads/T01_ThreadExtend.java | Extend Thread |
| T2 | T02_RunnableInterface.java | Implement Runnable |
| T3 | T03_ThreadLifeCycle.java | Thread life cycle |
| T4 | T04_TwoThreadsNames.java | Two threads, scheduling |
| T5 | T05_ThreadPriority.java | Thread priorities |
| T6 | T06_ThreadSleep.java | sleep() |
| T7 | T07_ThreadJoin.java | join() |
| T8 | T08_UnsyncCounter.java | Race condition |
| T9 | T09_SyncCounter.java | synchronized |
| T10 | T10_RealLifeDownloader.java | Real-life multithreading |
