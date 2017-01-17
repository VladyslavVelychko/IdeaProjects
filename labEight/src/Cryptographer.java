import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Cryptographer {

    private char keySymbol;
    private String encryptedFile;
    private static final String fileExtension = ".crpt";

    public Cryptographer(String encryptedFile) {
        setRandomKeySymbol();
        setEncryptedFile(encryptedFile);
    }

    public Cryptographer(String encryptedFile, char keySymbol) {
        this.keySymbol = keySymbol;
        setEncryptedFile(encryptedFile);
    }

    public char getKeySymbol() {
        return keySymbol;
    }

    public void setRandomKeySymbol(){
        Random r = new Random();
        this.keySymbol =  (char)(r.nextInt(26) + 'a');
    }

    public void setKeySymbol(char keySymbol) {
        this.keySymbol = keySymbol;
    }

    public void setEncryptedFile(String encryptedFile){
        this.encryptedFile = (isContainExtension(encryptedFile))? encryptedFile : encryptedFile + fileExtension;
    }

    public boolean isContainExtension(String encryptedFile){
        return encryptedFile.endsWith(fileExtension) && encryptedFile.length() > fileExtension.length();
    }

    public  void encrypt(String dataFile) {
        Encryptor encryptor = null;
        FileOutputStream fileOutputStream = null;

        try {
            encryptor = new Encryptor(new FileInputStream(dataFile), this.keySymbol);
            fileOutputStream = new FileOutputStream(this.encryptedFile);

            while (encryptor.available() > 0) {
                int buf = encryptor.read();
                fileOutputStream.write(buf);
            }

            encryptor.close();
            fileOutputStream.close();

            System.out.println(dataFile + " is encrypted into " + this.encryptedFile);

        } catch (IOException e){
            System.out.println("There is no such file");
        } finally {
            try {
                if (encryptor != null)encryptor.close();
                if (fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {

            }
        }
    }


    public  void decrypt(String decryptedFile){
        FileInputStream fileInputStream = null;
        Decryptor decryptor = null;

        try {
            fileInputStream = new FileInputStream(this.encryptedFile);
            decryptor = new Decryptor(new FileOutputStream(decryptedFile), this.keySymbol);

            while (fileInputStream.available() > 0) {
                int buf = fileInputStream.read();
                decryptor.write(buf);
            }

            fileInputStream.close();
            decryptor.close();

            System.out.println(this.encryptedFile + " is decrypted into " + decryptedFile);

        } catch (IOException e){
            System.out.println("There is no such file");
        }finally {
            try {
                if (fileInputStream != null)fileInputStream.close();
                if (decryptor != null) decryptor.close();
            } catch (IOException e) {

            }
        }
    }

    public  void decrypt(String decryptedFile, String encryptedFile){
        if (isContainExtension(encryptedFile)) {
            setEncryptedFile(encryptedFile);
            decrypt(decryptedFile);
        } else {
            System.out.println("This file type is not allowed");
        }
    }

}