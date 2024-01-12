//package com.springdemo.bootboard.config;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class SecurityContextImpl {
//    public void demonstrateSecurityContext() {
//        // 사용자 이름, 비밀번호, 권한을 가지는 Authentication 객체를 생성합니다.
//        Authentication auth = new UsernamePasswordAuthenticationToken("user", "password", AuthorityUtils.createAuthorityList("ROLE_USER"));
//
//        // SecurityContext를 생성하고 Authentication 객체를 설정합니다.
//        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
//        securityContext.setAuthentication(auth);
//
//        // SecurityContext를 SecurityContextHolder에 저장합니다. (일반적으로는 스레드 로컬에 저장됩니다.)
//        SecurityContextHolder.setContext(securityContext);
//
//        // 나중에 필요할 때 SecurityContext에서 Authentication 객체를 조회할 수 있습니다.
//        Authentication retrievedAuth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("Authenticated user: " + retrievedAuth.getName());
//        System.out.println("User has authorities: " + retrievedAuth.getAuthorities());
//    }
//}
