# JavaFX Final Year Module Chooser GUI - MVC pattern

## Objectives

Design and implement an OO system consisting of a set of Java classes, using advanced libraries within the Java SDK.

* Data models
* An user interface using JavaFX 8 libraries.
* Event handling provide a basis for an interactive and user-friendly system.
* Adhere to standard principles of the Model-View-Controller (MVC) design pattern and appropriately decompose classes through abstraction and encapsulation.

## GUI specification

A student profile captures the details of an individual second year undergraduate computing student and allows them to select their final year module options. There are compulsory modules that must be selected (depending on the course of study), and others that are only associated with certain courses. Modules either run in term 1 or 2, or all year long.

Build an interactive graphical user interface (GUI) that dynamically allows modules to be selected based on the chosen course of study, and then stores this information. The application should be user-friendly and contain appropriate validation to ensure only a legitimate selection of modules is made.

For this prototype, only required to use the data of two courses, Computer Science and Software Engineering. However, the system is designed such that it would be relatively simple to add further courses and modules in the future.

Computer Science students have 45 compulsory credits, whereas Software Engineering students have 60 compulsory credits. Computer Science students can exclusively study IMAT3428. 

In total 120 credits must be selected via any legitimate combination of modules, but crucially you may only select 60 credits per term. The yearlong module IMAT3451 contributes towards 15 credits in each term.

As an example, a Computer Science student would have by default 30 credits selected in term 1 and 15 credits in term 2 due to the mandatory nature of IMAT3423 and IMAT3451. This would mean they would need to select a further 30 credits of term 1 modules, and a further 45 credits in term 2. A Software Engineering student would be similar, but would additionally have the mandatory module CTEC3902 in term 2, therefore requiring an additional 30 credits worth of modules to be chosen in both term 1 and term 2.
