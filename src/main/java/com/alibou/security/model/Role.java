package com.alibou.security.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.List;

@Entity
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Role implements GrantedAuthority {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer id;

  @Column(unique = true)
  @NonNull
  @Getter
  @Enumerated(EnumType.STRING)
  private RoleEnum name;

  @Override
  public String getAuthority() {
    return name.toString();
  }

}
