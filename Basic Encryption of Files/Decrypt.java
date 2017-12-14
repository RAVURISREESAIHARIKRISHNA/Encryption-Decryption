import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;


public class Decrypt{
    public static void main(String[] args){
        String filePath = args[0];
        String filePassword = args[1];
        filePassword = filePassword + '@';
        String targetFileName="";
        String dummy = "_ced";
        boolean found = false;
        FileInputStream fis = null;
        FileOutputStream fout = null;
        for(int i=filePath.length()-1;i>=0;i--){
            if((filePath.charAt(i)=='\\'||filePath.charAt(i)=='/')&&!found){
                targetFileName = targetFileName+dummy;
                found = true;
            }
            targetFileName = targetFileName + Character.toString(filePath.charAt(i));
        }
        targetFileName = new StringBuilder(targetFileName).reverse().toString();
        try{
            fis = new FileInputStream(filePath);
        }catch(IOException e){
            System.out.println("File Does not exist OR File is not Accessible");
            System.out.println("Try Running again as Admin");
            System.exit(0);
        }
        try{
            fout = new FileOutputStream(new File(targetFileName),true);
        }catch(IOException e){
            System.out.println("Unable to Create Encrypted File!");
            System.exit(0);
        }
        int data;
        int i=0;
        System.out.println("Decrypting...\n");
        try{
            while((data = fis.read() )!=-1){
            data = data - (int)filePassword.charAt(i);
            
                fout.write((char)data);
            
            if(i==filePassword.length()-1){
                i=0;
                continue;
            }
            i++;
        }

        fis.close();
        fout.close();
        System.out.println("Success");
        
        }catch(Exception e){
            System.out.println("Internal Error");
            System.exit(0);
        }
    }//End of main()
}
