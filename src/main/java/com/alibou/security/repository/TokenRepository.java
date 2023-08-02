package com.alibou.security.repository;

import java.util.List;
import java.util.Optional;

import com.alibou.security.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  List<Token> findAllByUserIdAndAndExpiredIsFalseAndRevokedIsFalse(Integer userId);

  Optional<Token> findByToken(String token);
}
