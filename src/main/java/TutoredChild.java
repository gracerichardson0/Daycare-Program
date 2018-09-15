public class TutoredChild extends Child {
   public static final double SUBJECT_SURCHARGE = 12.0;
   public static final double MIN_NUM_SUBJECTS = 0.0;
   public static final double MIN_GRADE_LEVEL = 0.0;
   public static final double MAX_GRADE_LEVEL = 12.0;
   public static int numTutored = 0;
   private String[] foodAllergies;
   
   private int numSubjects;
   private int gradeLevel;
   
   /*
   Increments the number of tutored children (numTutored)
   each time that the constructor is instantiated.
   */

   public TutoredChild(){
	   this.foodAllergies = new String[MAX_NUM_ALLERGIES];
      numTutored++;
   }
   
   public static int getNumTutored(){
    	return numTutored;
   }

   public int getNumSubjects(){
      return this.numSubjects;
   }
   
   public int getGradeLevel(){
      return this.gradeLevel;
   }
   
   public boolean setNumSubjects(int numSubjects){
      if(numSubjects> MIN_NUM_SUBJECTS){
         this.numSubjects=numSubjects;
         return true;
      }else{
         return false;
      }
   }
   
   public boolean setGradeLevel(int gradeLevel){
      if(gradeLevel>MIN_GRADE_LEVEL && gradeLevel<MAX_GRADE_LEVEL){
         this.gradeLevel=gradeLevel;
         return true;
      }else{
         return false;
      }
   }
   
   /*
      Special purpose method that calculates the cost for a tutored child.
      If a tutored child requires extended care, they will cost more per day.
      Otherwise, the program will multiply the number of days times the fee and
      also multiply the number of subjects they are tutored in by the surcharge.
      
       
      @return total the total amount per child
    
    */

   public double calculateFee(){
     double total = 0.0;
      if(this.getExtendedCare().equalsIgnoreCase("y")){
        total = ((this.getNumDays() * FEE) + this.getNumDays() * Child.EXTENDED_CARE + (this.getNumSubjects() * TutoredChild.SUBJECT_SURCHARGE));
      }else{
        total = (this.getNumDays() * FEE + (this.getNumSubjects() * TutoredChild.SUBJECT_SURCHARGE));
      }
      
       return total;
    }
    
   /**
     Returns a string representation of the current object
     and returns information about the child
   
     @return the information about the child
   
   */
    
   public String toString(){
      String listOfAllergies = "";
         if (this.getNumAllergies() > 0) {
         for (int i = 0; i < this.getNumAllergies(); i++) {
            listOfAllergies += (i+1) + ") " + this.getFoodAllergies()[i] + "\n";
         }
      }
      else {
         listOfAllergies += "No Allergies Entered!";
      }
     
      return "\nTutored Child Name: " + this.getChildName() + 
             "\nAge: " + this.getChildAge() +
             "\nNumber of days: " + this.getNumDays() +
             "\nStreet Address: " + this.getStreetAddress() + 
             "\nPhone Number: " + this.getPhoneNumber() + 
             "\nEmail Address: " + this.getEmailAddress() + 
             "\nFood Allergies: " + listOfAllergies +
             "\nNumber of Subjects: " + this.getNumSubjects() +
             "\nGrade Level: " + this.getGradeLevel() + 
             "\nExtended Care: " + this.getExtendedCare();
             
      }
     }