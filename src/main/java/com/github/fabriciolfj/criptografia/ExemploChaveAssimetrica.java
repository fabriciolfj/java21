package com.github.fabriciolfj.criptografia;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.Scanner;

public class ExemploChaveAssimetrica {

    public static void main(String[] args) throws Exception {
        KeyPair keypair = generateRSAKKeyPair();

        // takes input from the keyboard
        Scanner message = new Scanner(System.in);
        System.out.print("Enter the message you want to encrypt using RSA: ");
        String plainText = message.nextLine();
        message.close();

        byte[] cipherText = encrypt(plainText, keypair.getPublic());

        System.out.print("The encrypted text is: ");

        System.out.println(HexFormat.of().formatHex(cipherText));

        String decryptedText = decrypt(cipherText, keypair.getPrivate());

        System.out.println("The decrypted text is: " + decryptedText);


        //na geração de uma assinatura digital usando chave privada para encryptar e chave publica para validar
        byte[] digitalSignature = generateDigitalSignature(cipherText, keypair.getPrivate());
        System.out.println("Signature Value: " + HexFormat.of().formatHex(digitalSignature));
        System.out.println("Verification: " + verify(cipherText, digitalSignature, keypair.getPublic()));


    }

    public static String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }

    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] generateDigitalSignature(byte[] plainText, PrivateKey privateKey) throws Exception   {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageHash = md.digest(plainText);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(messageHash);
    }

    public static boolean verify(byte[] plainText, byte[] digitalSignature, PublicKey publicKey) throws Exception  {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedMessage = md.digest(plainText);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decryptedMessageHash = cipher.doFinal(digitalSignature);

        return Arrays.equals(decryptedMessageHash, hashedMessage);
    }

    public static KeyPair generateRSAKKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072);
        return keyPairGenerator.generateKeyPair();
    }

}
