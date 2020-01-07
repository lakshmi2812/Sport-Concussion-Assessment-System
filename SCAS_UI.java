import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SCAS_UI{

    private static final String filePath = "/Users/lakshmimaduri/Documents/MCS_PATHWAY_ASU/FALL2019_SESSIONB_CSE598/Projects/Sport_Concussion_Assessment_System/Athlete_symptom_data.ser";

    public void serializeAthlete(Athlete a1){
          try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(a1);
            objectOut.close();
            System.out.println("The Athlete object  was succesfully written to a file");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        SCAS_UI scas_ui = new SCAS_UI();

        System.out.println("Here are the names of all the athletes in the SCAS: ");
        SCAS scas = new SCAS();
        for(Athlete a : scas.athletes){
            System.out.println(a.name);
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Sport Concussion Assessment System!");
        System.out.println("Are you an Athlete or Sport Medical Practitioner? Please enter A if you are an athlete and S if you are a Medical Practitioner");
        String userType = scan.nextLine();
        //System.out.println("Are you a new user? Please type 'yes' or 'no' below:");
        
        //String newUser = scan.nextLine();

        //if user is 
        if(userType.equals("A")){
            Athlete a1 = scas.addAthlete();
            System.out.println("Please enter your symptoms for 5 games: ");
            a1.inputSymptoms();
            System.out.println("Here is the symptoms for 5 games: ");
            System.out.println(Arrays.deepToString(a1.symptomArray));
            a1.viewSymptomSummary();
        }else{
            scas.addPractitioner();
            System.out.println("Hi!");
        }
        // if(userType == "A"){
        //     if(newUser.equals("yes")){
        //         scas.addAthlete();
        //     }else{
        //         if(scas.athleteLogin()){
        //             System.out.println("You are successfully logged in!");
        //         }else{
        //             System.out.println("Invalid username!!!");
        //             System.out.println("Here are athletes' names: ");
        //             for(Athlete a : scas.athletes){
        //                 System.out.println("Another athlete:");
        //                 System.out.println(a.name);
        //             }
        //         }
        //     }
        // }else{
        //     if(newUser.equals("yes")){
        //         scas.addPractitioner();
        //     }else{
        //         if(scas.practitionerLogin()){
        //             System.out.println("You are successfully logged in!");
        //         }else{
        //             System.out.println("Invalid username!!!");
        //         }
        //     }
        // }
    }
}