package com.test.project.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.entitymodels.Student;

public class CreateUsers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		Student sone = new Student();
		sone.setsName("Hazel Luckham");
		sone.setsEmail("hluckham0@google.ru");
		sone.setsPass("X1uZcoIh0djv");

		Student stwo = new Student();
		stwo.setsName("Sonnnie Bowden");
		stwo.setsEmail("sbowden1@yellowbook.com");
		stwo.setsPass("SJc4aWSU");

		Student sthree = new Student();
		sthree.setsName("Quillan Llorens");
		sthree.setsEmail("qllorens2@howstuffworks.com");
		sthree.setsPass("W6rJuxd");

		Student sfour = new Student();
		sfour.setsName("Clem Startin");
		sfour.setsEmail("cstartin3@flickr.com");
		sfour.setsPass("XYHzJ1S");

		Student sfive = new Student();
		sfive.setsName("Thornie Attwool");
		sfive.setsEmail("tattwool4@biglobe.ne.jp");
		sfive.setsPass("Hjt0SoVmuBz");

		Student ssix = new Student();
		ssix.setsName("Harcourt Guerre");
		ssix.setsEmail("hguerre5@deviantart.com");
		ssix.setsPass("OzcxzD1PGs");

		Student sseven = new Student();
		sseven.setsName("Holmes Taffley");
		sseven.setsEmail("htaffley6@columbia.edu");
		sseven.setsPass("xowtOQ");

		Student seight = new Student();
		seight.setsName("Alexandra Iannitti");
		seight.setsEmail("aiannitti7@is.gd");
		seight.setsPass("TWP4hf5j");

		Student snine = new Student();
		snine.setsName("Laryssa Jiroudek");
		snine.setsEmail("ljiroudek8@sitemeter.com");
		snine.setsPass("bXRoLUP");

		Student sten = new Student();
		sten.setsName("Cahra Jaulme");
		sten.setsEmail("cjaulme9@bing.com");
		sten.setsPass("FnVklVgC6r6");

		session.save(sone);
		session.save(stwo);
		session.save(sthree);
		session.save(sfour);
		session.save(sfive);
		session.save(ssix);
		session.save(sseven);
		session.save(seight);
		session.save(snine);
		session.save(sten);

		t.commit();
		System.out.println("successfully saved Users");
		factory.close();
		session.close();

	}
}
