//package com.example.todobackend.database.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "itemDependency")
//public class ItemDependency {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @OneToMany(cascade = CascadeType.ALL,
//            mappedBy = "depententItem", orphanRemoval = true)
//    private Item item;
//
//    @ManyToOne
//    private Item depententItem;
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//
//    public Item getDepententItem() {
//        return depententItem;
//    }
//
//    public void setDepententItem(Item depententItem) {
//        this.depententItem = depententItem;
//    }
//}
