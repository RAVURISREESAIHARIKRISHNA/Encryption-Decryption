package demo;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class EncryptPDF {
	public static void main(String[] args) throws IOException{
		File my_file = new File(args[0]);
		PDDocument document = PDDocument.load(my_file);
		
		AccessPermission permission = new AccessPermission();
		permission.setCanPrint(true);
		
		StandardProtectionPolicy spp = new StandardProtectionPolicy(args[2],args[3],permission);
		spp.setEncryptionKeyLength(256);
		spp.setPermissions(permission);
		document.protect(spp);
		document.save(args[1]);
		document.close();
		System.out.println("Encrypted....");
	}
}
