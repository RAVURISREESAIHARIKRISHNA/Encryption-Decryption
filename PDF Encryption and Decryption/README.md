# Encrypting PDF

```sh
$ javac EncryptPDF.java
$ java EncryptPDF File.pdf EncryptedFilePDFLocation.pdf PDFOwnerPASSWORD PDFUserPASSWORD
```

# Decrypting PDF

```sh
$ javac DecryptPDF.java
$ java DecryptPDF File.pdf DecryptedFilePDFLocation.pdf PDFOwnerPassword
```

## This uses Standard 256-bit Encryption

## Wrong Credentials WILL Produce Run-Time Errors.There are no Errors in Program.


This uses Apache PDF Box.

For more Operations and Required JARS(Compile after including these JARs in the Build Path),See

https://github.com/RAVURISREESAIHARIKRISHNA/JavaSE/tree/master/PDF%20Operations
