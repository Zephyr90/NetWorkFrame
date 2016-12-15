package com.zephyr.exercise2016_12_15_network_f;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */

public class ResponseBean {

    private List<PeopleBean> people;

    public List<PeopleBean> getPeople() {
        return people;
    }

    public void setPeople(List<PeopleBean> people) {
        this.people = people;
    }

    public static class PeopleBean {
        /**
         * firstName : Brett
         * lastName : McLaughlin
         * email : aaaa
         */

        private String firstName;
        private String lastName;
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
