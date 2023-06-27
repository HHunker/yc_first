package com.example.e_commerce;


    public class Item {

        private String name;
        private double price;
        private boolean selected;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
            this.selected = false;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

