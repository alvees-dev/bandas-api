package br.com.magna.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.com.magna.model.Usuarios;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	public String gerarToken(Usuarios usuario) {

		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("Bandas-API")
					.withSubject(usuario.getLogin())
					.withExpiresAt(dataExpiracao())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token JWT", exception);
		}

	}

	public String getSubject(String tokenJWT) {

		try {
			var algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("Bandas-API")
					.build()
					.verify(tokenJWT)
					.getSubject();
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Token JWT inválido ou expirado", exception);
		}

	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
