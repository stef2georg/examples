package com.epam.debugging;

import java.util.ArrayList;
import java.util.List;

public class BreakPointsMain {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                System.out.println("Op op op opa gangnam style!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }).start();

        List<Friend> friends = new ArrayList<>();

        friends.add(new Friend("Malina", 50));
        friends.add(new Friend("Andrea", 26));
        friends.add(new Friend("Maria", 40));
        friends.add(new Friend("Kilata", 30));

        for (Friend friend : friends) {
            String name = friend.getName();
            int age = friend.getAge();
            System.out.println(name + " " + age);
        }

        for (Friend friend : friends) {
            friend.sayR();
        }
    }

    private static class Friend {

        private String name;

        private int age;

        Friend(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void sayR() {
            if (name.equals("Kilata")) {
                throw new UnsupportedOperationException();
            }
        }
    }

}
