package demo;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class DecryptPDF {
	public static void main(String[] args) throws IOException{
		File my_file = new File(args[0]);
		PDDocument document = PDDocument.load(my_file,args[2]);
		AccessPermission permission = new AccessPermission();
		permission.setCanPrint(false);
		
		StandardProtectionPolicy spp = new StandardProtectionPolicy("","",permission);
		spp.setEncryptionKeyLength(256);
		spp.setPermissions(permission);
		document.protect(spp);
		document.save(args[1]);
		document.close();
		System.out.println("Decrypted....");
	}
}
