public class Child{

	public static final int MIN_NUM_ALLERGIES = 0;
	public static final int MAX_NUM_ALLERGIES = 7;
	public static final int MIN_AGE = 3;
	public static final int MAX_AGE = 11;
	public static final int MIN_DAYS = 0;
	public static final int MAX_DAYS = 5;
	public static final int MAX_CHILDREN = 8;
	public static final double FEE = 106.26;
	public static final double EXTENDED_CARE = 16.96;
	
	public static int numChildren = 0;
	public static int totalChildren=0;
	private String[] foodAllergies;
    private String foodAllergy;
    private String extendedCare;
	
	private String childName;
	private int childAge;
	private String streetAddress;
	private String emailAddress;
	private String phoneNumber;
    private String validAge;
	private int numAllergies;
	private int numDays;
	private double totalAmount;
	
   /*
   Increments the number of children (numChildren)
   each time that the constructor is instantiated.
   */
	public Child(){
		this.foodAllergies = new String[MAX_NUM_ALLERGIES];
		numChildren++;
	}
	
	public String getChildName(){
		return this.childName;
	}
	
	public int getChildAge(){
		return this.childAge;
	}
	
	public String getStreetAddress(){
		return this.streetAddress;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
   }
    
    public String getPhoneNumber(){
		return this.phoneNumber;
   }
    
    public int getNumAllergies(){
    	return this.numAllergies;
   }
    
    public int getNumDays(){
    	return this.numDays;
   }
   
    public String getValidAge(){
      return this.validAge;
   }
   
    public String[] getFoodAllergies() {
      String[] tempArray = new String[this.foodAllergies.length];
      for (int i = 0; i < this.foodAllergies.length; i++) {
         tempArray[i] = this.foodAllergies[i];
      }
      
      return tempArray;
   }
   
    public static int getNumChildren(){
    	return numChildren;
    }
    
    public static int getTotalChildren(){
      return totalChildren=numChildren;
    }
    
    public String getExtendedCare(){
      return this.extendedCare;
    }
    /*
      Validating mutator that sets the the variable
      extendedCare if the String is equal to Y or N.
      
      @param extendedCare the value which indicates
      if the child requires extended care or not
      
      @return a boolean true or false value
    
    */
    public boolean setExtendedCare(String extendedCare){
      if(extendedCare.equalsIgnoreCase("y") || extendedCare.equalsIgnoreCase("n")){
         this.extendedCare=extendedCare;
         return true;
      }else{
         return false;
      }
    }
    
   
     
    public boolean setChildName(String childName){
    	if(!childName.equalsIgnoreCase("")){
    		this.childName=childName;
    		return true;
        }else{
        	return false;
        }
    }
    
    public boolean setChildAge(int childAge){
      if(childAge>=MIN_AGE && childAge<=MAX_AGE){
    		this.childAge=childAge;
    		return true;
    	}else{
    		return false;
        }
    }
      
    
    public boolean setStreetAddress(String streetAddress){
    	if(!streetAddress.equalsIgnoreCase("")){
    		this.streetAddress=streetAddress;
    		return true;
    	}else{
    		return false;
    	}
    }
    
     /*
      Validating mutator that sets the the variable
      emailAddress if the String fulfills a number
      of different conditions. First, the algorithm
      checks if the email has an @ sign in it, then
      proceeds to check how many characters are to the left and right
      of the @ sign.
      
      @param emailAddress the email address that is tied
      to the child
      
      @return a boolean true or false value
    
    */

      public boolean setEmailAddress(String emailAddress){
         final int MAX_NUM_LETTERS= 4;
         final int MIN_NUM_LETTERS= 2;
         int position = 0;
         int newPosition = 0;
         int period = 0;
         boolean valid = false;
         position = emailAddress.indexOf("@");
     
      /*Checks that the position is not the last character and that the position 
        is greater than zero before continuing with the rest of the validation
      */
      if(position>0 && position < emailAddress.length()-1){
          String emailAddressTwo= emailAddress.substring(position-1, position+1);
          
            newPosition = emailAddressTwo.indexOf("@");
            
          if(Character.isLetterOrDigit(emailAddressTwo.charAt(newPosition-1)) && 
             Character.isLetterOrDigit(emailAddress.charAt(newPosition+1))){
               valid = true;
               
               period = emailAddress.indexOf(".");
               
               String newPeriod = emailAddress.substring(period);
               
               if(newPeriod.length() >= MIN_NUM_LETTERS && newPeriod.length() <= MAX_NUM_LETTERS){
                  valid = true;
               }
              }
             }
               if(valid){
                  this.emailAddress=emailAddress;
                  return true;
               }else{
                  return false;
               }
        }     
    /*
      Validating mutator that sets the the variable
      phoneNumber if the String fulfills a number
      of different conditions. First, the algorithm
      checks if the phone number is in the form of xxxxxxxxxx or
      (xxx)xxx-xxxx, then proceeds to check if there are only digits
      entered for the phone number.
            
      @param phoneNumber the phone number that is tied
      to the child
      
      @return a boolean true or false value
    
    */       			
    public boolean setPhoneNumber(String phoneNumber){
     final int MIN_NUM_DIGITS=10;
     final int MAX_NUM_DIGITS=13;
     boolean valid = true;
     String temp = phoneNumber;
     
     
     temp= phoneNumber.replace("-", "");
     temp= phoneNumber.replace(")", "");
     temp= phoneNumber.replace("(", "");
     
     if(temp.length()== MAX_NUM_DIGITS || temp.length() == MIN_NUM_DIGITS){
      for(int i = 0; i<temp.length(); i++){
         if(!Character.isDigit(temp.charAt(i))){
            valid=false;
            break;
         }
      }
     }
       if(valid){
         this.phoneNumber=temp;
         return true;
      }else{
         return false;
      }
    }
    
    
    public boolean setNumDays(int numDays){
    	if(numDays>=MIN_DAYS && numDays <= MAX_DAYS){
    		this.numDays=numDays;
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean setNumAllergies(int numAllergies){
      if(numAllergies>MIN_NUM_ALLERGIES && numAllergies <=MAX_NUM_ALLERGIES){
         this.numAllergies=numAllergies;
         return true;
      }else{
         return false;
      }
    }
    
    /*
      Validating mutator that sets the the variable
      foodAllergy in the array if the String is not
      empty.
            
      @param foodAllergy the individual
      food allergy that the child has
      
      
      @return a boolean true or false value
    
    */
    
    public boolean setFoodAllergies(String foodAllergy) {
      boolean valid = true;
      for (int i = 0; i < this.getNumAllergies(); i++) {
         if(!foodAllergy.equals("")){
            this.foodAllergies[i] = foodAllergy;
            valid=true;
          }
      }
      if(valid){
         return true;
      }else{
         return false;
      }      
    }
    
    public void setTotalAmount(double totalAmount){
      this.totalAmount=totalAmount;
    }
    
    public static void setNumChildren(int numChildren){
      numChildren=numChildren;
    }
    

    /*
      Special purpose method that calculates the cost for a child.
      If a child requires extended care, they will cost more per day.
      Otherwise, the program will multiply the number of days times the fee.
      
       
      @return total the total amount per child
    
    */
    public double calculateFee(){
     double total = 0.0;
      if(this.getExtendedCare().equalsIgnoreCase("y")){
        total = ((this.getNumDays() * FEE) + this.getNumDays() * Child.EXTENDED_CARE);
      }else{
        total = ((this.getNumDays() * FEE));
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
            listOfAllergies += (i+1) + ") " + this.foodAllergies[i] + "\n";
         }
      }
      else {
         listOfAllergies += "No Allergies Entered!";
      }
     
      return "\nChild Name: " + this.getChildName() + 
             "\nAge: " + this.getChildAge() +
             "\nNumber of days: " + this.getNumDays() +
             "\nStreet Address: " + this.getStreetAddress() + 
             "\nPhone Number: " + this.getPhoneNumber() + 
             "\nEmail Address: " + this.getEmailAddress() + 
             "\nNumber of Allergies: " + this.getNumAllergies() +
             "\nFood Allergies: " + listOfAllergies +
             "\nExtended Care: " + this.getExtendedCare();
             
      }
}      
    		
    	
		
	