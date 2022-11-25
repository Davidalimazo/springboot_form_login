package com.formsecurity.formsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    @Data
    @NoArgsConstructor
public class UserModel {

        @Column(nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        public UserModel(String username, String password, boolean active, String roles, String permissions) {
            this.username = username;
            this.password = password;
            this.active = active;
            this.roles = roles;
            this.permissions = permissions;
        }

        private boolean active = true;

        private String roles;

        private String permissions;


        public List<String> getRoleList(){
            if(this.roles.length() > 0){
                return Arrays.asList(this.roles.split(","));
            }
            return new ArrayList<>();
        }

        public List<String> getPermissionList(){
            if(this.permissions.length() > 0){
                return Arrays.asList(this.permissions.split(","));
            }
            return new ArrayList<>();
        }
        public boolean getActive(){
            return active;
        }

    }
