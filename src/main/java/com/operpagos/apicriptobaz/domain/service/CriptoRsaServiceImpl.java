package com.operpagos.apicriptobaz.domain.service;

import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.ICriptoRsaUseCase;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service

public class CriptoRsaServiceImpl implements ICriptoRsaUseCase {

    @Override
    public RsaResponseDto encrypt64(String text, String publicKey) throws Exception{
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey rsaPublicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);

        byte[] encryptedBytes = cipher.doFinal(text.getBytes());

        return new RsaResponseDto(Base64.getEncoder().encodeToString(encryptedBytes));
    }

    @Override
    public RsaResponseDto decrypt64(String text, String privateKey) throws Exception {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey rsaPrivateKey = keyFactory.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(text);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new RsaResponseDto(new String(decryptedBytes));
    }
}
