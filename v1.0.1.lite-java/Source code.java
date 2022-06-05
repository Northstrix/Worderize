/*
Worderize Lite
Distributed under the MIT License
© Copyright Maxim Bortnikov 2022
For more information please visit
https://github.com/Northstrix/Worderize
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;

class Worderize_main
	extends JFrame{
	
	public Container c;
	public static JLabel l1;
	public static JLabel l2;
	public static JLabel l3;
	public static JLabel w11;
	public static JLabel w12;
	public static JLabel w13;
	public static JLabel w21;
	public static JLabel w22;
	public static JLabel w23;
	public static JLabel w31;
	public static JLabel w32;
	public static JLabel w33;
	public static TextField tl1;
	public static TextField tl2;
	public static TextField tl3;
	public static TextField tw11;
	public static TextField tw12;
	public static TextField tw13;
	public static TextField tw21;
	public static TextField tw22;
	public static TextField tw23;
	public static TextField tw31;
	public static TextField tw32;
	public static TextField tw33;
	public static JLabel q1;
	public static JLabel q2;
	public static JLabel q3;
	public static JLabel q4;
	public static JLabel q5;
	public static JLabel q6;
	public static JLabel q7;
	public static JLabel q8;
	public static JLabel q9;
	public static JLabel q10;
	public static JLabel q11;
	public static JLabel q12;
	public JMenuBar menu_b;
	public JMenu rcrd;
	public JButton abt;
	public JButton cls;
	public JMenuItem add, dlt, vw, vw_r;
	static Color black_cl = new Color(31, 31, 34);
	static Color bclr = new Color(1, 98, 82);
	static Color gclr = new Color(57, 196, 248);
	static Color rclr = new Color(201, 44, 246);
	static Color frclr = new Color(238, 238, 238);

	public Worderize_main()
	{
		setTitle("Worderize Lite");
		setBounds(300, 90, 858, 222);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		c = getContentPane();
		c.setLayout(null);
		
		menu_b = new JMenuBar();
		rcrd = new JMenu("  Record  ");
		add = new JMenuItem("Add");
		dlt = new JMenuItem("Delete  ");
		vw = new JMenuItem("View");
		vw_r = new JMenuItem("View Random");
		abt = new JButton("About");
		cls = new JButton("Quit");
		rcrd.add(add);
		rcrd.add(dlt);
		rcrd.add(vw);
		rcrd.add(vw_r);
		menu_b.add(rcrd);
		menu_b.add(abt);
		menu_b.add(cls);
		setJMenuBar(menu_b); 

		l1 = new JLabel("",SwingConstants.CENTER);
		l1.setFont(new Font("Arial", Font.PLAIN, 18));
		l1.setSize(260, 20);
		l1.setLocation(15, 18);
		c.add(l1);
		
		l2 = new JLabel("", SwingConstants.CENTER);
		l2.setFont(new Font("Arial", Font.PLAIN, 18));
		l2.setSize(260, 20);
		l2.setLocation(290, 18);
		c.add(l2);
		
		l3 = new JLabel("", SwingConstants.CENTER);
		l3.setFont(new Font("Arial", Font.PLAIN, 18));
		l3.setSize(260, 20);
		l3.setLocation(565, 18);
		c.add(l3);
		
		w11 = new JLabel("",SwingConstants.CENTER);
		w11.setFont(new Font("Arial", Font.PLAIN, 18));
		w11.setSize(260, 20);
		w11.setLocation(15, 55);
		c.add(w11);
		
		w12 = new JLabel("", SwingConstants.CENTER);
		w12.setFont(new Font("Arial", Font.PLAIN, 18));
		w12.setSize(260, 20);
		w12.setLocation(290, 55);
		c.add(w12);
		
		w13 = new JLabel("", SwingConstants.CENTER);
		w13.setFont(new Font("Arial", Font.PLAIN, 18));
		w13.setSize(260, 20);
		w13.setLocation(565, 55);
		c.add(w13);
		
		w21 = new JLabel("",SwingConstants.CENTER);
		w21.setFont(new Font("Arial", Font.PLAIN, 18));
		w21.setSize(260, 20);
		w21.setLocation(15, 85);
		c.add(w21);
		
		w22 = new JLabel("", SwingConstants.CENTER);
		w22.setFont(new Font("Arial", Font.PLAIN, 18));
		w22.setSize(260, 20);
		w22.setLocation(290, 85);
		c.add(w22);
		
		w23 = new JLabel("", SwingConstants.CENTER);
		w23.setFont(new Font("Arial", Font.PLAIN, 18));
		w23.setSize(260, 20);
		w23.setLocation(565, 85);
		c.add(w23);

		w31 = new JLabel("",SwingConstants.CENTER);
		w31.setFont(new Font("Arial", Font.PLAIN, 18));
		w31.setSize(260, 20);
		w31.setLocation(15, 115);
		c.add(w31);
		
		w32 = new JLabel("", SwingConstants.CENTER);
		w32.setFont(new Font("Arial", Font.PLAIN, 18));
		w32.setSize(260, 20);
		w32.setLocation(290, 115);
		c.add(w32);
		
		w33 = new JLabel("", SwingConstants.CENTER);
		w33.setFont(new Font("Arial", Font.PLAIN, 18));
		w33.setSize(260, 20);
		w33.setLocation(565, 115);
		c.add(w33);

		c.setBackground(bclr);
		menu_b.setBackground(black_cl);
		rcrd.setForeground(frclr);
		abt.setForeground(frclr);
		cls.setForeground(frclr);
		abt.setBackground(black_cl);
		cls.setBackground(black_cl);
		add.setBackground(black_cl);
		dlt.setBackground(black_cl);
		vw.setBackground(black_cl);
		vw_r.setBackground(black_cl);
		add.setForeground(frclr);
		dlt.setForeground(frclr);
		vw.setForeground(frclr);
		vw_r.setForeground(frclr);
		l1.setForeground(frclr);
		l2.setForeground(frclr);
		l3.setForeground(frclr);
		w11.setForeground(frclr);
		w12.setForeground(frclr);
		w13.setForeground(frclr);
		w21.setForeground(frclr);
		w22.setForeground(frclr);
		w23.setForeground(frclr);
		w31.setForeground(frclr);
		w32.setForeground(frclr);
		w33.setForeground(frclr);
		setVisible(true);
	    add.addActionListener(e ->
	    {
	    	add_rec();
	    });
	    dlt.addActionListener(e ->
	    {
	    	delete_rec();
	    });
	    vw.addActionListener(e ->
	    {
	    	view_rec();
	    });
	    vw_r.addActionListener(e ->
	    {
	    	view_rand_rec();
	    });
	    abt.addActionListener(e ->
	    {
	    	about_wrd();
	    });
	    cls.addActionListener(e ->
	    {
	    	System.exit(0);
	    });
	}
	
	public static void about_wrd(){
		JFrame about_pr = new JFrame("About Worderize Lite");
		
		about_pr.setBounds(300, 90, 525, 224);
		about_pr.setResizable(false);
		JPanel c1 = new JPanel(new SpringLayout());
		
		q1 = new JLabel("Worderize Lite is a free and open-source software distributed under the", SwingConstants.CENTER);
		q1.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(q1);
		
		q2 = new JLabel("MIT License, that is designed to make the language learning more effective.", SwingConstants.CENTER);
		q2.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(q2);
		
		q3 = new JLabel("For more information please visit:", SwingConstants.CENTER);
		q3.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(q3);
		
		tl1 = new TextField("https://github.com/Northstrix/Worderize",SwingConstants.CENTER);
		tl1.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(tl1);
		
		tl2 = new TextField("https://sourceforge.net/projects/worderize-lite/", SwingConstants.CENTER);
		tl2.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(tl2);
		
		tl3 = new TextField("https://osdn.net/projects/worderize-lite/", SwingConstants.CENTER);
		tl3.setFont(new Font("Arial", Font.PLAIN, 14));
		c1.add(tl3);
		
		JButton cl1 = new JButton("OK");

		c1.setBackground(gclr);
		q1.setForeground(frclr);
		q2.setForeground(frclr);
		q3.setForeground(frclr);
		tl1.setForeground(frclr);
		tl2.setForeground(frclr);
		tl3.setForeground(frclr);
	    tl1.setBackground(gclr);
	    tl2.setBackground(gclr);
	    tl3.setBackground(gclr);
		cl1.setForeground(frclr);
	    cl1.setBackground(gclr);
		
	    c1.add(cl1);

		about_pr.add(c1);
		c1.setLayout(new GridLayout(7, 1));
		about_pr.setVisible(true);
	    
		cl1.addActionListener(e ->
	    {
	    	about_pr.dispose();
	    });
	}
	
	public static void add_rec() {
		JFrame addrc = new JFrame("Add record");
		
		addrc.setTitle("Add record");
		addrc.setBounds(300, 90, 858, 300);
		addrc.setResizable(false);
		JPanel c1 = new JPanel(new SpringLayout());

		JMenuBar menu_b1 = new JMenuBar();
		JButton add_r = new JButton("Add");
		JButton canc = new JButton("Cancel");
		menu_b1.add(add_r);
		menu_b1.add(canc);
		addrc.setJMenuBar(menu_b1);
		add_r.setBackground(gclr);
		canc.setBackground(rclr);
		add_r.setForeground(frclr);
		canc.setForeground(frclr);
		
		q1 = new JLabel("Language 1", SwingConstants.CENTER);
		q1.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q1);
		q2 = new JLabel("Language 2", SwingConstants.CENTER);
		q2.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q2);
		q3 = new JLabel("Language 3", SwingConstants.CENTER);
		q3.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q3);
		
		tl1 = new TextField("",SwingConstants.CENTER);
		tl1.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tl1);
		
		tl2 = new TextField("", SwingConstants.CENTER);
		tl2.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tl2);
		
		tl3 = new TextField("", SwingConstants.CENTER);
		tl3.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tl3);
		
		q4 = new JLabel("Word 1 Lang. 1", SwingConstants.CENTER);
		q4.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q4);
		q5 = new JLabel("Word 1 Lang. 2", SwingConstants.CENTER);
		q5.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q5);
		q6 = new JLabel("Word 1 Lang. 3", SwingConstants.CENTER);
		q6.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q6);
		
		tw11 = new TextField("",SwingConstants.CENTER);
		tw11.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw11);

		tw12 = new TextField("", SwingConstants.CENTER);
		tw12.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw12);
		
		tw13 = new TextField("", SwingConstants.CENTER);
		tw13.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw13);
		
		q7 = new JLabel("Word 2 Lang. 1", SwingConstants.CENTER);
		q7.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q7);
		q8 = new JLabel("Word 2 Lang.2", SwingConstants.CENTER);
		q8.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q8);
		q9 = new JLabel("Word 2 Lang. 3", SwingConstants.CENTER);
		q9.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q9);
		
		tw21 = new TextField("",SwingConstants.CENTER);
		tw21.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw21);
		
		tw22 = new TextField("", SwingConstants.CENTER);
		tw22.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw22);
		
		tw23 = new TextField("", SwingConstants.CENTER);
		tw23.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw23);

		q10 = new JLabel("Word 3 Lang. 1", SwingConstants.CENTER);
		q10.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q10);
		q11 = new JLabel("Word 3 Lang. 2", SwingConstants.CENTER);
		q11.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q11);
		q12 = new JLabel("Word 3 Lang. 3", SwingConstants.CENTER);
		q12.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(q12);
		
		tw31 = new TextField("",SwingConstants.CENTER);
		tw31.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw31);
		
		tw32 = new TextField("", SwingConstants.CENTER);
		tw32.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw32);
		
		tw33 = new TextField("", SwingConstants.CENTER);
		tw33.setFont(new Font("Arial", Font.PLAIN, 18));
		c1.add(tw33);

		c1.setBackground(gclr);
		tl1.setForeground(frclr);
		tl2.setForeground(frclr);
		tl3.setForeground(frclr);
		tw11.setForeground(frclr);
		tw12.setForeground(frclr);
		tw13.setForeground(frclr);
		tw21.setForeground(frclr);
		tw22.setForeground(frclr);
		tw23.setForeground(frclr);
		tw31.setForeground(frclr);
		tw32.setForeground(frclr);
		tw33.setForeground(frclr);
	    tl1.setBackground(black_cl);
	    tl2.setBackground(black_cl);
	    tl3.setBackground(black_cl);
	    tw11.setBackground(black_cl);
	    tw12.setBackground(black_cl);
	    tw13.setBackground(black_cl);
	    tw21.setBackground(black_cl);
	    tw22.setBackground(black_cl);
	    tw23.setBackground(black_cl);
	    tw31.setBackground(black_cl);
	    tw32.setBackground(black_cl);
	    tw33.setBackground(black_cl);
		
		addrc.add(c1);
		
	    add_r.addActionListener(e ->
	    {
	    	add_record(
	    			Base64.getEncoder().encodeToString(tl1.getText().getBytes()), Base64.getEncoder().encodeToString(tl2.getText().getBytes()), Base64.getEncoder().encodeToString(tl3.getText().getBytes()),
	    			Base64.getEncoder().encodeToString(tw11.getText().getBytes()), Base64.getEncoder().encodeToString(tw12.getText().getBytes()), Base64.getEncoder().encodeToString(tw13.getText().getBytes()),
	    			Base64.getEncoder().encodeToString(tw21.getText().getBytes()), Base64.getEncoder().encodeToString(tw22.getText().getBytes()), Base64.getEncoder().encodeToString(tw23.getText().getBytes()),
	    			Base64.getEncoder().encodeToString(tw31.getText().getBytes()), Base64.getEncoder().encodeToString(tw32.getText().getBytes()), Base64.getEncoder().encodeToString(tw33.getText().getBytes())
	    			);
	    	addrc.dispose();
	    });
	    canc.addActionListener(e ->
	    {
	    	addrc.dispose();
	    });
		
		c1.setLayout(new GridLayout(8, 3));
		addrc.setVisible(true);
	    return;
	}
	
	public static String gen_rnd(int n) {
        StringBuilder str = new StringBuilder();
		SecureRandom number = new SecureRandom();
		for (int i = 0; i < n; i++) {
		 str.append((char)(65 + (number.nextInt(26))));
		}
		return str.toString();
	}
	
	public static void create_table() {
	      Connection c = null;
	      Statement stmt = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE if not exists Words" +
                   " (ID           TEXT      NOT NULL, " + 
                   " L1 TEXT NOT NULL, L2 TEXT NOT NULL, L3 TEXT NOT NULL, " + 
                   " W11 TEXT NOT NULL, W12 TEXT NOT NULL, W13 TEXT NOT NULL, " +
                   " W21 TEXT NOT NULL, W22 TEXT NOT NULL, W23 TEXT NOT NULL, " + 
                   " W31 TEXT NOT NULL, W32 TEXT NOT NULL, W33 TEXT NOT NULL)"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.close();
	      } catch ( Exception e ) {
	    	 JFrame f1=new JFrame();  
	    	 JOptionPane.showMessageDialog(f1,e.getClass().getName() + ": " + e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);     
	         System.exit(0);
	      }
	      return;
	}
	
	public static void add_record(String lang1, String lang2, String lang3, String WR11, String WR12, String WR13, String WR21, String WR22, String WR23, String WR31, String WR32, String WR33) {
	      Connection c = null;
	      Statement stmt = null;
	      String id = gen_rnd(96);
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
	         c.setAutoCommit(false);

	         stmt = c.createStatement();
	         String sql = "INSERT INTO Words (ID, L1, L2, L3, W11, W12, W13, W21, W22, W23, W31, W32, W33) " +
	                      "VALUES ('"+id+"', '"+lang1+"', '"+lang2+"', '"+lang3+"', '"+WR11+"', '"+WR12+"', '"+WR13+"', '"+WR21+"', '"+WR22+"', '"+WR23+"', '"+WR31+"', '"+WR32+"', '"+WR33+"' );"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
	    	 JFrame f2 = new JFrame();  
	    	 JOptionPane.showMessageDialog(f2,e.getClass().getName() + ": " + e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);  
	         System.exit(0);
	      }
	      return;
	}
	
	public static void view_rand_rec() {
		   Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Words" );
		      int nmb_of_r = number_of_recs();
		      String rcrds[] = new String [nmb_of_r + 1];
		      int n = 0;
		      while (rs.next()) {
		    	 rcrds[n] = (rs.getString("ID"));
		    	 n++;
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		      SecureRandom number = new SecureRandom();
		      int rn = number.nextInt(n);
		      disp_sel_rec(rcrds[rn]);
		   } catch ( Exception e ) {
			  JFrame f4=new JFrame();  
			  JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   return;
	}
	
	public static void view_rec() {
		   Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Words" );
			  JFrame remrec = new JFrame("View record");
		      JMenuBar rm = new JMenuBar();
		      int nmb_of_r = number_of_recs();
		      String rcrds[][] = new String [nmb_of_r + 1][2];
			  JComboBox records = new JComboBox();
		      int n = 0;
		      while (rs.next()) {
		    	 rcrds[n][0] = (rs.getString("ID"));
		    	 String qw11 = rs.getString("W11");
		    	 String qw21 = rs.getString("W21");
		    	 String qw31 = rs.getString("W31");
		    	 byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
		    	 String dw11 = new String(decodedBytes11);
		    	 byte[] decodedBytes21 = Base64.getDecoder().decode(qw21);
		    	 String dw21 = new String(decodedBytes21);
		    	 byte[] decodedBytes31 = Base64.getDecoder().decode(qw31);
		    	 String dw31 = new String(decodedBytes31);
		    	 rcrds[n][1] = (dw11 + ", " + dw21 + ", " + dw31);
		    	 n++;
		      }
		      int m = 0;
		      while (rcrds[m][0] != null) {
		    	 m++;
		      }
		      for(int i = 0; i < m; i++) {
		    	  records.addItem(rcrds[i][1]);
		      }
		      remrec.setJMenuBar(rm);
			  rm.add(records);
			  JButton rmv = new JButton(" View ");  
		      JButton cncl = new JButton("Cancel");   
		      rm.add(rmv);  
		      rm.add(cncl);  
		      rmv.setForeground(frclr);
		      rmv.setBackground(gclr);
		      cncl.setForeground(frclr);
		      cncl.setBackground(rclr);
		      remrec.setSize(600, 68);  
		      remrec.setVisible(true); 
		      rs.close();
		      stmt.close();
		      c.close(); 
			    rmv.addActionListener(e ->
		        {
		        	disp_sel_rec(rcrds[records.getSelectedIndex()][0]);
		        	remrec.dispose();
	   	
		        });
			    cncl.addActionListener(e ->
		        {
		        	remrec.dispose();
	   	
		        });
		   } catch ( Exception e ) {
			  JFrame f4=new JFrame();  
			  JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   return;
	}
	
	public static void disp_sel_rec(String id) {
		   Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
		      c.setAutoCommit(false);

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Words WHERE ID = '" + id +"'");
		      while ( rs.next() ) {
			    	 String ql1 = rs.getString("L1");
			    	 String ql2 = rs.getString("L2");
			    	 String ql3 = rs.getString("L3");
			    	 byte[] decodedByteslq1 = Base64.getDecoder().decode(ql1);
			    	 String lng1 = new String(decodedByteslq1);
			    	 byte[] decodedByteslq2 = Base64.getDecoder().decode(ql2);
			    	 String lng2 = new String(decodedByteslq2);
			    	 byte[] decodedByteslq3 = Base64.getDecoder().decode(ql3);
			    	 String lng3 = new String(decodedByteslq3);
			    	 String qw11 = rs.getString("W11");
			    	 String qw21 = rs.getString("W21");
			    	 String qw31 = rs.getString("W31");
			    	 byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
			    	 String dw11 = new String(decodedBytes11);
			    	 byte[] decodedBytes21 = Base64.getDecoder().decode(qw21);
			    	 String dw21 = new String(decodedBytes21);
			    	 byte[] decodedBytes31 = Base64.getDecoder().decode(qw31);
			    	 String dw31 = new String(decodedBytes31);
			    	 String qw12 = rs.getString("W12");
			    	 String qw22 = rs.getString("W22");
			    	 String qw32 = rs.getString("W32");
			    	 byte[] decodedBytes12 = Base64.getDecoder().decode(qw12);
			    	 String dw12 = new String(decodedBytes12);
			    	 byte[] decodedBytes22 = Base64.getDecoder().decode(qw22);
			    	 String dw22 = new String(decodedBytes22);
			    	 byte[] decodedBytes32 = Base64.getDecoder().decode(qw32);
			    	 String dw32 = new String(decodedBytes32);
			    	 String qw13 = rs.getString("W13");
			    	 String qw23 = rs.getString("W23");
			    	 String qw33 = rs.getString("W33");
			    	 byte[] decodedBytes13 = Base64.getDecoder().decode(qw13);
			    	 String dw13 = new String(decodedBytes13);
			    	 byte[] decodedBytes23 = Base64.getDecoder().decode(qw23);
			    	 String dw23 = new String(decodedBytes23);
			    	 byte[] decodedBytes33 = Base64.getDecoder().decode(qw33);
			    	 String dw33 = new String(decodedBytes33);
			    	 l1.setText(lng1);
			    	 l2.setText(lng2);
			    	 l3.setText(lng3);
			    	 w11.setText(dw11);
			    	 w12.setText(dw12);
			    	 w13.setText(dw13);
			    	 w21.setText(dw21);
			    	 w22.setText(dw22);
			    	 w23.setText(dw23);
			    	 w31.setText(dw31);
			    	 w32.setText(dw32);
			    	 w33.setText(dw33);
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
			  JFrame f5 = new JFrame();  
			  JOptionPane.showMessageDialog(f5,e.getClass().getName() + ": " + e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);  
		      System.exit(0);
		   }
	}
	
	public static void remove_rec(String t_rem) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
	         c.setAutoCommit(false);

	         stmt = c.createStatement();
	         String sql = "DELETE from Words where ID='"+t_rem+"';";
	         stmt.executeUpdate(sql);
	         c.commit();
	         c.close();
	      } catch ( Exception e ) {
			  JFrame f6 = new JFrame();  
			  JOptionPane.showMessageDialog(f6,e.getClass().getName() + ": " + e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);  
		      System.exit(0);
	      }
	      return;
	}
	
	public static int number_of_recs() {
		   Connection c = null;
		   Statement stmt = null;
		   int nmb = 0;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
		      c.setAutoCommit(false);

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Words;" );
		      while ( rs.next() ) {
		    	  nmb ++;
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   return nmb;
	}
	
	public static void delete_rec() {
		   Connection c = null;
		   Statement stmt = null;
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Worderize.db");
		      c.setAutoCommit(false);
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Words" );
			  JFrame remrec = new JFrame("Delete record");
		      JMenuBar rm = new JMenuBar();
		      int nmb_of_r = number_of_recs();
		      String rcrds[][] = new String [nmb_of_r + 1][2];
			  JComboBox records = new JComboBox();
		      int n = 0;
		      while (rs.next()) {
		    	 rcrds[n][0] = (rs.getString("ID"));
		    	 String qw11 = rs.getString("W11");
		    	 String qw21 = rs.getString("W21");
		    	 String qw31 = rs.getString("W31");
		    	 byte[] decodedBytes11 = Base64.getDecoder().decode(qw11);
		    	 String dw11 = new String(decodedBytes11);
		    	 byte[] decodedBytes21 = Base64.getDecoder().decode(qw21);
		    	 String dw21 = new String(decodedBytes21);
		    	 byte[] decodedBytes31 = Base64.getDecoder().decode(qw31);
		    	 String dw31 = new String(decodedBytes31);
		    	 rcrds[n][1] = (dw11 + ", " + dw21 + ", " + dw31);
		    	 n++;
		      }
		      int m = 0;
		      while (rcrds[m][0] != null) {
		    	 m++;
		      }
		      for(int i = 0; i < m; i++) {
		    	  records.addItem(rcrds[i][1]);
		      }
		      remrec.setJMenuBar(rm);
			  rm.add(records);
			  JButton rmv = new JButton("Delete");  
		      JButton cncl = new JButton("Cancel");   
		      rm.add(rmv);  
		      rm.add(cncl);  
		      rmv.setForeground(frclr);
		      rmv.setBackground(rclr);
		      cncl.setForeground(frclr);
		      cncl.setBackground(gclr);
		      remrec.setSize(600, 68);  
		      remrec.setVisible(true); 
		      rs.close();
		      stmt.close();
		      c.close(); 
			    rmv.addActionListener(e ->
		        {
		        	remove_rec(rcrds[records.getSelectedIndex()][0]);
		        	remrec.dispose();
	   	
		        });
			    cncl.addActionListener(e ->
		        {
		        	remrec.dispose();
	   	
		        });
		   } catch ( Exception e ) {
			  JFrame f4=new JFrame();  
			  JOptionPane.showMessageDialog(f4, e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   return;
	}

}


class Worderize {

	public static void main(String[] args) throws Exception
	{
		Worderize_main.create_table();
		Worderize_main Words = new Worderize_main();
	}
}