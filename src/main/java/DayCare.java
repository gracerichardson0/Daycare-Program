/**
  Name: Nicholas Richardson
  Date: 11/6/2016
  Course/Section: IT 206.DL1
  Assignment: Programming Assignment 6
  
  Description:
  
  This program is designed to keep track of children in
  a daycare. Children are restricted to being within 3 and 11
  years old, and the child will be declined from being in the daycare.
  The application must store the information collected from the user input
  for each child, and there can be a maximum of 8 children in the daycare.
  The user will be asked first if the child they want to add is a tutored child
  or not. The user will be asked if they want to add another child, or to stop entering
  children. After either the maximum number of children is reached or the user wants to
  stop entering children, they will be shown a report with information for all users entered.
  
  
  
  Each child will require the following input, at a minimum:
  
  1. Child Name
  2. Child Age 
  3. Street Address 
  4. Phone Number
  5. Email Address
  6. Food Allergies 
  
  
  If a child is tutored, they will have all of the above inforamtion including:
    
  1. Grade Level 
  2. Number of Subjects
  
  Sometimes, a child can require extended care, which will be asked to the user.
  Having extended care, the number of days spent at the daycare, and number of subjects
  requiring tutoring will be factored into the total calculation for each child.
  
  The user will be shown information for all children entered, along with the total number of
  and average of children/tutored children after they have indicated they are done entering children,
  or the max has been reached, whichever comes first..
  
 */

import javax.swing.JOptionPane;
public class DayCare{
   public static void main(String[] args) {
      Child[] aChild = new Child[Child.MAX_CHILDREN];
      TutoredChild[] aTutoredChild = new TutoredChild[TutoredChild.MAX_CHILDREN];
      String isChildValid = "y";
      String enterAChild = "";
      String enterAnother = "y";
      String menu = "Welcome to the DayCare Program!"                    
                    +"\n\nEnter (1): Add a Child " 
                    +"\nEnter (2): Add a Tutored Child";
      
        do{
          do{
               enterAChild = JOptionPane.showInputDialog(menu);
               if(enterAChild.equals("1")){
               addChild(aChild);
               }
               
               if(!enterAChild.equals("1") && (!enterAChild.equals("2"))){
                  JOptionPane.showMessageDialog(null, "Error! Please enter 1 for a child, or 2 for a tutored child");
               }else if(enterAChild.equals("2")){
               addTutoredChild(aTutoredChild);
               }
            }while(!enterAChild.equals("1") && (!enterAChild.equals("2")));
          
         enterAnother = JOptionPane.showInputDialog("Do you want to enter another student? Enter Y for yes and N for no: ");
       }while(enterAnother.equalsIgnoreCase("y"));
         
        displayReport(aChild, aTutoredChild);
       JOptionPane.showMessageDialog(null, "Thank you for using the DayCare Program!");
   }  
     
    /*
    This method is used to add children to the array of children objects.
    If the number of children entered so far is less than the max, then the
    method will execute and the children will be able to have their information
    entered. If it is full, then a child object from the array will not be instantiated.
    If any invalid information is entered, then the user will be reprompted. Incorrect
    age or number of food allergies will cause the object (child) to be discarded.
    
    @param aChild the array of child objects
    
    
    */
     
    public static void addChild(Child[] aChild){
         int index = Child.getNumChildren();
         String childName = "";
         int childAge = 0;
         String validAge = "";
         String streetAddress = "";
         String phoneNumber = "";
         String emailAddress = "";
         int numFoodAllergies = 0;
         String foodAllergy = "";
         String extendedCare = "";
         int numDays = 0;
         boolean valid = false;
         boolean isValid = false;
         boolean isTrue = false;
         int flag = 0;
         
        /*
         This method continually prompts the user to enter the
         name, age, street address, phone number, email address,
         list of food allergies, and extended care for each child.
         Whenever an invalid input is entered, the user will be shown
         an error message and be prompted to re-enter until valid entry
         is achieved.
         
         @param aChild the child object created from the Child class,
         array of objects is passed.
        */
         
         if(index < aChild.length && (Child.getNumChildren() + TutoredChild.getNumTutored()) < Child.MAX_CHILDREN && (!valid)){
         
         /*
         A child object is created at the 
         position of index in the array.
         */
         aChild[index] = new Child();
         
      
            /*
            Continuously prompts the user to enter the
            child name until the name does not equal
            an empty string.
            */
            
            do{
               childName = JOptionPane.showInputDialog("Please enter the name of the child: ");
               if(!aChild[index].setChildName(childName)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid name for the child.");
               }
              }while(!aChild[index].setChildName(childName));
          
          /*
          Continuously prompts the user to enter the
          child age until it equals a non-number. If 
          the child is a number but above 11 or below 3,
          the child's information will be discarded.
          An error message will be shown whenever an invalid
          input is shown.
          */   
           
          do{
            try{
               childAge = Integer.parseInt(JOptionPane.showInputDialog("Please enter the age of the child between " + Child.MIN_AGE + " and " + Child.MAX_AGE + ": "));
               }catch(NumberFormatException e){
                  childAge=-1;
                  isValid=true;
               }
               if(childAge==-1){
                  JOptionPane.showMessageDialog(null, "Error: Child age must be an integer between " + Child.MIN_AGE + " and " + Child.MAX_AGE + ": ");
               }
               
               if(!aChild[index].setChildAge(childAge)){
                  JOptionPane.showMessageDialog(null, "Error! This child must be between " + Child.MIN_AGE + " and " + Child.MAX_AGE + "years old.");
               }else if(aChild[index].setChildAge(childAge)){
                  isValid=false;
               }          
            }while(isValid);               
              
            /*
            Continuously prompts the user to enter 
            the street addres for the child. If the
            street address is equal to an empty string,
            the user will be reprompted and shown an error message.
            */
            
            do{
               streetAddress = JOptionPane.showInputDialog("Please enter the street address: ");
               
               if(!aChild[index].setStreetAddress(streetAddress)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid street address.");
                }
            }while(!aChild[index].setStreetAddress(streetAddress));
            
            /*
            Continuously prompts the user to enter a phone number
            for the child until their phone number fulfills the
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */
            
            do{
               phoneNumber = JOptionPane.showInputDialog("Please enter the phone number in the form of (xxx)xxx-xxxx: ");
                  
                  if(!aChild[index].setPhoneNumber(phoneNumber)){
                     JOptionPane.showMessageDialog(null, "Error! Please enter a phone number in the form of (xxx)xxx-xxxx");
                  }
             }while(!aChild[index].setPhoneNumber(phoneNumber));
           
            /*
            Continuously prompts the user to enter an email address
            for the child until their email address fulfills the
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */
            
           do{
              emailAddress = JOptionPane.showInputDialog("Please enter the email address in the form of xxx@yyy.com : ");
              
              if(!aChild[index].setEmailAddress(emailAddress)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid email address in the form of xxx@yyy.com : ");
               }
            }while(!aChild[index].setEmailAddress(emailAddress));
           
           /*
            Continuously prompts the user to enter the number of food allergies
            for the child until their number fulfills the conditions provided
            to the user. An error message will be shown whenever the user
            enters an invalid input.
            */
          do{
            try{
               numFoodAllergies = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of food allergies: "));
               }catch(NumberFormatException e){
                  numFoodAllergies=-1;
                  isValid=true;
               }
               if(numFoodAllergies==-1){
                  JOptionPane.showMessageDialog(null, "Error: Number of food allergies must be between " + Child.MIN_NUM_ALLERGIES + " and " + Child.MAX_NUM_ALLERGIES+ ": ");
               }
               
               if(!aChild[index].setNumAllergies(numFoodAllergies)){
                  JOptionPane.showMessageDialog(null, "Error! This child can not have more than " + Child.MAX_NUM_ALLERGIES + " allergies.");
               }else if(aChild[index].setNumAllergies(numFoodAllergies)){
                  isValid=false;
               }          
            }while(isValid);
          
          
          
              
            int index2=0;


             /*
            Continuously prompts the user to enter a valid allergy
            (not an empty string) for the child for the amount they have specified for that child
            until they provide valid input. An error message will be shown
            whenever the user enters an invalid input.
            */
            
            while(index2 < aChild[index].getNumAllergies()){
               do{
                  foodAllergy = JOptionPane.showInputDialog(null, "Please enter your food allergies for your child: ");
                  if(!aChild[index].setFoodAllergies(foodAllergy)){
                     JOptionPane.showMessageDialog(null, "Error! Please enter a valid food allergy");
                  }
               }while(!aChild[index].setFoodAllergies(foodAllergy));
               
               index2++;
               
              }
               
            /*
            Continuously prompts the user to enter the number of days stayed
            at the daycare for the child until they enter a number within the maximum.
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */   
         
         
         do{
            try{
                numDays = Integer.parseInt(JOptionPane.showInputDialog("How many days is your child registering in the program? " 
                + "\nThe maximum is " + Child.MAX_DAYS + ": "));
               }catch(NumberFormatException e){
                  numDays = -1;
               }
               if(!aChild[index].setNumDays(numDays)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of days. ");
               }
           }while(!aChild[index].setNumDays(numDays));
           
            /*
            Continuously prompts the user to enter whether or not
            their child will require extended care.
            If the user enters invalid input, they will be 
            shown an error message and be reprompted.
            */
       
             do{
                extendedCare = JOptionPane.showInputDialog("Please enter Y if child needs extended care, or N if they do not.");
                if(!aChild[index].setExtendedCare(extendedCare)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter Y or N.");
                }
             }while(!aChild[index].setExtendedCare(extendedCare));
             
          /*
          If the child's age, or number of allergies is invalid,
          the child's information will be discarded and the child objects
          will all be shifted up by one in the array.
          */

         if(!aChild[index].setChildAge(childAge) || (!aChild[index].setNumAllergies(numFoodAllergies))){
            isValid=true;
            JOptionPane.showMessageDialog(null, "Sorry. Your child does not meet the requirements for age.");
            aChild[index] = aChild[index+1];
            Child.numChildren = Child.numChildren- 1;
            
         }
         
         
               
      }
           
      
   }
   
   
   /*
    This method is used to add children to the array of Tutored Children objects.
    If the number of children entered so far is less than the max, then the
    method will execute and the children will be able to have their information
    entered. If it is full, then a child object from the array will not be instantiated.
    If any invalid information is entered, then the user will be reprompted. Incorrect
    age or number of food allergies will cause the object (child) to be discarded.
    
    @param aTutoredChild the array of Tutored Child objects
    
    
    */
   
   public static void addTutoredChild(TutoredChild[] aTutoredChild){
         int index = Child.getNumChildren();
         String childName = "";
         int childAge = 0;
         String streetAddress = "";
         String phoneNumber = "";
         String emailAddress = "";
         int numFoodAllergies = 0;
         String foodAllergy = "";
         String extendedCare = "";
         int numDays = 0;
         int numSubjects= 0;
         int gradeLevel = 0;
         boolean valid = false;
         boolean isValid = false;
      
      
        /*
         This method continually prompts the user to enter the
         name, age, street address, phone number, email address,
         list of food allergies, and extended care for each child.
         Whenever an invalid input is entered, the user will be shown
         an error message and be prompted to re-enter until valid entry
         is achieved.
         
         @param aTutoredChild the child object created from the Child class,
         array of objects is passed.
        */
         
         if(index < aTutoredChild.length && (Child.getNumChildren() + TutoredChild.getNumTutored()) < Child.MAX_CHILDREN && (!valid)){
         
         /*
         A child object is created at the 
         position of index in the array.
         */
         aTutoredChild[index] = new TutoredChild();
         
      
            /*
            Continuously prompts the user to enter the
            child name until the name does not equal
            an empty string.
            */
            
            do{
               childName = JOptionPane.showInputDialog("Please enter the name of the child: ");
               if(!aTutoredChild[index].setChildName(childName)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid name for the child.");
               }
              }while(!aTutoredChild[index].setChildName(childName));
          
          /*
          Continuously prompts the user to enter the
          child age until it equals a non-number. If 
          the child is a number but above 11 or below 3,
          the child's information will be discarded.
          An error message will be shown whenever an invalid
          input is shown.
          */   
           
          do{
            try{
               childAge = Integer.parseInt(JOptionPane.showInputDialog("Please enter the age of the child between " + Child.MIN_AGE + " and " + Child.MAX_AGE + ": "));
               }catch(NumberFormatException e){
                  childAge=-1;
                  isValid=true;
               }
               if(childAge==-1){
                  JOptionPane.showMessageDialog(null, "Error: Child age must be an integer between " + Child.MIN_AGE + " and " + Child.MAX_AGE + ": ");
               }
               
               if(!aTutoredChild[index].setChildAge(childAge)){
                  JOptionPane.showMessageDialog(null, "Error! This child must be between " + Child.MIN_AGE + " and " + Child.MAX_AGE + ": ");
               }else if(aTutoredChild[index].setChildAge(childAge)){
                  isValid=false;
               }          
            }while(isValid);               
              
            /*
            Continuously prompts the user to enter 
            the street addres for the child. If the
            street address is equal to an empty string,
            the user will be reprompted and shown an error message.
            */
            
            do{
               streetAddress = JOptionPane.showInputDialog("Please enter the street address: ");
               
               if(!aTutoredChild[index].setStreetAddress(streetAddress)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid street address.");
                }
            }while(!aTutoredChild[index].setStreetAddress(streetAddress));
            
            /*
            Continuously prompts the user to enter a phone number
            for the child until their phone number fulfills the
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */
            
            do{
               phoneNumber = JOptionPane.showInputDialog("Please enter the phone number in the form of (xxx)xxx-xxxx: ");
                  
                  if(!aTutoredChild[index].setPhoneNumber(phoneNumber)){
                     JOptionPane.showMessageDialog(null, "Error! Please enter a phone number in the form of (xxx)xxx-xxxx");
                  }
             }while(!aTutoredChild[index].setPhoneNumber(phoneNumber));
           
            /*
            Continuously prompts the user to enter an email address
            for the child until their email address fulfills the
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */
            
           do{
              emailAddress = JOptionPane.showInputDialog("Please enter the email address in the form of xxx@yyy.com : ");
              
              if(!aTutoredChild[index].setEmailAddress(emailAddress)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid email address in the form of xxx@yyy.com : ");
               }
            }while(!aTutoredChild[index].setEmailAddress(emailAddress));
           
           /*
            Continuously prompts the user to enter the number of food allergies
            for the child until their number fulfills the conditions provided
            to the user. An error message will be shown whenever the user
            enters an invalid input.
            */
          do{
            try{
               numFoodAllergies = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of food allergies: "));
               }catch(NumberFormatException e){
                  numFoodAllergies=-1;
                  isValid=true;
               }
               if(numFoodAllergies==-1){
                  JOptionPane.showMessageDialog(null, "Error: Number of food allergies must be between " + Child.MIN_NUM_ALLERGIES + " and " + Child.MAX_NUM_ALLERGIES + ".");
               }
               
               if(!aTutoredChild[index].setNumAllergies(numFoodAllergies)){
                  JOptionPane.showMessageDialog(null, "Error! This child can not have more than " + Child.MAX_NUM_ALLERGIES + " allergies.");
               }else if(aTutoredChild[index].setNumAllergies(numFoodAllergies)){
                  isValid=false;
               }          
            }while(isValid);
          
          
          
              
            int index2=0;


             /*
            Continuously prompts the user to enter a valid allergy
            (not an empty string) for the child for the amount they have specified for that child
            until they provide valid input. An error message will be shown
            whenever the user enters an invalid input.
            */
            
            while(index2 < aTutoredChild[index].getNumAllergies()){
               do{
                  foodAllergy = JOptionPane.showInputDialog(null, "Please enter your food allergies for your child: ");
                  if(!aTutoredChild[index].setFoodAllergies(foodAllergy)){
                     JOptionPane.showMessageDialog(null, "Error! Please enter a valid food allergy");
                  }
               }while(!aTutoredChild[index].setFoodAllergies(foodAllergy));
               
               index2++;
               
              }
               
            /*
            Continuously prompts the user to enter the number of days stayed
            at the daycare for the child until they enter a number within the maximum.
            format that is provided to the user. An error message will be shown
            whenever the user enters an invalid input.
            */   
         
         
         do{
            try{
                numDays = Integer.parseInt(JOptionPane.showInputDialog("How many days is your child registering in the program? " 
                + "\nThe maximum is " + Child.MAX_DAYS + ": "));
               }catch(NumberFormatException e){
                  numDays = -1;
               }
               if(!aTutoredChild[index].setNumDays(numDays)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of days. ");
               }
           }while(!aTutoredChild[index].setNumDays(numDays));
           
            /*
            Continuously prompts the user to enter whether or not
            their child will require extended care.
            If the user enters invalid input, they will be 
            shown an error message and be reprompted.
            */
       
             do{
                extendedCare = JOptionPane.showInputDialog("Please enter Y if child needs extended care, or N if they do not.");
                if(!aTutoredChild[index].setExtendedCare(extendedCare)){
                  JOptionPane.showMessageDialog(null, "Error! Please enter Y or N.");
                }
             }while(!aTutoredChild[index].setExtendedCare(extendedCare));
             
        /*
         Continuously reprompts the user to enter their
        grade level for the child until they enter valid input
        within the conditions set. If the user enters invalid input,
        they will be shown an error message.
        */
        do{
         try{
             gradeLevel = Integer.parseInt(JOptionPane.showInputDialog("Please enter the grade level of the child: "));
            }catch(NumberFormatException e){
               gradeLevel = -1;
            }
            if(!aTutoredChild[index].setGradeLevel(gradeLevel)){
               JOptionPane.showMessageDialog(null, "Error! Please enter a valid grade level. ");
            }
       }while(!aTutoredChild[index].setGradeLevel(gradeLevel));
         /*
          Continuously reprompts the user to enter their
        number of subjects for the child until they enter valid input
        within the conditions set. If the user enters invalid input,
        they will be shown an error message.
        */     
        do{
         try{
             numSubjects = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of subjects for the child: "));
            }catch(NumberFormatException e){
               numSubjects = -1;
            }
            if(!aTutoredChild[index].setNumSubjects(numSubjects)){
               JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of subjects: ");
            }
         }while(!aTutoredChild[index].setNumSubjects(numSubjects));

         
        }else{
            JOptionPane.showMessageDialog(null, "The number of children in the daycare reached the limit.");
      }
      
      /*
       If the child's age, or number of allergies is invalid,
       the child's information will be discarded and the child objects
       will all be shifted up by one in the array.
     */ 
     if(!aTutoredChild[index].setChildAge(childAge) || (!aTutoredChild[index].setNumAllergies(numFoodAllergies))){
            isValid=true;
            JOptionPane.showMessageDialog(null, "Sorry. Your child does not meet the requirements for age.");
            aTutoredChild[index] = aTutoredChild[index+1];
            Child.numChildren = Child.numChildren- 1;
            
         }
   }
  
   /*
   Displays information about each child, tutored or otherwise,
   and also information about the children as a whole
   (total amount of children/tutored children, average cost per
   child/tutored child) only if the number of children entered +
   number of tutored children entered are greater than zero.
   
   @param aChild the child array of objects created from the Child class
   
   @param aTutoredChild the tutored child array of objects created from the
   of TutoredChild class
  
   */
   public static void displayReport(Child[] aChild, TutoredChild[] aTutoredChild){
     String output = "***Daycare Report***";
      double total = 0;
      double average = 0;
      
      double totalTutored = 0;
      double averageTutored = 0;
      
      
      /*
      If the number of children minus the number of tutored children
      is greater than zero, then the total for the non-tutored children
      will be incremented and have the average calculated.  
      */
      if(Child.getNumChildren() > 0){
         for(int i = 0; i < Child.getNumChildren(); i++){
            if(aChild[i] !=null){
               total+= aChild[i].calculateFee();
            }
         }
      }
       average = (total/Child.getNumChildren());
      
      /*
      If the number of tutored children  is greater than zero, 
      then the total for the non-tutored children
      will be incremented and have the average calculated.  
      */
           
     if(TutoredChild.getNumTutored() > 0){ 
       for(int j = 0; j < TutoredChild.getNumTutored(); j++){
         totalTutored+= aTutoredChild[j].calculateFee();
       }

     }
      
       averageTutored = (totalTutored/TutoredChild.getNumTutored());
       String childOutput = "";
       
       
      /*
      The string childOutput will have each child's information added
      to it if the number of children is greater than zero. 
      */
      
      if(Child.getNumChildren() - TutoredChild.getNumTutored() > 0){
      
            for(int i = 0; i < Child.getNumChildren(); i++){
               if(aChild[i] != null){
               childOutput+= "\n\n"+ aChild[i].toString();
               }
            }
           output+=childOutput; 
         }
      
       String tutoredOutput = "";
       
       /*
      The string childOutput will have each child's information added
      to it if the number of children is greater than zero. 
      */
      
       if(TutoredChild.getNumTutored() > 0){

            for(int k = 0; k < TutoredChild.getNumTutored(); k++){
               tutoredOutput+= "\n\n"+ aTutoredChild[k].toString();
            }
           output+=tutoredOutput;
         }
          
      output+= "\nNumber of children: " + Child.getNumChildren()
               + "\nNumber of tutored children: " + TutoredChild.getNumTutored()
               + "\nAverage cost per child: " + average
               + "\nAverage cost per tutored child: " + averageTutored;
      
      
      /*
      The user will be shown the output report if all
      conditions set are met. If the number of children is within the max and min
      amount of children allowed in the program, and that more than 0 children
      have been added to the program.
      */
      if((Child.getNumChildren() + TutoredChild.getNumTutored()) < 0 || (Child.getNumChildren() + TutoredChild.getNumTutored()) > Child.MAX_CHILDREN){
         JOptionPane.showMessageDialog(null, "No children found.");
      }else{
         JOptionPane.showMessageDialog(null, output);
      }
 
   }
 }