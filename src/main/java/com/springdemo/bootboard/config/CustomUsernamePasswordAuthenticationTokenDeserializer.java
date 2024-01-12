//package com.springdemo.bootboard.config;
//
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonNode;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import com.springdemo.bootboard.vo.MemberVO;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//public class CustomUsernamePasswordAuthenticationTokenDeserializer extends JsonDeserializer<UsernamePasswordAuthenticationToken> {
//
//    @Override
//    public UsernamePasswordAuthenticationToken deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//        JsonNode node = jp.getCodec().readTree(jp);
//
//        // Assuming you have a username and a list of roles in the JSON
//        String username = node.get("userName").asText(); // Ensure the field name matches what's in the JSON.
//
//        // Simulating the extraction of roles or authorities from the JSON
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (node.has("roles")) {
//            for (JsonNode roleNode : node.get("roles")) {
//                authorities.add(new SimpleGrantedAuthority(roleNode.asText())); // Ensure you extract the necessary info for a role
//            }
//        }
//
//        // Constructing the token. You might need to adjust null to actual credentials or other details depending on your JSON structure.
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
//        return token;
//    }
//}
