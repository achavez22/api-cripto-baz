package com.operpagos.apicriptobaz.domain.service;

import com.operpagos.apicriptobaz.domain.dto.RsaResponseDto;
import com.operpagos.apicriptobaz.domain.useCase.IRsaUseCase;
import com.operpagos.apicriptobaz.exception.DecryptException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Service
public class RsaServiceImpl implements IRsaUseCase {

    private static final String ALGORITHM_RSA = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    @Override
    public RsaResponseDto encrypt(String text, String publicKey) {
        try {
            Cipher rsa = Cipher.getInstance(ALGORITHM_RSA);
            rsa.init(Cipher.ENCRYPT_MODE, loadPublicKey(publicKey));
            byte[] encrypt = rsa.doFinal(text.getBytes(StandardCharsets.UTF_8));
            String response = Base64.encodeBase64String(encrypt);
            return new RsaResponseDto(response);
        } catch (Exception e) {
            throw new DecryptException(e.getMessage());
        }

    }

    @Override
    public RsaResponseDto decrypt(String text, String privateKey) {
        try {
            byte[] encrypted = Base64.decodeBase64(text);
            Cipher rsa = Cipher.getInstance(ALGORITHM_RSA);
            rsa.init(Cipher.DECRYPT_MODE, loadPrivateKey(privateKey));
            byte[] bytesDesencriptados = rsa.doFinal(encrypted);
            return new RsaResponseDto(new String(bytesDesencriptados).trim());
        } catch (Exception e) {
            throw new DecryptException(text);
        }
    }

    private PublicKey loadPublicKey(String base64PublicKey)
            throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
        PublicKey publicKey = null;
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64PublicKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    private PrivateKey loadPrivateKey(String base64PrivateKey) throws Exception {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
}
